package com.goviami.dartmsg.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Avatar implements Serializable {
	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Avatar Id.
	 */
	public String avatarId;
	/**
	 * Avatar Image Bytes.
	 */
	public byte[] imgBytes;

	/**
	 * @return the avatarId
	 */
	public String getAvatarId() {
		return avatarId;
	}

	/**
	 * @param avatarId the avatarId to set
	 */
	public void setAvatarId(final String avatarId) {
		this.avatarId = avatarId;
	}

	/**
	 * @return the imgBytes
	 */
	public byte[] getImgBytes() {
		return imgBytes;
	}

	/**
	 * @param imgBytes the imgBytes to set
	 */
	public void setImgBytes(final byte[] imgBytes) {
		this.imgBytes = imgBytes;
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
