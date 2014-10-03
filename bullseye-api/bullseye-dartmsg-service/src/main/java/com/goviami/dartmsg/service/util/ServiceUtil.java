package com.goviami.dartmsg.service.util;

import com.goviami.dartmsg.common.model.ApiErrorCode;

public final class ServiceUtil {
	/**
	 * Construct Request Validation Error Code.
	 * 
	 * @param developerTextId developer text message id.
	 * @return {@link ApiErrorCode}
	 */
	public static ApiErrorCode reqValidationError(final int developerTextId) {
		return new ApiErrorCode(ErrorConstants.REQUEST_VALIDATION_ERROR, developerTextId);
	}
}
