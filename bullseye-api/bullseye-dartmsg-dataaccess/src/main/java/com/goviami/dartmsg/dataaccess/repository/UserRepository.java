package com.goviami.dartmsg.dataaccess.repository;

import org.springframework.data.repository.CrudRepository;

import com.goviami.dartmsg.dataaccess.domain.UserDO;

public interface UserRepository extends CrudRepository<UserDO, String>, UserRepositoryCustom {
	/**
	 * Get User By Phone and Country.
	 * 
	 * @param phone Phone No.
	 * @param country Country Code
	 * @return {@link UserDO}
	 */
	UserDO findByPhoneAndCountry(String phone, String country);
}
