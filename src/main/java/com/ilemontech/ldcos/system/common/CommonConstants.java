package com.ilemontech.ldcos.system.common;

import java.util.Properties;
import com.ilemontech.ldcos.util.ConfigUtils;

public class CommonConstants {
	
	public final static String SESSION_NAME="CURRENT_USER";
	
	public final static Properties COMMON=ConfigUtils.getPropertiesFile("common.properties");	
	
	public static String getCommonValue(String key){		
		return COMMON.getProperty(key);
	}
}
