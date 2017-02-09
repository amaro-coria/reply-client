/**
 * Teknei 2016
 */
package com.teknei.service.client;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.teknei.dto.ResponseDTO;

/**
 * Test class for connection
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component
public class ApiTestClient {

	@Value("${tkn.api.url}")
	private String urlBase;
	private static final Logger log = LoggerFactory.getLogger(ApiTestClient.class);

	/**
	 * Test connection against API
	 * 
	 * @return true if success, false otherwise
	 */
	public boolean testConnection() {
		String message = UUID.randomUUID().toString();
		RestTemplate template = new RestTemplate();
		String url = "http://" + urlBase + "/test/echo/" + message;
		log.info("Testing against: {}", url);
		ResponseDTO dto = template.getForObject(url, ResponseDTO.class);
		if (dto == null) {
			return false;
		}
		String messageResponse = dto.getMessage();
		if (messageResponse.equals(message)) {
			return true;
		}
		return false;
	}
}
