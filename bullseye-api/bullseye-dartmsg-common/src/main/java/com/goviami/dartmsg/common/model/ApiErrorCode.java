package com.goviami.dartmsg.common.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiErrorCode {
	/**
	 * Default Exception code.
	 */
	public static final int DEFAULT_EXCEPTION = 100099;
	/**
	 * Error Code.
	 */
	private int errorId;
	/**
	 * Developer Text Message Id.
	 */
	private int developerTextId;
	/**
	 * Error Text.
	 */
	private String errorText;
	/**
	 * Developer Text Message.
	 */
	private String developerText;

	/**
	 * Default Contructor.
	 */
	public ApiErrorCode() {
		// empty
	}

	/**
	 * Param Constructor
	 * 
	 * @param errorId Error Code
	 * @param developerTextId Developer Error Text Id
	 */
	public ApiErrorCode(final int errorId, final int developerTextId) {
		this.errorId = errorId;
		this.developerTextId = developerTextId;
	}

	/**
	 * Param Constructor.
	 * 
	 * @param errorId Error Code
	 * @param errorText Error Text
	 * @param developerText Developer Error Text
	 */
	public ApiErrorCode(final int errorId, final String errorText, final String developerText) {
		this.errorId = errorId;
		this.errorText = errorText;
		this.developerText = developerText;
	}

	/**
	 * Param Constructor.
	 * 
	 * @param errorId Error Code
	 * @param errorText Error Text
	 * @param developerTextId Developer Error Text Id
	 */
	public ApiErrorCode(final int errorId, final String errorText, final int developerTextId) {
		this.errorId = errorId;
		this.errorText = errorText;
		this.developerTextId = developerTextId;
	}

	/**
	 * @return the errorId
	 */
	public int getErrorId() {
		return errorId;
	}

	/**
	 * @param errorId the errorId to set
	 */
	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	/**
	 * @return the developerTextId
	 */
	public int getDeveloperTextId() {
		return developerTextId;
	}

	/**
	 * @param developerTextId the developerTextId to set
	 */
	public void setDeveloperTextId(int developerTextId) {
		this.developerTextId = developerTextId;
	}

	/**
	 * @return the errorText
	 */
	public String getErrorText() {
		return errorText;
	}

	/**
	 * @param errorText the errorText to set
	 */
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	/**
	 * @return the developerText
	 */
	public String getDeveloperText() {
		return developerText;
	}

	/**
	 * @param developerText the developerText to set
	 */
	public void setDeveloperText(String developerText) {
		this.developerText = developerText;
	}

	@Override
	public boolean equals(final Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
