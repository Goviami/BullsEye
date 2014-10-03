package com.goviami.dartmsg.common.exception;

import com.goviami.dartmsg.common.model.ApiErrorCode;

public class UnprocessableEntityException extends AbstractApiException {

	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public UnprocessableEntityException() {
		super();
	}

	public UnprocessableEntityException(final String message) {
		super(message);
	}

	public UnprocessableEntityException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UnprocessableEntityException(final Throwable cause) {
		super(cause);
	}

	public UnprocessableEntityException(final ApiErrorCode apiErrorCode) {
		super(apiErrorCode);
	}

}
