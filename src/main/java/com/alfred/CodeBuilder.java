package com.alfred;

import java.io.IOException;

/*
 * A class that compiles the c , cpp , java code
 */
public class CodeBuilder {
	static int build(CodeFileInfo info) {

		if (info.getLanguage().equals("java"))
			return javaBuild(info);
		else if (info.getLanguage().equals("cpp"))
			return cppBuild(info);
		else if (info.getLanguage().equals("c"))
			return cBuild(info);
		return 0;
	}

	private static int cBuild(CodeFileInfo info) {
		String statement = "gcc " + info.getFilePath();
		try {
			Process build = Runtime.getRuntime().exec(statement);
			build.waitFor();
			return build.exitValue();
		} catch (IOException e) {
			return -1;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private static int cppBuild(CodeFileInfo info) {
		String statement = "g++ " + info.getFilePath();
		try {
			Process build = Runtime.getRuntime().exec(statement);
			build.waitFor();
			return build.exitValue();
		} catch (IOException e) {
			return -1;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private static int javaBuild(CodeFileInfo info) {

		String statement = "javac " + info.getFilePath();
		try {
			Process build = Runtime.getRuntime().exec(statement);
			build.waitFor();
			return build.exitValue();
		} catch (IOException e) {
			return -1;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return -1;

	}
}
