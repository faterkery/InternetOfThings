package com.renhenet.util;

public class TestBlockCipherTool {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.err.println("source =" + args[0]);
			String en = SecurityUtil.encrypt(args[0]);
			System.err.println("encrypt =" + en);
			System.err.println("decrypt =" + SecurityUtil.decrypt(en));
		}

	}
}
