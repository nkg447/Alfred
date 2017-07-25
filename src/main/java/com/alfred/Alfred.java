package com.alfred;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * The Butler 
 * @alfred
 * 
 */

class Alfred {

	private static Scanner expected;
	private static Scanner out;

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		Arguments arg = Arguments.getInstance(args);
		if(args.length==0)
		{
			System.err.println("no argument passed");
			System.err.println("To see how to use visit the below link");
			System.err.println("https://github.com/nkg447/Alfred/blob/master/HOW_TO_USE.md");
			System.exit(0);
		}
		try {
			CodeFileInfo codeInfo = CodeFileInfo.getCodeFileInfo(arg.code);
			int exitCode = CodeBuilder.build(codeInfo);

			if (exitCode != 0) {
				System.err.println("! The code doesn't seems to comile");
				System.err.println("exit code - " + exitCode);
				System.exit(1);
			}
			OutputInfo out = CodeExecutor.getExecutor(codeInfo, arg).getOutput();
			System.out.println("time taken " + out.time + "ms");
			if (out.exitCode != 0) {
				System.err.println("/_\\ Runtime Error");
				System.err.println("exit code - " + out.exitCode);
				System.exit(1);
			} else if (out.time > 4000) {
				System.err.println("timeout");
				System.exit(1);
			}
			checkTestCase(new File(arg.output), new File(".out"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void checkTestCase(File expectedOutput, File output) throws FileNotFoundException {
		boolean passed = true;
		
		expected = new Scanner(expectedOutput);
		out = new Scanner(output);
		while (expected.hasNext()) {
			if (!out.hasNext()) {
				passed = false;
				break;
			}
			if (!expected.nextLine().trim().equals(out.nextLine().trim())) {
				passed = false;
				break;
			}
		}
		System.out.println("////////////////");
		if (passed)
			System.out.println("Testcase Passed");
		else
			System.out.println("Testcase Failed");
		System.out.println("////////////////");
		expected = new Scanner(expectedOutput);
		out = new Scanner(output);
		System.out.println("\n\nExpected Output - ");
		while (expected.hasNext())
			System.out.println(expected.nextLine());
		System.out.println("\n----------------------------------------------------------");
		System.out.println("\nYour Output - ");
		while (out.hasNext())
			System.out.println(out.nextLine());
	}
}
