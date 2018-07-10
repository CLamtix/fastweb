package com.fast.util;

public class StringUtil {
	
	/**
	 * 如果传入的字符串为null或空字符串则为无效
	 */
	public static boolean isSpaceString(String arg){
		return arg==null || "".equals(arg.trim());
	}
	
	/**
	 * 如果传入的字符串为null或空字符串则为无效
	 */
	public static boolean isNotSpaceString(String arg){
		return arg!=null && !"".equals(arg.trim());
	}
}
