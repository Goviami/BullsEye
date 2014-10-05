package com.goviami.dartmsg.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "service/user")
@Api(value = "", description = "Api's realted to basic user details", position = 1)
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
	@ApiOperation(value = "Register a new user", httpMethod = "POST", position = 1, response = User.class)
	public @ResponseBody ResponseEntity<User> registerUser(
			@ApiParam(name = "userRegister", value = "User Registration details", required = true, allowMultiple = false) @RequestBody UserRegister userRegister)
			throws Exception {
		final User user = userService.registerUser(userRegister);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
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
	@ApiOperation(value = "Update user details", httpMethod = "POST", position = 3, response = User.class)
	public @ResponseBody User updateUserDetails(
			@ApiParam(name = "userId", value = "User Id", required = true, allowMultiple = false) @PathVariable(value = "userId") String userId,
			@ApiParam(name = "userDetails", value = "User details", required = true, allowMultiple = false) @RequestBody UserDetails userDetails)
			throws Exception {
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
	@ApiOperation(value = "Get user", httpMethod = "GET", position = 2, response = User.class)
	public @ResponseBody User getUser(
			@ApiParam(name = "userId", value = "User Id", required = true, allowMultiple = false) @PathVariable(value = "userId") String userId)
			throws Exception {
		return userService.getUser(userId);
	}
}
