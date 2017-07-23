package com.alfred;

/*
 * The Butler 
 * @alfred
 * 
 */

public class Alfred {
	
	public static void main(String[] args) {
		Arguments arg = Arguments.getInstance(args);
		try {
			CodeFileInfo codeInfo = CodeFileInfo.getCodeFileInfo(arg.code);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
