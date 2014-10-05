package com.goviami.dartmsg.web.handler;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.goviami.dartmsg.common.model.ErrorResponse;
import com.goviami.dartmsg.common.util.ErrorResponseUtil;
import com.goviami.dartmsg.service.util.ErrorConstants;

@ControllerAdvice
public class CustomeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * Loads all properties.
	 */
	@Autowired
	public Environment environment;
	/**
	 * ErrorResponse Utility Instance
	 */
	@Autowired
	public ErrorResponseUtil errorResponseUtil;

	@Override
	protected ResponseEntity<Object> handleNoSuchRequestHandlingMethod(NoSuchRequestHandlingMethodException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.NO_SUCH_REQUEST_HANDLING);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.NO_SUCH_REQUEST_HANDLING)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.REQUEST_METHOD_NOT_SUPPORTED);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.REQUEST_METHOD_NOT_SUPPORTED)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.MEDIA_TYPE_NOT_SUPPORTED);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.MEDIA_TYPE_NOT_SUPPORTED)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.MEDIA_TYPE_NOT_ACCEPTABLE);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.MEDIA_TYPE_NOT_ACCEPTABLE)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.MISSING_SERVLET_REQUEST_PARAMETER);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.MISSING_SERVLET_REQUEST_PARAMETER)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}
	
	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.SERVLET_REQUEST_BINDING_EXCEPTION);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.SERVLET_REQUEST_BINDING_EXCEPTION)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}
	
	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.CONVERSION_NOT_SUPPORTED);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.CONVERSION_NOT_SUPPORTED)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}
	
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.TYPE_MISMATCH);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.TYPE_MISMATCH)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.HTTP_MESSAGE_NOT_READABLE);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.HTTP_MESSAGE_NOT_READABLE)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.HTTP_MESSAGE_NOT_WRITABLE);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.HTTP_MESSAGE_NOT_WRITABLE)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.MISSING_SERVLET_REQUEST_PARAMETER);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.MISSING_SERVLET_REQUEST_PARAMETER)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}
	
	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.BIND_EXCEPTION);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.BIND_EXCEPTION)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorId(ErrorConstants.NO_HANDLER_FOUND);
		response.setErrorText(environment.getProperty(String.valueOf(ErrorConstants.NO_HANDLER_FOUND)));
		response.setDeveloperText(ex.getMessage());

		return new ResponseEntity<Object>(response, getHeader(), status);
	}
	
	/**
	 * Constructs JSON Header object.
	 * 
	 * @return {@link HttpHeaders}
	 */
	public HttpHeaders getHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
