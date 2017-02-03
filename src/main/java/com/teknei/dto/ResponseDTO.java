/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for wrapping response values
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Data
@AllArgsConstructor
public class ResponseDTO implements Serializable{

	private String statusCode;
	private String message;
	
}
