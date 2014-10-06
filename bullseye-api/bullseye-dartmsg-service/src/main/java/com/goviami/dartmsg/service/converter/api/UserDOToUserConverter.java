package com.goviami.dartmsg.service.converter.api;

import org.springframework.core.convert.converter.Converter;

import com.goviami.dartmsg.dataaccess.domain.UserDO;
import com.goviami.dartmsg.model.User;

public final class UserDOToUserConverter implements Converter<UserDO, User> {

	@Override
	public User convert(final UserDO userDO) {
		final User user = new User();
		user.setUserId(userDO.getUserId());
		user.setCountry(userDO.getCountry());
		user.setPhone(userDO.getPhone());
		user.setEmail(userDO.getEmail());
		user.setMood(userDO.getMood());
		user.setNickName(userDO.getNickName());		
		user.setCreatedTs(userDO.getCreatedTs());
		user.setUpdatedTs(userDO.getUpdatedTs());
		return user;
	}

}
