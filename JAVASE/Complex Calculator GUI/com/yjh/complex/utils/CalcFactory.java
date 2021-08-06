package com.yjh.complex.utils;

public class CalcFactory {
	
	private static final CalcFactory CALC_FACTORY = new CalcFactory();
	
	private CalcFactory() {
	}
	
	public static CalcFactory getInstance() {
		return CALC_FACTORY;
	}
	
	public CalcRole getCalcRole(CalcType type) {
		
		CalcRole calcRole = null;
		
		if(type.equals(CalcType.ADD_CALC))
			calcRole = new AddCalc();
		else if(type.equals(CalcType.SUB_CALC))
			calcRole = new SubCalc();
		else if(type.equals(CalcType.MULT_CALC))
			calcRole = new MultCalc();
		else if(type.equals(CalcType.DIV_CALC))
			calcRole = new DivCalc();
		else if(type.equals(CalcType.ABS_CALC))
			calcRole = new AbsCalc();
			
		return calcRole;	
	}
}
