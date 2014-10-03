package com.goviami.dartmsg.web.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.goviami.dartmsg.common.exception.ApiBusniessException;
import com.goviami.dartmsg.common.exception.DuplicateEntityException;
import com.goviami.dartmsg.common.exception.RequestTimeoutException;
import com.goviami.dartmsg.common.exception.RequestValidationException;
import com.goviami.dartmsg.common.exception.UnauthorizedException;
import com.goviami.dartmsg.common.exception.UnprocessableEntityException;
import com.goviami.dartmsg.common.model.ErrorResponse;
import com.goviami.dartmsg.common.util.ErrorResponseUtil;
import com.goviami.dartmsg.service.util.ErrorConstants;
import com.mongodb.MongoTimeoutException;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * Loads all properties.
	 */
	@Autowired
	private Environment environment;
	/**
	 * ErrorResponse Utility Instance
	 */
	@Autowired
	private ErrorResponseUtil errorResponseUtil;

	/**
	 * Handle Mongo Database Timeout Exceptions
	 * 
	 * @param ex {@link RuntimeException}
	 * @param request {@link WebRequest}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler({ MongoTimeoutException.class })
	protected ResponseEntity<Object> handleMongoTimeoutException(RuntimeException ex, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.MONGO_TIMEOUT);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.MONGO_TIMEOUT)));
		response.setDeveloperText(ex.getMessage());
		return handleExceptionInternal(ex, response, getHeader(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	/**
	 * Handle Data Access Exceptions
	 * 
	 * @param ex {@link RuntimeException}
	 * @param request {@link WebRequest}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler({ DataAccessException.class })
	protected ResponseEntity<Object> handleDataAccessException(RuntimeException ex, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.DATA_ACCESS_EXCEPTION);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.DATA_ACCESS_EXCEPTION)));
		response.setDeveloperText(ex.getMessage());
		return handleExceptionInternal(ex, response, getHeader(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	/**
	 * Handle Mongo General Exceptions
	 * 
	 * @param ex {@link RuntimeException}
	 * @param request {@link WebRequest}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<Object> handleDefaultExceptions(RuntimeException ex, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.DEFAULT_EXCEPTION);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.DEFAULT_EXCEPTION)));
		response.setDeveloperText(ex.getMessage());
		return handleExceptionInternal(ex, response, getHeader(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	/**
	 * Handle Request Validation Exceptions
	 * 
	 * @param ex {@link RuntimeException}
	 * @param request {@link WebRequest}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler({ RequestValidationException.class })
	protected ResponseEntity<Object> handleRequestValidationExceptions(RuntimeException ex, WebRequest request) {
		RequestValidationException exception = (RequestValidationException) ex;
		ErrorResponse response = errorResponseUtil.converErrorCode(exception.getApiErrorCode());
		return handleExceptionInternal(ex, response, getHeader(), HttpStatus.BAD_REQUEST, request);
	}

	/**
	 * Handle Business Exceptions
	 * 
	 * @param ex {@link RuntimeException}
	 * @param request {@link WebRequest}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler({ ApiBusniessException.class })
	protected ResponseEntity<Object> handleBusinessExceptions(RuntimeException ex, WebRequest request) {
		ApiBusniessException exception = (ApiBusniessException) ex;
		ErrorResponse response = errorResponseUtil.converErrorCode(exception.getApiErrorCode());
		return handleExceptionInternal(ex, response, getHeader(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	/**
	 * Handle Request Timeout Exceptions
	 * 
	 * @param ex {@link RuntimeException}
	 * @param request {@link WebRequest}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler({ RequestTimeoutException.class })
	protected ResponseEntity<Object> handleRequestTimeoutExceptions(RuntimeException ex, WebRequest request) {
		RequestTimeoutException exception = (RequestTimeoutException) ex;
		ErrorResponse response = errorResponseUtil.converErrorCode(exception.getApiErrorCode());
		return handleExceptionInternal(ex, response, getHeader(), HttpStatus.REQUEST_TIMEOUT, request);
	}

	/**
	 * Handle Unauthorized Exceptions
	 * 
	 * @param ex {@link RuntimeException}
	 * @param request {@link WebRequest}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler({ UnauthorizedException.class })
	protected ResponseEntity<Object> handleUnAuthorizedExceptions(RuntimeException ex, WebRequest request) {
		UnauthorizedException exception = (UnauthorizedException) ex;
		ErrorResponse response = errorResponseUtil.converErrorCode(exception.getApiErrorCode());
		return handleExceptionInternal(ex, response, getHeader(), HttpStatus.UNAUTHORIZED, request);
	}

	/**
	 * Handle UnProcessable Entity Exceptions
	 * 
	 * @param ex {@link RuntimeException}
	 * @param request {@link WebRequest}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler({ UnprocessableEntityException.class })
	protected ResponseEntity<Object> handleUnprcessableEntityExceptions(RuntimeException ex, WebRequest request) {
		UnprocessableEntityException exception = (UnprocessableEntityException) ex;
		ErrorResponse response = errorResponseUtil.converErrorCode(exception.getApiErrorCode());
		return handleExceptionInternal(ex, response, getHeader(), HttpStatus.UNPROCESSABLE_ENTITY, request);
	}

	/**
	 * Handle Duplicate Entity Exceptions
	 * 
	 * @param ex {@link RuntimeException}
	 * @param request {@link WebRequest}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler({ DuplicateEntityException.class })
	protected ResponseEntity<Object> handleDuplicateEntityExceptions(RuntimeException ex, WebRequest request) {
		DuplicateEntityException exception = (DuplicateEntityException) ex;
		ErrorResponse response = errorResponseUtil.converErrorCode(exception.getApiErrorCode());
		return handleExceptionInternal(ex, response, getHeader(), HttpStatus.CONFLICT, request);
	}

	/**
	 * Constructs JSON Header object.
	 * 
	 * @return {@link HttpHeaders}
	 */
	private HttpHeaders getHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
