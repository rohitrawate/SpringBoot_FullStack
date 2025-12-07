package com.rohit.LooseCoupling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired
	private SortAlgorithm sortAlgorithm;
	
//	public BinarySearchImpl(SortAlgorithm sortAlgorithm) { //Spring uses this constructor to autowire to beansortalgorithm
//		//The constructor accepts class implementing t `Interface`
//		super();
//		this.sortAlgorithm = sortAlgorithm;
//	}

	public int binarySearch(int[] numbers, int numToSearchFor) {
		
	 //Sorting an Array
	     //-"Bubble Sort Algorithm"--The logic of Binary Search is tightly coupled to the bubble sort algorithm
	 //Quick Sort - Want to switch to quick sort --  Need to change the piece of code
//	  BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
	  
	  int[] sortedNumbers = sortAlgorithm.sort(numbers); //bubbleSortAlgorithm.sort(numbers);
	   System.out.print("SortAlgorithm : "+ sortAlgorithm);
	   
	 //Searching an ele -Binary Search Logic
		return 3;
	}
}
