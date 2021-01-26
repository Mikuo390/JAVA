/**
 * 
 */
package day0126;

import java.util.Scanner;

/**
 * @author 15159
 *
 */
public class WaterFlowerFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		System.out.println(getIntSize(31234));
//		System.out.println(getIntSize2(31234));
		
//		System.out.println(Math.pow(10, 2));
		
//		System.out.println(isWaterFlowerNum(153));
		
		int size = 0;
		int begin,end;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("请输入数字的位数：");
		size = sc.nextInt();
		
		begin = (int)Math.pow(10, size-1);
		end = (int)(Math.pow(10, size))-1;
		System.out.printf("search scope:%d-%d\n",begin,end);
		
		for(int i=begin;i<=end;i++) {
			if(isWaterFlowerNum(i)) System.out.println(i);
		}
	}
	
	/**
	 * 水仙花数判断（长度自适应版本）
	 * @param num 待测试的数
	 * @return 
	 * 		true 	是水仙花
	 * 		false 	不是水仙花
	 */
	public static boolean isWaterFlowerNum(int num) {
		
		int size = getIntSize(num);
		int temp =  num;
		int sum = 0;//数字和
		
		while(temp>0) {
			sum += (int)Math.pow(temp%10, size);
			temp/=10;
		}
		
		return sum==num;
		
	}
	
	/**
	 * 求某个整数的长度
	 * @param num 待测试的整数
	 * @return 整数的长度
	 */
	public static int getIntSize(int num) {
		
		int size = 0;
		
		while(num>0) {
			num/=10;
			size++;
		}
		
		return size;
		
	}
	
	/**
	 * 求某个整数长度（字符串解析法）
	 * @param num
	 * @return
	 */
	public static int getIntSize2(int num) {
		
		return String.valueOf(num).length();
		
	}

}
