package com.alfred;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/*
 * A class to execute commands*/
public class ProcessExecutor {

	static int runProcess(String command, String stdin, String stdout) throws Exception {
		System.out.println("executing -  " + command);

		Process p = Runtime.getRuntime().exec(command);
		PrintWriter pw = new PrintWriter(p.getOutputStream());
		Scanner sc = new Scanner(new File(stdin));
		
		while (sc.hasNext())
			pw.println(sc.nextLine());
		pw.close();
		sc.close();
		
		p.waitFor();
		
		sc = new Scanner(p.getInputStream());
		pw = new PrintWriter(stdout);
		
		while (sc.hasNext())
			pw.println(sc.nextLine());
		pw.close();
		sc.close();

		sc=new Scanner(p.getErrorStream());
		while (sc.hasNext())
			System.out.println(sc.nextLine());
		
		sc.close();
		
		System.out.println(command + " exitValue() " + p.exitValue());
		return p.exitValue();
	}

	public static int runProcess(String command) throws Exception {
		System.out.println("executing -  " + command);
		
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor();
		return p.exitValue();
	}

}