package com.teknei.dto;

import java.io.Serializable;

import com.teknei.util.ReplyOptions;

import lombok.Data;

@Data
public class ReplyStatusDTO implements Serializable {

	private ReplyOptions replyOption;
	private Long remaining;

}
