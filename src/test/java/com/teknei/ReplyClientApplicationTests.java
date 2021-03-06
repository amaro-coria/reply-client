package com.teknei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyClientApplicationTests {

	@Value("${tkn.api.url}")
	private String urlBase;
	private static final Logger log = LoggerFactory.getLogger(ReplyClientApplicationTests.class);

	@Test
	public void contextLoads() {
	}


}
