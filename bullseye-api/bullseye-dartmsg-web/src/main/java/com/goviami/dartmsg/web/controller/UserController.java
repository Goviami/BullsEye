package com.goviami.dartmsg.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.goviami.dartmsg.model.User;
import com.goviami.dartmsg.model.UserDetails;
import com.goviami.dartmsg.model.UserRegister;
import com.goviami.dartmsg.service.api.UserService;

@RestController
@RequestMapping(value = "/service/user")
public class UserController {
	/**
	 * User Service Instance.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Register New User.
	 * 
	 * @param userRegister {@link UserRegister}
	 * @return {@link User}
	 * @throws Exception {@link Exception}
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody User registerUser(@RequestBody UserRegister userRegister) throws Exception {
		return userService.registerUser(userRegister);
	}

	/**
	 * Update User Details.
	 * 
	 * @param userId User Id
	 * @param userDetails {@link UserDetails}
	 * @return {@link User}
	 * @throws Exception {@link Exception}
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public @ResponseBody User updateUserDetails(@PathVariable(value = "userId") String userId,
			@RequestBody UserDetails userDetails) throws Exception {
		return userService.updateUserDetails(userId, userDetails);
	}

	/**
	 * Get User Details.
	 * 
	 * @param userId User Id
	 * @return {@link User}
	 * @throws Exception {@link Exception}
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable(value = "userId") String userId) throws Exception {
		return userService.getUser(userId);
	}
}
