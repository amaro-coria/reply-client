package com.teknei;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.teknei.dto.ResponseDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyClientApplicationTests {

	@Value("${tkn.api.url}")
	private String urlBase;
	private static final Logger log = LoggerFactory.getLogger(ReplyClientApplicationTests.class);

	@Test
	public void contextLoads() {
	}

	@Test
	public void testConnection() {
		String message = UUID.randomUUID().toString();
		RestTemplate template = new RestTemplate();
		String url = "http://"+urlBase + "/test/echo/" + message;
		log.info("Testing against: {}", url);
		ResponseDTO dto = template.getForObject(url, ResponseDTO.class);
		assertNotNull(dto);
		String messageResponse = dto.getMessage();
		assertEquals(message, messageResponse);
	}

}
