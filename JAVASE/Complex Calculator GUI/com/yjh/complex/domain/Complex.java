package com.yjh.complex.domain;

public class Complex {

	/** 实部 */
	private double realpart;
	/** 虚部 */
	private double imagpart;
	
	/** 无参构造器 */
	public Complex() {
		this(0.0,0.0);
	}
	/** 半参构造器 */
	public Complex(double realpart) {
		this(realpart,0.0);
	}
	
//	public Complex(double imagpart) {
//		this(0.0,imagpart);
//	}
	/** 全参构造器 */
	public Complex(double realpart,double imagpart) {
		this.realpart = realpart;
		this.imagpart = imagpart;
	}
	
	//javabean
	public double getRealpart() {
		return realpart;
	}

	public void setRealpart(double realpart) {
		this.realpart = realpart;
	}

	public double getImagpart() {
		return imagpart;
	}

	public void setImagpart(double imagpart) {
		this.imagpart = imagpart;
	}	
}
