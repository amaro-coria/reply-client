/**
 * Teknei 2016
 */
package com.teknei.service;

import java.util.Date;

import com.teknei.dto.ResponseDTO;
import com.teknei.util.ReplySpeedOption;

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

	/**
	 * Replicates the data according to the speed provided
	 * @param replySpeed - the name of the speed provided
	 * @return DTO containing the status code of the operation
	 */
	ResponseDTO replyData(ReplySpeedOption replySpeed);

	long countDataForDay(Date startDate, Date endDate);

}
