package com.yjh.complex.utils;

import com.yjh.complex.ui.CalcUI;

public class DataCleaner {

	public static void clearData() {
		CalcUI.realpartText1.setText("");
		CalcUI.imagpartText1.setText("");
		CalcUI.realpartText2.setText("");
		CalcUI.imagpartText2.setText("");
		CalcUI.realpartResult.setText("");
		CalcUI.imagpartResult.setText("");
		CalcUI.symbolText.setText("");
	}
}
