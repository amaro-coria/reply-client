/**
 * Teknei 2016
 */
package com.teknei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.teknei.controller.ReplyBusController;
import com.teknei.service.client.ApiTestClient;
import com.teknei.util.ReplyOptions;

/**
 * Main application class
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0 
 *
 */
@SpringBootApplication
@EnableScheduling
@EnableFeignClients
@EnableEurekaClient
public class ReplyClientApplication {

	private static final Logger log = LoggerFactory.getLogger(ReplyClientApplication.class);

	/**
	 * Main entry point 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean reply = false;
		boolean test = false;
		if (args == null || args.length == 0) {
			log.info(
					"No known option, invoke following: '-v' for version , '-t' for testing , '-h' for help, '-r' for start reply service");
			log.info("Exiting with code 1");
			System.exit(1);
		} else {
			if (args[0].equalsIgnoreCase("-v")) {
				log.info("TKN_VERSION:{}", "1.0.0");
				System.exit(0);
			} else if (args[0].equalsIgnoreCase("-r")) {
				log.info("Runnig to listen to reply");
				reply = true;
			} else if (args[0].equalsIgnoreCase("-t")) {
				log.debug("TKN Unit testing");
				test = true;
			} else if (args[0].equalsIgnoreCase("-h")) {
				log.info("Application for send transactional records to reply server");
				log.info("The application in this version suports the following reply tables:");
				log.info("sbop_turn");
				log.info("sbop_acce_sali");
				log.info("sbop_tran");
				log.info("sbop_tran_divi");
				log.info("sbop_reca");
				log.info("sbop_reca_divi");
				log.info("sbop_cont_acce");
				log.info("sbop_asgn_turn");
				log.info("sfru_asgn");
				log.info("caup_tran");
				log.info("caup_dist_posv");
				log.info("caup_tadi_posv");
				log.info("sfmo_hist_rece_nave");
				log.info("Usage:  '-v' for version , '-t' for testing , '-h' for help, '-r' for reply");
				log.info(
						"For specify application.properties use '--spring.config.location=<FULL_CONFIG_PATH_TO_YML_FILE>' as last command parameter");
				log.info(
						"Example: java -jar reply-server.jar -t --spring.config.location=/home/teknei/SITM/CONFIG/tkn_reply_client.yml");
				System.exit(0);
			} else {
				log.info(
						"No known option, invoke following: '-v' for version , '-t' for testing , '-h' for help, '-r' for reply");
				log.info("Exiting with code 1");
				System.exit(1);
			}
		}
		ConfigurableApplicationContext ctx = SpringApplication.run(ReplyClientApplication.class, args);
		if (test) {
			ApiTestClient apiTest = ctx.getBean(ApiTestClient.class);
			boolean successCon = apiTest.testConnection();
			log.info("Connection status: {}", successCon);
		} else if (reply) {
			System.out.println("##############################################");
			System.out.println("   ###########  ###     ###   #####     ###");
			System.out.println("       ###      ###   ####    ### ###   ###");
			System.out.println("       ###      ### #####     ###  ###  ###");
			System.out.println("       ###      ######        ###   ### ###");
			System.out.println("       ###      ###  ####     ###    ######");
			System.out.println("       ###      ####  ####    ###     #####");
			System.out.println("##############################################");
			System.out.println("TKN service started");
		}
	}
}
