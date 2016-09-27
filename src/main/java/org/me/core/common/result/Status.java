package org.me.core.common.result;

import java.io.Serializable;

public class Status implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String code;
	private boolean success;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
