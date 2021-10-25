package com.ss.jb.test;

public class Demo {

	public static void main(String[] args) {
		Test test = (i) -> i+1;
		Test inc = (i) -> {
			System.out.println("Printing from increment function");
			return i + 1;
		};
	}
}
