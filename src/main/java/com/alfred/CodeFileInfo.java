package com.alfred;

import java.io.File;

public class CodeFileInfo {
	private String filePath;
	private String fileName;
	private String extention;
	private String language;

	public CodeFileInfo(String filePath, String fileName, String extention, String language) {
		this.setFilePath(filePath);
		this.setFileName(fileName);
		this.setExtention(extention);
		this.setLanguage(language);
	}

	static CodeFileInfo getCodeFileInfo(String filePath) throws Exception {
		File file = new File(filePath);
		String fileName = file.getName();
		String extention = fileName.substring(fileName.indexOf('.') + 1);
		String language = ExtentionMap.getLanguage(extention);

		return new CodeFileInfo(filePath, fileName, extention, language);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
