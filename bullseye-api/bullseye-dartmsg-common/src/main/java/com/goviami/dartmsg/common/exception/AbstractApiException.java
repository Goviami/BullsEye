package com.goviami.dartmsg.common.exception;

import com.goviami.dartmsg.common.model.ApiErrorCode;

public class AbstractApiException extends RuntimeException {
	/**
	 * Error Code Object.
	 */
	private ApiErrorCode apiErrorCode;

	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public AbstractApiException() {
		super();
	}

	public AbstractApiException(final String message) {
		super(message);
	}

	public AbstractApiException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public AbstractApiException(final Throwable cause) {
		super(cause);
	}

	public AbstractApiException(final ApiErrorCode apiErrorCode) {
		this.apiErrorCode = apiErrorCode;
	}

	/**
	 * @return the apiErrorCode
	 */
	public ApiErrorCode getApiErrorCode() {
		return apiErrorCode;
	}

}
