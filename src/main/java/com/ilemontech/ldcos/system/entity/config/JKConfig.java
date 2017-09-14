package com.ilemontech.ldcos.system.entity.config;

import org.apache.commons.lang.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.ilemontech.ldcos.system.entity.BdConfig;

public class JKConfig extends BdConfig {

	private static final long serialVersionUID = 1L;

	private String path;

	private String username;

	private String password;
	
	public JKConfig(BdConfig config){
		if(config!=null){
			setId(config.getId());
			setName(config.getName());
			setEnv(config.getEnv());
			setValue(config.getValue());
			if(StringUtils.isNotBlank(config.getValue())){
				JSONObject json=JSONObject.parseObject(config.getValue());				
				path=json.getString("path");
				username=json.getString("username");
				password=json.getString("password");				
			}
		}		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
