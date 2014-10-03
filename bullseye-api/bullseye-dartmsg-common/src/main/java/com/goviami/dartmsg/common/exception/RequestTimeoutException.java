package com.goviami.dartmsg.common.exception;

import com.goviami.dartmsg.common.model.ApiErrorCode;

public class RequestTimeoutException extends AbstractApiException {

	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public RequestTimeoutException() {
		super();
	}

	public RequestTimeoutException(final String message) {
		super(message);
	}

	public RequestTimeoutException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public RequestTimeoutException(final Throwable cause) {
		super(cause);
	}

	public RequestTimeoutException(final ApiErrorCode apiErrorCode) {
		super(apiErrorCode);
	}

}
