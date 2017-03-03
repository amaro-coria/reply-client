package com.teknei.util;

public enum ReplySpeedOption {

	REPLY_SPEED_VIA("findTop50ByBolEnviOrderByFchEnviAsc"), REPLY_SPEED_VIA_FAST(
			"findTop500ByBolEnviOrderByFchEnviAsc"), REPLY_SPEED_CDE(
					"findTop1000ByBolEnviOrderByFchEnviAsc"), REPLY_SPEED_CDE_FAST(
							"findTop2000ByBolEnviOrderByFchEnviAsc");

	private String methodName;

	ReplySpeedOption(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodName() {
		return methodName;
	}
	

}
