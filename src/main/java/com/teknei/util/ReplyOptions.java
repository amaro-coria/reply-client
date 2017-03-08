/**
 * Teknei 2016
 */
package com.teknei.util;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Enum for Reply Options
 * 
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public enum ReplyOptions {

	SBOP_TURN(1), SBOP_ACCE_SALI(3), SBOP_TRAN(5), SBOP_TRAN_DIVI(6), SBOP_CONT_ACCE(4), SBOP_ASGN_TURN(2), SBOP_RECA(
			7), SBOP_RECA_DIVI(8), SFRU_ASGN(9), CAUP_TRAN(10), CAUP_DIST_POSV(11), CAUP_TADI_POSV(12), SFMO_HIST(
					16), SFVH_DATA_DIA(13), SFOP_MSG_COND(14), SFOP_EQUI_ALAR(15), SBOP_CONT_REPL(17), STATUS_FINISHED(
							0), REPLY_OPTION_SPEED_VIA(-1), REPLY_OPTION_SPEED_CDE(-2), REPLY_OPTION_FAST(-3);

	private int order;
	private final static Map<Integer, ReplyOptions> map = Arrays.stream(ReplyOptions.values())
			.collect(Collectors.toMap(t -> t.getOrder(), t -> t));

	ReplyOptions(int order) {
		this.order = order;
	}

	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	public static ReplyOptions getReplyOptionFromNumber(int number) {
		return map.get(number);
	}

}
