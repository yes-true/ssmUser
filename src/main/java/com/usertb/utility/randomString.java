package com.usertb.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class randomString {

	static final String[] EN = new String[] { "A", "B", "C", "D", "E",
			"F", "G", "H", "I", "J", "K", "L", "M", "N","O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
			"b", "c", "d", "e", "f", "g", "h", "i","j", "k", "l", "m",
			"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public static String randonMember(){
		StringBuffer s = new StringBuffer();
		//将字符串转为list集合
		List<String> list = Arrays.asList(EN);
		for(int i=0;i<4;i++) {
			s.append(list.get((int) (Math.random()*list.size())-1));
		}
		return s.append((int)(Math.random()*9999999)).toString();
	}

}
