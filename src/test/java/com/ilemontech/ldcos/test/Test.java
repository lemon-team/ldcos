package com.ilemontech.ldcos.test;

import org.apache.commons.codec.digest.DigestUtils;

public class Test {

	
	public static void main(String[] args) {
	
		String admin="admin";
		System.out.println(DigestUtils.md5Hex(admin));
	}
}
