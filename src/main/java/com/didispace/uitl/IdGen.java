package com.didispace.uitl;

import java.util.UUID;

public class IdGen {

	
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
