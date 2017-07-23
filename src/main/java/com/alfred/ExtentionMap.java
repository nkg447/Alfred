package com.alfred;

import java.util.HashMap;
/*
 * A mapping of extention to there languages */
class ExtentionMap {
	static HashMap<String, String> extMap = new HashMap<String, String>();
	static {
		extMap.put("java", "java");
		extMap.put("py", "python");
		extMap.put("cpp", "cpp");
		extMap.put("c", "c");
	}
	
	static String getLanguage(String extention) throws Exception {
		if(extMap.containsKey(extention))
			return extMap.get(extention);
		throw new Exception(extention+" not yet supported");
		
	}
	
}