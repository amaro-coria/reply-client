/**
 * Teknei 2016
 */
package com.teknei.service;

import com.teknei.dto.ResponseDTO;

/**
 * Business generic interface
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface ReplyService {

	/**
	 * Replicate the local data to the remote API
	 * @return DTO containing the status code of the operation
	 */
	ResponseDTO replyData();
	
	/**
	 * Replicate the local data to the remote API (bigger blocks)
	 * @return DTO containing the status code of the operation
	 */
	ResponseDTO replyBlockData();
	
	/**
	 * Counts the remaining records to send via API
	 * @return 0 if no remaining, the total otherwise
	 */
	long countMoreData();

}
