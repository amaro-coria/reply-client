/**
 * Teknei 2016
 */
package com.teknei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main application class
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class ReplyClientApplication {

	/**
	 * Main entry point
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ReplyClientApplication.class, args);
	}
}
