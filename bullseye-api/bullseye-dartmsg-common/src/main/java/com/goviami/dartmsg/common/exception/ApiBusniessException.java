package com.goviami.dartmsg.common.exception;

import com.goviami.dartmsg.common.model.ApiErrorCode;

public class ApiBusniessException extends AbstractApiException {

	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public ApiBusniessException() {
		super();
	}

	public ApiBusniessException(final String message) {
		super(message);
	}

	public ApiBusniessException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ApiBusniessException(final Throwable cause) {
		super(cause);
	}

	public ApiBusniessException(final ApiErrorCode apiErrorCode) {
		super(apiErrorCode);
	}
}
