package com.pmcl.util;

import java.sql.Timestamp;

public class Helper {
	public static String getCurrentTimeStamp() {
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis()); 
		return timeStamp.toString();
	}
}
