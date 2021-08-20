package com.example.myblog.entities;

import lombok.Data;

@Data
public class ResponseObj {

	private int status;
	private String message;
	private long timeStamp;

}
