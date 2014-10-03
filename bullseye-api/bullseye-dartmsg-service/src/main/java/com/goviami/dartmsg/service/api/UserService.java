package com.goviami.dartmsg.service.api;

import com.goviami.dartmsg.model.User;
import com.goviami.dartmsg.model.UserDetails;
import com.goviami.dartmsg.model.UserRegister;

public interface UserService {
	/**
	 * Register New User.
	 * 
	 * @param userRegister {@link UserRegister}
	 * @return {@link User}
	 * @throws Exception {@link Exception}
	 */
	User registerUser(final UserRegister userRegister) throws Exception;

	/**
	 * Update User Details.
	 * 
	 * @param userId User Id.
	 * @param userDetails {@link UserDetails}
	 * @return {@link User}
	 * @throws Exception {@link Exception}
	 */
	User updateUserDetails(final String userId, final UserDetails userDetails) throws Exception;

	/**
	 * Get User.
	 * 
	 * @param userId User Id.
	 * @return {@link User}
	 * @throws Exception {@link Exception}
	 */
	User getUser(final String userId) throws Exception;

}
