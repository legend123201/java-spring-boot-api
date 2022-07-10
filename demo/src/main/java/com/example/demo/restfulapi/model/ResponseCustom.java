package com.example.demo.restfulapi.model;

public class ResponseCustom<T> {
	private T data;
	private String message;

	public ResponseCustom() {
		super();
	}

	public ResponseCustom(T data, String message) {
		super();
		this.data = data;
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseCustom [data=" + data + ", message=" + message + "]";
	}

}
