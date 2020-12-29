/**
 * 
 */
package com.nowcoder.jz;

import java.util.Scanner;

/**
 * @author 15159
 *请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Jz2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		StringBuffer str = new StringBuffer();
		
		//测试方法
		StringBuffer str1 = new StringBuffer("We Are Happy");
		System.out.println(replaceSpace(str1));
		
		Scanner scanner = new Scanner(System.in);
		str.append(scanner.nextLine());
//		Java中Scanner类中的方法next()和nextLine()都是吸取输入台输入的字符，区别:
//		.next(不会吸取字符前/后的空格/Tab键，只吸取字符，开始吸取字符（字符前后不算）直到遇到空格/Tab键/回车截止吸取;
//		.nextLine()吸取字符前后的空格/Tab键，回车键截止。
	
		System.out.println(replaceSpace(str));

	}
	
	public static String replaceSpace(StringBuffer str) {
		
		for(int i=0;i<=str.length()-1;i++){
            if(str.charAt(i)==' '){//charAt(i):获得i位置的元素
                str.deleteCharAt(i);//删除空格
                str.insert(i,"%20");//插入
            }
        }
        return str.toString();//转成字符串		
	}

}
