package com.alfred;
/*
 * Stores the info about the Output file
 */
public class OutputInfo {
	long time;
	int exitCode;
	
	public OutputInfo(long time, int exitCode) {
		this.time = time;
		this.exitCode = exitCode;
	}
}
