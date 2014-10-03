package com.goviami.dartmsg.dataaccess.repository.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

import java.io.InputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.goviami.dartmsg.dataaccess.domain.UserDO;
import com.goviami.dartmsg.dataaccess.domain.UserDetailsDO;
import com.goviami.dartmsg.dataaccess.repository.UserRepositoryCustom;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSFile;

public class UserRepositoryImpl implements UserRepositoryCustom {
	/**
	 * MongoTemplate Instance.
	 */
	@Autowired
	private MongoTemplate mongoTemplate;
	/**
	 * GridFsTemplate Instance.
	 */
	@Autowired
	@Qualifier("avatarGridFsTemplate")
	private GridFsTemplate gridFsTemplate;

	/**
	 * Insert User.
	 * 
	 * @param userDO {@link UserDO}
	 * @return {@link UserDO}
	 */
	public UserDO insert(final UserDO userDO) {
		userDO.setCreatedTs(new Date());
		mongoTemplate.insert(userDO);
		return userDO;
	}

	/**
	 * Update User details.
	 * 
	 * @param userId User Id
	 * @param detailsDO User Details Object
	 * @return {@link UserDO}
	 */
	public UserDO updateUserDetails(final String userId, final UserDetailsDO detailsDO) {
		final Update update = new Update();
		if (detailsDO.getNickName() != null) {
			update.set("nickName", detailsDO.getNickName());
		}
		if (detailsDO.getStatus() != null) {
			update.set("status", detailsDO.getStatus());
		}
		if (detailsDO.getAvatarId() != null) {
			update.set("avatarId", detailsDO.getAvatarId());
		}
		update.set("updatedTs", new Date());
		UserDO userDO = mongoTemplate.findAndModify(query(where("userId").is(userId)), update,
				new FindAndModifyOptions().returnNew(true), UserDO.class);
		return userDO;
	}

	/**
	 * Get User Avatar Id.
	 * 
	 * @param userId User Id
	 * @return Avatar Id.
	 */
	public String getUserAvatarId(final String userId) {
		final Query query = new Query();
		query.fields().include("avatarId");
		final String avatarId = mongoTemplate.findOne(query(where("userId").is(userId)), String.class);
		return avatarId;
	}

	/**
	 * Update User Avatar Id.
	 * 
	 * @param userId User Id
	 * @param avatarId Avatar Id
	 */
	public void updateUserAvatarId(final String userId, final String avatarId) {
		mongoTemplate.updateFirst(query(where("userId").is(userId)), update("avatarId", avatarId), UserDO.class);
	}

	/**
	 * Save user avatar.
	 * 
	 * @param is content input stream
	 * @param fileName file name
	 * @param contentType content type of the file
	 * @param metadata file metadata
	 * @return {@link GridFSFile}
	 */
	public GridFSFile saveAvatar(final InputStream is, final String fileName, final String contentType,
			final DBObject metadata) {
		final GridFSFile file = gridFsTemplate.store(is, fileName, contentType, metadata);
		return file;
	}

	/**
	 * Get User Avatar.
	 * 
	 * @param avatarId Avatar Id
	 * @return {@link GridFSFile}
	 */
	public GridFSFile getAvatar(final String avatarId) {
		final GridFSFile file = gridFsTemplate.findOne(query(where("_id").is(avatarId)));
		return file;
	}

	/**
	 * Delete User avatar.
	 * 
	 * @param avatarId Avatar Id
	 */
	public void deletAvatar(final String avatarId) {
		gridFsTemplate.delete(query(where("_id").is(avatarId)));
	}

}
