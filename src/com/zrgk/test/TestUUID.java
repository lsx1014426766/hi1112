package com.zrgk.test;

import java.util.UUID;

// UUID(32λ 16���Ƶ��ַ���)
public class TestUUID {
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();
		System.out.println(s);
	}

}
