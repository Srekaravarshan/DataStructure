package data_structures;

import java.util.ArrayList;

public class SearchAlgorithm {
	
	// linear search
	public static int linearSearch(ArrayList<Integer> arr, int n){
		for(int i : arr){
			if(n==arr.get(i)){
				return i;
			}
		}return -1;
	}
	
	// binary search
	public static int binarySearch(ArrayList<Integer> arr, int n){
		int min = 0;
		int max = arr.size()-1;
		while(min<max){
			int middle = (max+min)/2;
			int currentNum = arr.get(middle);
			if(currentNum < arr.get(n)){
				min = middle+1;
			}else if(currentNum > arr.get(n)){
				max = middle-1;
			}else {
				return middle;
			}
		}
		return -1;
	}

}
