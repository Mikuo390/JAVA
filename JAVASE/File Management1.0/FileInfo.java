/**
 * 
 */
package com.abc.filemanagement;

import java.io.File;
import java.util.Date;

/**
 * @author 15159
 *
 */
public class FileInfo {

	static void showInfo(File file) {
		System.out.printf("最后修改时间:%-25s,文件大小:%-18s字节,文件名:%-20s\n",
				new Date(file.lastModified()).toLocaleString(),
				file.length(),
				file.getName());
	}
	
}
