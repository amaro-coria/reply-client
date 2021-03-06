/**
 * Teknei 2016
 */
package com.teknei.service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.CollectionUtils;

import com.teknei.dto.ResponseDTO;
import com.teknei.service.assembler.Assembler;
import com.teknei.service.client.ApiClient;
import com.teknei.util.ReplySpeedOption;
import com.teknei.util.UtilConstants;

/**
 * Generic business class parameterized with arguments for reflection
 * invocation. If custom behavior needed, must provide other implementation.
 * Behavior:
 * 
 * <pre>
 *  
 * 1) Collects 50 records from database with 'false' flag
 * </pre>
 * 
 * <pre>
 *  
 * 2) Transform to DTO representation
 * </pre>
 * 
 * <pre>
 * 3) Send via API - JSON to server (according to method name provided)
 * </pre>
 * 
 * <pre>
 *  4) Returns remote response
 * </pre>
 * 
 * <pre>
 *  5) According to response, if success updates local records with 'true' flag
 * </pre>
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <Envi>
 *            The class of the Entity mapping for 'pendings' scheme
 * @param <EnviID>
 *            The class of the PK of the Entity mapping of 'pendings' scheme
 * @param <Disp>
 *            The class of the Entity mapping for 'business' scheme
 * @param <DispID>
 *            The class of the PK of the Entity mapping for 'business' scheme
 * @param <DTO>
 *            The DTO class
 */
