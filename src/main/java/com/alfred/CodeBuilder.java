package com.alfred;


/*
 * A class that compiles the c , cpp , java code
 */
public class CodeBuilder {
	static int build(CodeFileInfo info) {
		String statement = null;
		if (info.getLanguage().equals("java")) {
			statement = "javac " + info.getFilePath();
			
		} else if (info.getLanguage().equals("cpp")) {
			statement = "g++ " + info.getFilePath();

		} else if (info.getLanguage().equals("c")) {
			statement = "gcc " + info.getFilePath();

		}
		else
			return 0;
		try {
			
			return ProcessExecutor.runProcess(statement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
