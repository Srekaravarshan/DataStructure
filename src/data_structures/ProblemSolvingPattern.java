package data_structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ProblemSolvingPattern {

//	public static void main(String[] args) {
//		ArrayList<Integer> numbers = new ArrayList<>();
//		numbers.add(1);
//		numbers.add(2);
//		numbers.add(2);
//		numbers.add(2);
//		numbers.add(3);
//		numbers.add(4);
//		numbers.add(5);
//		numbers.add(5);
//		numbers.add(6);
//		numbers.add(6);
//		numbers.add(7);
//		numbers.add(8);
//		System.out.println(search(numbers, 7));
//	}
	// frequency counter
	public static boolean anagram(String str1, String str2) {
		if(str1.length() != str2.length()){
			return false;
		}else{
			str1.toLowerCase();
			str2.toLowerCase();
			Map<Character, Integer> string1 = new HashMap<>();
			Map<Character,Integer> string2 = new HashMap<>();

			for(int i=0; i< str1.length(); i++){
				string1.put(str1.charAt(i), string1.get(str1.charAt(i))==null? 1: string1.get(str1.charAt(i))+1);
			}

			for(int i=0; i< str2.length(); i++){
				string2.put(str2.charAt(i), string2.get(str2.charAt(i))==null? 1: string2.get(str2.charAt(i))+1);
			}

			for(Map.Entry<Character, Integer> entry1 : string1.entrySet()){
				if(!(string2.containsKey(entry1.getKey()))){
					return false;
				}
				if(!entry1.getValue().equals(string2.get(entry1.getKey()))){
					return false;
				}
			}

			return true;
		}
	}

	// multiple counter
	public static int countUniqueNumbers(ArrayList<Integer> numbers){
		if(numbers.size()==0){
			return 0;
		}
		int left = 0;
		int right = 1;
		while(right<numbers.size()) {
			if(numbers.get(left).equals(numbers.get(right))) {
				right++;
			}else{left++;
				numbers.set(left, numbers.get(right));
			}
		}
		return left+1;
	}

	// sliding window
	public static int maxSum(ArrayList<Integer> numArray, int n){
		int result = 0;
		int temp;
		if(n>numArray.size()){
			return 0;
		}
		for(int i=0; i<n; i++){
			result += numArray.get(i);
		}
		temp = result;
		for(int i=n; i< numArray.size(); i++){
			temp = temp- numArray.get(i-n) + numArray.get(i);
			result = Integer.max(temp, result);
		}
		return result;
	}

	// divide and conquer
	public static int search(ArrayList<Integer> numbers, int value){
		int min = 0;
		int max = numbers.size()-1;
		while(min<max){
			int middle = (max+min)/2;
			int currentNum = numbers.get(middle);
			if(currentNum < numbers.get(value)){
				min = middle+1;
			}else if(currentNum > numbers.get(value)){
				 max = middle-1;
			}else {
				return middle;
			}
		}
		return -1;
	}
}
