package com.goviami.dartmsg.service.validator;

import java.util.Locale;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import com.goviami.dartmsg.common.exception.RequestValidationException;
import com.goviami.dartmsg.model.UserDetails;
import com.goviami.dartmsg.model.UserRegister;
import com.goviami.dartmsg.service.util.ErrorConstants;
import com.goviami.dartmsg.service.util.ServiceUtil;

public final class UserValidator {
	/**
	 * Validate user registry fields.
	 * 
	 * @param userRegister {@link UserRegister}
	 */
	public static void validateUserRegister(final UserRegister userRegister) {
		if (StringUtils.isBlank(userRegister.getCountry())) {
			throw new RequestValidationException(ServiceUtil.reqValidationError(ErrorConstants.COUNTRY_CODE));
		}
		if (!ArrayUtils.contains(Locale.getISOCountries(), userRegister.getCountry())) {
			throw new RequestValidationException(ServiceUtil.reqValidationError(ErrorConstants.COUNTRY_CODE));
		}
		if (StringUtils.isBlank(userRegister.getPhone())) {
			throw new RequestValidationException(ServiceUtil.reqValidationError(ErrorConstants.PHONE_NUMBER));
		}
		if (StringUtils.isBlank(userRegister.getEmail())) {
			throw new RequestValidationException(ServiceUtil.reqValidationError(ErrorConstants.EMAIL_ADDRESS));
		}
		if (!EmailValidator.getInstance().isValid(userRegister.getEmail())) {
			throw new RequestValidationException(ServiceUtil.reqValidationError(ErrorConstants.EMAIL_ADDRESS));
		}
	}

	/**
	 * Validate USer Details.
	 * 
	 * @param userDetails {@link UserDetails}
	 */
	public static void validateUserDetails(final UserDetails userDetails) {
		if (userDetails.getNickName() == null && userDetails.getStatus() == null
				&& (userDetails.getAvatar() == null || userDetails.getAvatar().getImgBytes() == null)) {
			throw new RequestValidationException(ServiceUtil.reqValidationError(ErrorConstants.INVALID_REQUEST));
		}
	}
}
