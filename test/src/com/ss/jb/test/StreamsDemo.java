package com.ss.jb.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {
		StreamsDemo sd = new StreamsDemo();
		sd.toUppercase();
	}
	
	public void toUppercase() {
		List<String> names = Arrays.asList("John", "David", "Mary");
		List<String> uppercaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		List<String> uppercaseNamesPar = names.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
		
		uppercaseNames.forEach(n->{
			System.out.println(n);
		});
		
		System.out.println();
		
		uppercaseNamesPar.forEach(n->System.out.println(n));
	}

}
