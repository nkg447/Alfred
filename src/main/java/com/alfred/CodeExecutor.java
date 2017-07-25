package com.alfred;

import java.io.IOException;

/*
 * A class to execute the code take inputFile as input using STDIN
 */
public class CodeExecutor {

	private String codePath;
	private String language;
	private String inputFile;

	public CodeExecutor(CodeFileInfo info, Arguments args) {
		this.codePath = info.getFilePath();
		this.language = info.getLanguage();
		this.inputFile = args.input;
	}

	static CodeExecutor getExecutor(CodeFileInfo info, Arguments args) {
		return new CodeExecutor(info, args);
	}

	OutputInfo getOutput() {
		try {
			return exec();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	private OutputInfo exec() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("touch .out");
		String statement = null;
		if (language.equals("java")) {
			String classFile = codePath.substring(codePath.lastIndexOf('/') + 1, codePath.lastIndexOf('.'));
			statement = "java " + " " + classFile;
		} else if (language.equals("python"))
			statement = "python " + codePath;
		else if (language.equals("cpp"))
			statement = "./a.out";
		else if (language.equals("c"))
			statement = "./a.out";

		return new ProcessRunner().run(this, statement, inputFile, ".out");

	}

}
