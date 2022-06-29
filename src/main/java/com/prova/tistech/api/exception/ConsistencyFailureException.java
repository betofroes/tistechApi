package com.prova.tistech.api.exception;

public class ConsistencyFailureException extends RuntimeException{

	private static final long serialVersionUID = 4036476307321947248L;

	public ConsistencyFailureException(String msg) {
		super(msg);
	}
}
