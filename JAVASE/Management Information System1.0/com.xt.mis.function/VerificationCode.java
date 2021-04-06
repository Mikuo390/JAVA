/**
 * 
 */
package com.xt.mis.function;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 15159
 *
 */
public class VerificationCode {
	
	//验证码生成器
	public static String generateVerificationCode() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4;i++) {
			Integer num = rand.nextInt(10);
//			System.out.println(num);
			sb.append(String.valueOf(num));			
		}
		String s = sb.toString();
		return s;	
	}
	


//	public static void main(String[] args) {
//		VerificationCode.generateVerificationCode();
//	}

}
