package com.rohit.LooseCoupling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LooseCouplingApplication {

	public static void main(String[] args) {
		System.out.println("LooseCoupling Using Interface");
		
	//  BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		// com.rohit.LooseCoupling.BubbleSortAlgorithm@6a192cfe3
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm()); // com.rohit.LooseCoupling.QuickSortAlgorithm@6a192cfe3
	
		
		ApplicationContext  applicationContext = SpringApplication.run(LooseCouplingApplication.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		
		int result = binarySearch.binarySearch(new int[] { 12, 4, 6}, 4);
		System.out.println(result);
	}

}
