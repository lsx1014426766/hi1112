package com.zrgk.test;

import java.util.UUID;

// UUID(32位 16进制的字符串)
public class TestUUID {
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();
		System.out.println(s);
	}

}
