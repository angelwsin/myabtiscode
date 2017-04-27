package com.java.util;

public enum DBType {

	MySql("mysql", "msyql", "conf/mysql.properties");

	private DBType(String type, String desc, String conf) {
		this.type = type;
		this.desc = desc;
	}
		
	private String type;
	private String desc;

	public String getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

	
	

}
