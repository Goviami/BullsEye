package com.goviami.dartmsg.dataaccess.repository.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goviami.dartmsg.dataaccess.config.DataaccessAppBoot;
import com.goviami.dartmsg.dataaccess.domain.UserDO;
import com.goviami.dartmsg.dataaccess.repository.UserRepository;
import com.mongodb.gridfs.GridFSFile;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DataaccessAppBoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserRepositoryImpl {
	/**
	 * User Repository Instance.
	 */
	@Autowired
	private UserRepository userRepository;
	/**
	 * Test Object.
	 */
	private UserDO userDO;

	@Before
	public void setup() {
		userDO = new UserDO();
		userDO.setCountry("IN");
		userDO.setPhone("123456789");
		userDO.setEmail("test@test.com");
		userDO.setNickName("testuser");
	}

	/**
	 * Method to test insertion of new user.
	 */
	@Test
	public void testUserCRUD() throws Exception {
		userRepository.insert(userDO);
		Assert.assertNotNull(userDO);
		Assert.assertNotNull(userDO.getUserId());
		UserDO userDO1 = userRepository.findOne(userDO.getUserId());
		Assert.assertNotNull(userDO1);
		Assert.assertEquals(userDO.getCountry(), userDO1.getCountry());
		userRepository.delete(userDO1);
	}

	@Test
	public void testSaveAvatar() throws Exception {
		URL url = ClassLoader.getSystemResource("images/logo.png");
		InputStream is = new BufferedInputStream(new FileInputStream(url.getFile()));
		GridFSFile file = userRepository.saveAvatar(is, "logo.png", "image/png", null);
		Assert.assertNotNull(file);
		Assert.assertNotNull(file.getId());
		userRepository.deletAvatar(file.getId().toString());
	}
}
