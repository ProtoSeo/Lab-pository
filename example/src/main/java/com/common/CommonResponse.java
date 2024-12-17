package com.common;

public class CommonResponse<T> {
	private T data;
	private String error;

	protected CommonResponse() {
	}

	public CommonResponse(T data, String error) {
		this.data = data;
		this.error = error;
	}

	public static <T> CommonResponse<T> success(T data) {
		return new CommonResponse<>(data, null);
	}

	public static CommonResponse<Void> error(String error) {
		return new CommonResponse<>(null, error);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