public class ReplyServiceImpl<Envi, EnviID extends Serializable, Disp, DispID extends Serializable, DTO>
		implements ReplyService {

	/**
	 * Args constructor
	 * 
	 * @param classDispID
	 *            - Class of the Business PK
	 * @param daoEnvi
	 *            - Crud repository for pendings scheme
	 * @param daoDisp
	 *            - Crud repository for business scheme
	 * @param assembler
	 *            - Implementation for assembling services
	 * @param nameApiMethod
	 *            - Name of the business API call
	 * @param apiClient
	 *            - Feign client
	 */
	public ReplyServiceImpl(Class<DispID> classDispID, CrudRepository<Envi, EnviID> daoEnvi,
			CrudRepository<Disp, DispID> daoDisp, Assembler<DTO, Disp> assembler, String nameApiMethod,
			ApiClient apiClient) {
		this.typeDispID = classDispID;
		this.daoEnvi = daoEnvi;
		this.daoDisp = daoDisp;
		this.assembler = assembler;
		this.nameApiMethod = nameApiMethod;
		this.apiClient = apiClient;
	}

	/*
	 * Provided variables
	 */
	private Class<DispID> typeDispID;
	private CrudRepository<Envi, EnviID> daoEnvi;
	private CrudRepository<Disp, DispID> daoDisp;
	private Assembler<DTO, Disp> assembler;
	private String nameApiMethod;
	private ApiClient apiClient;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.ReplyService#countMoreData()
	 */
	@Override
	public long countMoreData() {
		try {
			Class<?> clazzEnviDAOImpl = daoEnvi.getClass();
			Method countMoreDataMethod = clazzEnviDAOImpl.getMethod("countByBolEnvi", boolean.class);
			long counter = (long) countMoreDataMethod.invoke(daoEnvi, new Object[] { false });
			return counter;
		} catch (ReflectiveOperationException e) {
			return 1l;
		}
	}
	
	@Override
	public long countDataForDay(Date startDate, Date endDate){
		try {
			Class<?> clazzEnviDAOImpl = daoEnvi.getClass();
			Method countMoreDataMethod = clazzEnviDAOImpl.getMethod("countByBolEnviAndFchEnviBetween", boolean.class, Date.class, Date.class);
			long counter = (long) countMoreDataMethod.invoke(daoEnvi, new Object[] { true , startDate, endDate });
			return counter;
		} catch (ReflectiveOperationException e) {
			return -1l;
		}
	}

	/* (non-Javadoc)
	 * @see com.teknei.service.ReplyService#replyData(com.teknei.util.ReplySpeedOption)
	 */
	@Override
	public ResponseDTO replyData(ReplySpeedOption replySpeed) {
		ResponseDTO dto = replyDataMeta(replySpeed.getMethodName());
		return dto;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.ReplyService#replyBlockData()
	 */
	@Override
	public ResponseDTO replyBlockData() {
		ResponseDTO dto = replyDataMeta("findTop1000ByBolEnviOrderByFchEnviAsc");
		if(dto != null && dto.getStatusCode().equals(UtilConstants.STATUS_OK)){
			dto = replyDataMeta("findTop1000ByBolEnviOrderByFchEnviDesc");
		}
		return dto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.ReplyService#replyData()
	 */
	@Override
	public ResponseDTO replyData() {
		ResponseDTO dto = replyDataMeta("findTop50ByBolEnviOrderByFchEnviAsc");
		return dto;
	}

	/**
	 * General invoker for reply data to remote API
	 * 
	 * @param methodName
	 *            - the method to invoke via reflection
	 * @return - the DTO wrapping response
	 */
	private ResponseDTO replyDataMeta(String methodName) {
		try {
			// Declares a list of EnviPK records
			List<EnviID> listEnviID = new ArrayList<>();
			// Obtains runtime class for Envi object
			Class<?> clazzEnviDAOImpl = daoEnvi.getClass();
			// Obtain method reference
			Method findTop50 = clazzEnviDAOImpl.getMethod(methodName, boolean.class);
			// Invoke and obtain
			Object o = findTop50.invoke(daoEnvi, new Object[] { false });
			List<Envi> listEnvi = (List<Envi>) findTop50.invoke(daoEnvi, new Object[] { false });
			List<Disp> listDisp = listEnvi.stream().map(e -> {
				// Fills the object via reflection
				PropertyAccessor propertyAccessorEnvi = PropertyAccessorFactory.forBeanPropertyAccess(e);
				EnviID enviIDObj = (EnviID) propertyAccessorEnvi.getPropertyValue("id");
				PropertyAccessor propertyAccessorEnviPK = PropertyAccessorFactory.forBeanPropertyAccess(enviIDObj);
				listEnviID.add(enviIDObj);
				DispID dispIDObj = null;
				try {
					dispIDObj = typeDispID.newInstance();
				} catch (InstantiationException | IllegalAccessException e1) {
				}
				PropertyAccessor propertyAccesosDispPK = PropertyAccessorFactory.forBeanPropertyAccess(dispIDObj);
				Field[] fields = typeDispID.getDeclaredFields();
				for (Field f : fields) {
					String name = "";
					try {
						name = f.getName();
						if (name.equals("serialVersionUID")) {
							continue;
						}
						Object valuePK = propertyAccessorEnviPK.getPropertyValue(name);
						propertyAccesosDispPK.setPropertyValue(name, valuePK);
					} catch (InvalidPropertyException ipe) {
					}
				}
				Disp d = daoDisp.findOne(dispIDObj);
				// Update if no source found
				if (d == null) {
					PropertyAccessor propertyAccessorEnviFirst = PropertyAccessorFactory.forBeanPropertyAccess(e);
					propertyAccessorEnviFirst.setPropertyValue("bolEnvi", true);
					propertyAccessorEnviFirst.setPropertyValue("codEnvi", UtilConstants.NOT_FOUND);
					daoEnvi.save(e);
					return null;
				}
				return d;
			}).collect(Collectors.toList());
			// Collects and transforms to DTO list
			List<DTO> listDTO = listDisp.stream().map(d -> assembler.getDTO(d)).collect(Collectors.toList());
			// Obtain method reference to API
			List<DTO> listDTOToSend = new ArrayList<>();
			if (CollectionUtils.isEmpty(listDTO)) {
				return new ResponseDTO(UtilConstants.STATUS_OK, UtilConstants.MESSAGE_OK);
			}
			listDTO.forEach(d -> {
				if (d != null) {
					listDTOToSend.add(d);
				}
			});
			Method apiMethod = ApiClient.class.getMethod(nameApiMethod, List.class);
			// Invoke and wait for response
			ResponseDTO responseDTO = (ResponseDTO) apiMethod.invoke(apiClient, listDTOToSend);
			if (responseDTO != null && responseDTO.getStatusCode().equals(UtilConstants.STATUS_OK)) {
				listEnviID.forEach(s -> {
					// Update local resources
					Envi e = daoEnvi.findOne(s);
					PropertyAccessor propertyAccessorEnvi = PropertyAccessorFactory.forBeanPropertyAccess(e);
					propertyAccessorEnvi.setPropertyValue("bolEnvi", true);
					propertyAccessorEnvi.setPropertyValue("codEnvi", UtilConstants.STATUS_OK);
					daoEnvi.save(e);
				});
			}
			return responseDTO;
		} catch (ReflectiveOperationException e) {
			return new ResponseDTO(UtilConstants.STATUS_REFLECTION, UtilConstants.MESSAGE_REFLECTION);
		}
	}

}
