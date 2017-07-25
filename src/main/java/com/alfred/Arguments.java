package com.alfred;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
/*
 * A class used to store all the arguments.
 * dependency : JCommander
 * @alfred
 * 
 */
public class Arguments {

	@Parameter(names = { "-d" }, description = "Detailed Output")
	boolean detailed = false;

	@Parameter(names = { "-c", "--code" }, description = "Path to the Code file")
	String code = "Code";

	@Parameter(names = { "-i", "--input" }, description = "Path to the Input file")
	String input = "input";

	@Parameter(names = { "-o", "--output" }, description = "Path to the Output file")
	String output = "output";
	
	/*
	 * parameters : String array of arguments
	 * returns an Object of Arguments
	 */
	static Arguments getInstance(String args[]) {
		Arguments arguments = new Arguments();
		JCommander.newBuilder()
		  .addObject(arguments)
		  .build()
		  .parse(args);
		return arguments;
	}
	
}
