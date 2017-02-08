/**
 * Teknei 2016
 */
package com.teknei.service.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teknei.dto.ResponseDTO;
import com.teknei.dto.SbopAcceSaliDTO;
import com.teknei.dto.SbopAsgnTurnDTO;
import com.teknei.dto.SbopRecaDTO;
import com.teknei.dto.SbopRecaDiviDTO;
import com.teknei.dto.SbopTranDTO;
import com.teknei.dto.SbopTranDiviDTO;
import com.teknei.dto.SbopTurnDTO;

/**
 * Rest automated client via Spring for remote API
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@FeignClient(url = "${tkn.api.url}", name = "apiClient", fallback = ApiClientFailureHandler.class)
public interface ApiClient {

	/**
	 * Method for send collection of DTO records to the remote API via REST
	 * 
	 * @param list
	 *            the collection to send
	 * @return the remote response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "turn/save")
	ResponseDTO sendTurnRecords(@RequestBody List<SbopTurnDTO> list);

	/**
	 * Method for send collection of DTO records to the remote API via REST
	 * 
	 * @param list
	 *            the collection to send
	 * @return the remote response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "acce/save")
	ResponseDTO sendAcceRecords(@RequestBody List<SbopAcceSaliDTO> list);

	/**
	 * Method for send collection of DTO records to the remote API via REST
	 * 
	 * @param list
	 *            the collection to send
	 * @return the remote response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "asgn/save")
	ResponseDTO sendAsgnTurnRecords(@RequestBody List<SbopAsgnTurnDTO> list);

	/**
	 * Method for send collection of DTO records to the remote API via REST
	 * 
	 * @param list
	 *            the collection to send
	 * @return the remote response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "tran/save")
	ResponseDTO sendTranRecords(@RequestBody List<SbopTranDTO> list);

	/**
	 * Method for send collection of DTO records to the remote API via REST
	 * 
	 * @param list
	 *            the collection to send
	 * @return the remote response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "tranDivi/save")
	ResponseDTO sendTranDiviRecords(@RequestBody List<SbopTranDiviDTO> list);

	/**
	 * Method for send collection of DTO records to the remote API via REST
	 * 
	 * @param list
	 *            the collection to send
	 * @return the remote response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "reca/save")
	ResponseDTO sendRecaRecords(@RequestBody List<SbopRecaDTO> list);

	/**
	 * Method for send collection of DTO records to the remote API via REST
	 * 
	 * @param list
	 *            the collection to send
	 * @return the remote response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "recaDivi/save")
	ResponseDTO sendRecaDiviRecords(@RequestBody List<SbopRecaDiviDTO> list);

	/**
	 * Method for send collection of DTO records to the remote API via REST
	 * 
	 * @param list
	 *            the collection to send
	 * @return the remote response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "cont/save")
	ResponseDTO sendContAcceRecords(@RequestBody List<SbopRecaDiviDTO> list);

}
