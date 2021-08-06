package com.yjh.complex.utils;

import com.yjh.complex.domain.Complex;
import com.yjh.complex.ui.CalcUI;

public class MultCalc implements CalcRole {
	
	private static String r1 = CalcUI.realpartText1.getText();
	private static String i1 = CalcUI.imagpartText1.getText();
	private static String r2 = CalcUI.realpartText2.getText();
	private static String i2 = CalcUI.imagpartText2.getText();
	
	private static Complex c1 = new Complex(Double.valueOf(r1),Double.valueOf(i1));
	private static Complex c2 = new Complex(Double.valueOf(r2),Double.valueOf(i2));
	private static Complex result = new Complex();
	
	@Override
	public void calcComplex() {
		result.setRealpart(c1.getRealpart()*c2.getRealpart()-c1.getImagpart()*c2.getImagpart());
		result.setImagpart(c1.getRealpart()*c2.getImagpart()+c1.getImagpart()*c2.getRealpart());
		
		CalcUI.realpartResult.setText(result.getRealpart()+"");
		CalcUI.imagpartResult.setText(result.getImagpart()+"");
	}
}
