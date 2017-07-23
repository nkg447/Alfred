package com.alfred;

import java.io.IOException;
import java.util.concurrent.Semaphore;

/*
 * A class to run two threads and return which thread finished first to check timeout
 * Reference : https://stackoverflow.com/a/5028382/6807222
 */
public class ProcessRunner {
	private Semaphore semaphore = new Semaphore(0);
	private int exitCode=0;
	private synchronized void finished() {
		semaphore.release();
	}

	@SuppressWarnings("deprecation")
	public OutputInfo run(CodeExecutor exe, final String statement, final String inputFile, final String outputFile) {
		
		Runnable r1 = new Runnable() {
			public void run() {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// ignore
				} finally {
					finished();
				}
			}
		};

		Runnable r2 = new Runnable() {
			public void run() {
				try {
					exitCode =ProcessExecutor.runProcess(statement,inputFile,outputFile);
					
				} catch (InterruptedException e) {
					// ignore
				} catch (IOException e) {
					// ignore
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					finished();
				}
			}
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			semaphore.acquire();
			t1.stop();
			t2.stop();
			return new OutputInfo(System.currentTimeMillis() - start, exitCode);

		} catch (InterruptedException e) {
			System.out.println("No winner");
			Thread.currentThread().interrupt();
		}
		return null;
	}

}