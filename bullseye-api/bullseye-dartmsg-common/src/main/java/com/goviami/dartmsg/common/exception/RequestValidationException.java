package com.goviami.dartmsg.common.exception;

import com.goviami.dartmsg.common.model.ApiErrorCode;

public class RequestValidationException extends AbstractApiException {

	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public RequestValidationException() {
		super();
	}

	public RequestValidationException(final String message) {
		super(message);
	}

	public RequestValidationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public RequestValidationException(final Throwable cause) {
		super(cause);
	}

	public RequestValidationException(final ApiErrorCode apiErrorCode) {
		super(apiErrorCode);
	}

}
