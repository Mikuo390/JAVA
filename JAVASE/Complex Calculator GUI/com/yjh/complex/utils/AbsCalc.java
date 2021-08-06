package com.yjh.complex.utils;

import com.yjh.complex.domain.Complex;
import com.yjh.complex.ui.CalcUI;

public class AbsCalc implements CalcRole{
	private static String r1 = CalcUI.realpartText1.getText();
	private static String i1 = CalcUI.imagpartText1.getText();
	
	private static Complex c1 = new Complex(Double.valueOf(r1),Double.valueOf(i1));
	private static Complex result = new Complex();
	
	@Override
	public void calcComplex() {
		result.setRealpart(Math.pow(c1.getRealpart(), 2));
		result.setImagpart(Math.pow(c1.getImagpart(), 2));
		
		CalcUI.realpartResult.setText(result.getRealpart()+"");
		CalcUI.imagpartResult.setText(result.getImagpart()+"");
	}
}
