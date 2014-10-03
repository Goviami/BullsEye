package com.goviami.dartmsg.common.exception;

import com.goviami.dartmsg.common.model.ApiErrorCode;

public class DuplicateEntityException extends AbstractApiException {

	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateEntityException() {
		super();
	}

	public DuplicateEntityException(final String message) {
		super(message);
	}

	public DuplicateEntityException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public DuplicateEntityException(final Throwable cause) {
		super(cause);
	}

	public DuplicateEntityException(final ApiErrorCode apiErrorCode) {
		super(apiErrorCode);
	}

}
