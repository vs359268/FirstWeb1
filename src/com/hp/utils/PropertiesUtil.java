/**
 * 
 */
package com.hp.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author Administrator
 *
 */
public class PropertiesUtil {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(PropertiesUtil.getProperties_1(JDBCUtil.JDBC_URL));
		System.out.println(PropertiesUtil.getProperties_2(JDBCUtil.DRIVERCLASSNAME));
		System.out.println(PropertiesUtil.getProperties_3(JDBCUtil.JDBC_USERNAME));
		System.out.println(PropertiesUtil.getProperties_3(JDBCUtil.JDBC_PASSWORD));

	}
	
	//1.ClassLoader 
	public static String getProperties_1(String key) {
		
		Properties properties = new Properties();
		
		try {
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
	
	//2.直接读取文件
	public static String getProperties_2 (String key) {
		
		Properties properties = new Properties();
		
		try {
//			properties.load(new FileInputStream("C:\\Documents and Settings\\Administrator\\eclipse-workspace\\FirstWeb\\config\\conf.properties"));
			properties.load(new BufferedReader(new FileReader("D:\\FirstWeb1\\config\\config.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
	
	//3.ResourceBundle
	public static String getProperties_3(String key) {
		
		ResourceBundle bundle = ResourceBundle.getBundle("config", Locale.getDefault());
		return bundle.getString(key);
	}

}
