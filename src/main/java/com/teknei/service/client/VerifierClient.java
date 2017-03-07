/**
 * Teknei 2016
 */
package com.teknei.service.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teknei.dto.ResponseDTO;

/**
 * API client for remote services
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@FeignClient(url = "${tkn.api.url}", name = "apiVerifierClient", fallback = VerifierClientFailureHandler.class)
public interface VerifierClient {

	/**
	 * Consumes the remote API
	 * 
	 * @param idEqui
	 *            - the id of the equipment
	 * @return
	 */
	@RequestMapping(value = "count/{idEqui}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ResponseDTO> count(@PathVariable("idEqui") Integer idEqui);

	/**
	 * Consumes the remote API
	 * 
	 * @param idEqui
	 *            - the id of the equipment
	 * @param startDate
	 *            - the start date of the comparison
	 * @return
	 */
	@RequestMapping(value = "count/{idEqui}/{startDate}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ResponseDTO> countStartDate(@PathVariable("idEqui") Integer idEqui,
			@PathVariable("startDate") String startDate);

	/**
	 * Consumes the remote API
	 * 
	 * @param idEqui
	 *            - the id of the equipment
	 * @param startDate
	 *            - the start date of the comparison
	 * @param endDate
	 *            the end date of the comparison
	 * @return
	 */
	@RequestMapping(value = "count/{idEqui}/{startDate}/{endDate}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ResponseDTO> countBetweenDates(@PathVariable("idEqui") Integer idEqui,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate);

	/**
	 * Consumes the remote API
	 * 
	 * @param idEqui
	 *            - the id of the equipment
	 * @param startDate
	 *            - the start date of the comparison
	 * @param endDate
	 *            the end date of the comparison
	 * @param apiOption
	 *            - the api option given
	 * @return
	 */
	@RequestMapping(value = "count/{idEqui}/{startDate}/{endDate}/{apiOption}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ResponseDTO> countBetweenDatesAndAPIOption(@PathVariable("idEqui") Integer idEqui,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate,
			@PathVariable("apiOption") Integer apiOption);
}
