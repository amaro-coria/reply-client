/**
 * Teknei 2016
 */
package com.teknei.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.teknei.dto.ReplyStatusDTO;
import com.teknei.util.UtilConstants;

/**
 * Service class for monitoring reply status
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service
public class FileStatusService {

	/*
	 * Injected value 
	 */
	@Value("tkn.reply.status.file")
	private String url;

	/**
	 * Writes the current status to a log file
	 * @param status - the status to be written
	 * @return boolean if success, false otherwise
	 */
	public boolean writeStatusFile(ReplyStatusDTO status) {
		try {
			Files.write(Paths.get(url), status.toString().getBytes());
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the status as a String
	 * @return  the status of the reply operation
	 */
	public String getStatus() {
		try {
			String content = new String(Files.readAllBytes(Paths.get(url)));
			return content;
		} catch (IOException e) {
			return UtilConstants.NOT_APPLICABLE;
		}
	}

	/**
	 * Deletes the file for status
	 */
	public void deleteStatusFile() {
		try {
			Files.delete(Paths.get(url));
		} catch (IOException e) {
		}
	}

}
