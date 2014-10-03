package com.goviami.dartmsg.common.util;

import org.junit.Assert;
import org.junit.Test;

public class TestSecurityUtil {

	/**
	 * Test Decrypt.
	 * 
	 * @throws Exception {@link Exception}
	 */
	@Test
	public void testDecryptData() throws Exception {
		String data = "hello";
		// Generate Salt Key
		String salt = SecurityUtil.generateSalt();
		// Encrypt data.
		String encrytedString = SecurityUtil.encryptData(data, salt);
		Assert.assertNotNull(encrytedString);
		// Decrypt data.
		String decrytedString = SecurityUtil.decryptData(encrytedString, salt);
		Assert.assertNotNull(decrytedString);
		Assert.assertEquals(data, decrytedString);
	}
}
