package com.goviami.dartmsg.service.converter.db;

import org.springframework.core.convert.converter.Converter;

import com.goviami.dartmsg.dataaccess.domain.UserDO;
import com.goviami.dartmsg.model.UserRegister;

public class UserRegistryToUserDOConverter implements Converter<UserRegister, UserDO> {

	@Override
	public UserDO convert(final UserRegister userRegister) {
		final UserDO userDO = new UserDO();
		userDO.setCountry(userRegister.getCountry());
		userDO.setPhone(userRegister.getPhone());
		return userDO;
	}

}
