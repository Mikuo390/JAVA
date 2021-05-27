/**
 * 
 */
package com.nowcoder.bc;

import java.util.Scanner;

/**
 * @author 15159
 *题目描述
输入一个班级5个学生各5科成绩，输出5个学生各5科成绩及总分。

输入描述:
五行，每行输入一个学生各5科成绩（浮点数表示，范围0.0~100.0），用空格分隔。
输出描述:
五行，按照输入顺序每行输出一个学生的5科成绩及总分（小数点保留1位），用空格分隔。
示例1
输入
98.5 96.0 100 99 88
60.5 77 88.5 99 60
80 80.5 89 91 92
93 94 95.5 96 97.5
100 98 88.5 88 78.5
输出
98.5 96.0 100.0 99.0 88.0 481.5
60.5 77.0 88.5 99.0 60.0 385.0
80.0 80.5 89.0 91.0 92.0 432.5
93.0 94.0 95.5 96.0 97.5 476.0
100.0 98.0 88.5 88.0 78.5 453.0
 */
public class Bc101 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
        while (sc.hasNext()) {
        	
        	double sum=0;
        	double[][] arr = new double[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    arr[i][j]=sc.nextDouble();
                }
            }
            
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                        sum = sum + arr[i][j];
                        System.out.printf("%.1f ", arr[i][j]);
                }
                    System.out.printf("%.1f\n",sum);
                sum=0;
            }
            
        }

	}

}
