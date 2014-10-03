package com.goviami.dartmsg.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.goviami.dartmsg.common.model.ApiErrorCode;
import com.goviami.dartmsg.common.model.ErrorResponse;

@Component
public class ErrorResponseUtil {
	@Autowired
	private Environment environment;
	
	public ErrorResponse converErrorCode(final ApiErrorCode errorCode) {
		ErrorResponse response = new ErrorResponse();
		getErrorId(response, errorCode.getErrorId());
		getErrorText(response, errorCode.getErrorText(), response.getErrorId());
		getDeveloperText(response, errorCode.getDeveloperText(), errorCode.getDeveloperTextId());
		return response;
	}

	private void getErrorId(final ErrorResponse response, final int errorId) {
		if (errorId == 0) {
			response.setErrorId(ApiErrorCode.DEFAULT_EXCEPTION);
		} else {
			response.setErrorId(errorId);
		}
	}

	private void getErrorText(final ErrorResponse response, final String errorText, final int errorId) {
		if (StringUtils.isBlank(errorText)) {
			String errorKey = String.valueOf(errorId);
			if (environment.containsProperty(errorKey)) {
				response.setErrorText(environment.getProperty(errorKey));
			} else {
				response.setErrorText("No error message property set for code " + errorId);
			}
		} else {
			response.setErrorText(errorText);
		}
	}

	private void getDeveloperText(final ErrorResponse response, final String developerText, final int developerTextId) {
		if (StringUtils.isBlank(developerText)) {
			if (developerTextId == 0) {
				response.setDeveloperText(null);
			} else {
				String errorKey = String.valueOf(developerTextId);
				if (environment.containsProperty(errorKey)) {
					response.setDeveloperText(environment.getProperty(errorKey));
				} else {
					response.setDeveloperText("No error message property set for code " + developerTextId);
				}
			}
		} else {
			response.setErrorText(developerText);
		}
	}

}
