package com.goviami.dartmsg.common.exception;

import com.goviami.dartmsg.common.model.ApiErrorCode;

public class UnauthorizedException extends AbstractApiException {

	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public UnauthorizedException() {
		super();
	}

	public UnauthorizedException(final String message) {
		super(message);
	}

	public UnauthorizedException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UnauthorizedException(final Throwable cause) {
		super(cause);
	}

	public UnauthorizedException(final ApiErrorCode apiErrorCode) {
		super(apiErrorCode);
	}

}
