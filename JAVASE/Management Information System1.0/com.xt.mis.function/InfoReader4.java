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

import com.xt.mis.menu.FunctionMenu;

/**
 * @author 15159
 *
 */
public class InfoReader4 {
	
	public static void readInfo4() {
		for(EmployeeInfo em:InfoReader.list)
			FunctionMenu.infoWindow.append(String.valueOf(em.toString4())+"\n");
	}
}
