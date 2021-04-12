/**
 * 
 */
package com.xt.mis.function;

import com.xt.mis.EmployeeInfo;
import com.xt.mis.menu.*;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.xt.mis.EmployeeInfo;
/**
 * @author 15159
 *
 */
public class InfoReader1 {
		
	public static void readInfo() {	
		for(EmployeeInfo em:InfoReader.list)
			FunctionMenu.infoWindow.append(String.valueOf(em.toString())+"\n");
	}
}
