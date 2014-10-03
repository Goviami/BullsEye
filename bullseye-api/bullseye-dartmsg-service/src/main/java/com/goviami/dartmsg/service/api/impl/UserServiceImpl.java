package com.goviami.dartmsg.service.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.goviami.dartmsg.common.exception.RequestValidationException;
import com.goviami.dartmsg.common.exception.UnprocessableEntityException;
import com.goviami.dartmsg.common.model.ApiErrorCode;
import com.goviami.dartmsg.dataaccess.domain.UserDO;
import com.goviami.dartmsg.dataaccess.domain.UserDetailsDO;
import com.goviami.dartmsg.dataaccess.repository.UserRepository;
import com.goviami.dartmsg.model.User;
import com.goviami.dartmsg.model.UserDetails;
import com.goviami.dartmsg.model.UserRegister;
import com.goviami.dartmsg.service.api.UserService;
import com.goviami.dartmsg.service.util.ErrorConstants;
import com.goviami.dartmsg.service.validator.UserValidator;

@Service
public class UserServiceImpl implements UserService {
	/**
	 * User Repository Instance.
	 */
	@Autowired
	private UserRepository userRepository;
	/**
	 * Conversion Service Instance.
	 */
	@Autowired
	private ConversionService conversionService;

	/**
	 * Register New User.
	 * 
	 * @param userRegister {@link UserRegister}
	 * @return {@link User}
	 * @throws Exception {@link Exception}
	 */
	@Override
	public User registerUser(final UserRegister userRegister) throws Exception {
		UserValidator.validateUserRegister(userRegister);
		UserDO userDO = userRepository.findByPhoneAndCountry(userRegister.getPhone(), userRegister.getCountry());
		if (userDO != null) {
			throw new RequestValidationException(new ApiErrorCode(ErrorConstants.CONFLICT,
					ErrorConstants.ALREADY_REGISTERED));
		}
		userDO = conversionService.convert(userRegister, UserDO.class);
		userRepository.insert(userDO);
		return conversionService.convert(userDO, User.class);
	}

	/**
	 * Update User Details.
	 * 
	 * @param userId User Id.
	 * @param userDetails {@link UserDetails}
	 * @return {@link User}
	 * @throws Exception {@link Exception}
	 */
	@Override
	public User updateUserDetails(final String userId, final UserDetails userDetails) throws Exception {
		UserValidator.validateUserDetails(userDetails);
		if (!userRepository.exists(userId)) {
			throw new UnprocessableEntityException(new ApiErrorCode(ErrorConstants.UNPROCESSABLE_ENTITY,
					ErrorConstants.DEV_UNPROCESSABEL_ENTITY));
		}
		if (userDetails.getAvatar() != null && userDetails.getAvatar().getImgBytes() != null) {
			// save avatar. and get avatar id to update user.
		}
		final UserDetailsDO detailsDO = conversionService.convert(userDetails, UserDetailsDO.class);
		UserDO userDO = userRepository.updateUserDetails(userId, detailsDO);
		return conversionService.convert(userDO, User.class);
	}

	/**
	 * Get User.
	 * 
	 * @param userId User Id.
	 * @return {@link User}
	 * @throws Exception {@link Exception}
	 */
	@Override
	public User getUser(final String userId) throws Exception {
		// Get the user details from user table.
		UserDO userDO = userRepository.findOne(userId);
		if (userDO == null) {
			throw new UnprocessableEntityException(new ApiErrorCode(ErrorConstants.UNPROCESSABLE_ENTITY,
					ErrorConstants.DEV_UNPROCESSABEL_ENTITY));
		}
		User user = conversionService.convert(userDO, User.class);
		// Get Avatar if the user has one
		/*
		 * if (!StringUtils.isBlank(userDO.getAvatarId())) { GridFSFile gridFSFile =
		 * userRepository.getAvatar(userDO.getAvatarId()); }
		 */
		return user;
	}

}
