package com.goviami.dartmsg.dataaccess.repository;

import java.io.InputStream;

import com.goviami.dartmsg.dataaccess.domain.UserDO;
import com.goviami.dartmsg.dataaccess.domain.UserDetailsDO;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSFile;

public interface UserRepositoryCustom {
	/**
	 * Insert User.
	 * 
	 * @param userDO {@link UserDO}
	 * @return {@link UserDO}
	 */
	UserDO insert(final UserDO userDO);

	/**
	 * Update User details.
	 * 
	 * @param userId User Id
	 * @param detailsDO User Details Object
	 * @return {@link UserDO}
	 */
	UserDO updateUserDetails(final String userId, final UserDetailsDO detailsDO);

	/**
	 * Save user avatar.
	 * 
	 * @param is content input stream
	 * @param fileName file name
	 * @param contentType content type of the file
	 * @param metadata file metadata
	 * @return {@link GridFSFile}
	 */
	GridFSFile saveAvatar(final InputStream is, final String fileName, final String contentType, final DBObject metadata);

	/**
	 * Get User Avatar.
	 * 
	 * @param avatarId Avatar Id
	 * @return {@link GridFSFile}
	 */
	GridFSFile getAvatar(final String avatarId);

	/**
	 * Delete User avatar.
	 * 
	 * @param avatarId Avatar Id
	 */
	void deletAvatar(final String avatarId);

	/**
	 * Get User Avatar Id.
	 * 
	 * @param userId User Id
	 * @return Avatar Id.
	 */
	String getUserAvatarId(final String userId);

	/**
	 * Update User Avatar Id.
	 * 
	 * @param userId User Id
	 * @param avatarId Avatar Id
	 */
	void updateUserAvatarId(final String userId, final String avatarId);
}
