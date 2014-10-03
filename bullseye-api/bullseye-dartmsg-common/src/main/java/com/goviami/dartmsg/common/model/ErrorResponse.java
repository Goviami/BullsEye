package com.goviami.dartmsg.common.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ErrorResponse implements Serializable {
	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Error Code.
	 */
	private int errorId;
	/**
	 * Error Text.
	 */
	private String errorText;
	/**
	 * Developer Text.
	 */
	private String developerText;

	/**
	 * @return the errorId
	 */
	public int getErrorId() {
		return errorId;
	}

	/**
	 * @param errorId the errorId to set
	 */
	public void setErrorId(final int errorId) {
		this.errorId = errorId;
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
	public void setErrorText(final String errorText) {
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
	public void setDeveloperText(final String developerText) {
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
