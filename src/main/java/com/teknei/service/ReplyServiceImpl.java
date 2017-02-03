/**
 * Teknei 2016
 */
package com.teknei.service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.data.repository.CrudRepository;

import com.teknei.dto.ResponseDTO;
import com.teknei.service.assembler.Assembler;
import com.teknei.service.client.ApiClient;
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
	 * @see com.teknei.service.ReplyService#replyData()
	 */
	@Override
	public ResponseDTO replyData() {
		try {
			// Declares a list of EnviPK records
			List<EnviID> listEnviID = new ArrayList<>();
			// Obtains runtime class for Envi object
			Class<?> clazzEnviDAOImpl = daoEnvi.getClass();
			// Obtain method reference
			Method findTop50 = clazzEnviDAOImpl.getMethod("findTop50ByBolEnviOrderByFchEnviAsc", boolean.class);
			// Invoke and obtain
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
					try {
						String name = f.getName();
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
				}
				return d;
			}).collect(Collectors.toList());
			// Collects and transforms to DTO list
			List<DTO> listDTO = listDisp.stream().map(d -> assembler.getDTO(d)).collect(Collectors.toList());
			// Obtain method reference to API
			Method apiMethod = ApiClient.class.getMethod(nameApiMethod, List.class);
			// Invoke and wait for response
			ResponseDTO responseDTO = (ResponseDTO) apiMethod.invoke(apiClient, listDTO);
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
