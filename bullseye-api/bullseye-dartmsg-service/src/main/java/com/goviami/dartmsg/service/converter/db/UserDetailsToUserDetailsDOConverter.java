package com.goviami.dartmsg.service.converter.db;

import org.springframework.core.convert.converter.Converter;

import com.goviami.dartmsg.dataaccess.domain.UserDetailsDO;
import com.goviami.dartmsg.model.UserDetails;

public class UserDetailsToUserDetailsDOConverter implements Converter<UserDetails, UserDetailsDO> {

	@Override
	public UserDetailsDO convert(final UserDetails userDetails) {
		UserDetailsDO userDetailsDO = new UserDetailsDO();
		userDetailsDO.setNickName(userDetails.getNickName());
		userDetailsDO.setMood(userDetails.getMood());
		if (userDetails.getAvatar() != null) {
			userDetailsDO.setAvatarId(userDetails.getAvatar().getAvatarId());
		}
		return userDetailsDO;
	}

}
