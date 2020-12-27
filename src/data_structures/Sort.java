package data_structures;

import java.util.ArrayList;

public class Sort{

	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(8);
		arrayList.add(2);
		arrayList.add(76);
		arrayList.add(5);
		arrayList.add(1);
		arrayList.add(24);
		arrayList.add(56);
		arrayList.add(6);
		arrayList.add(10);
		System.out.println(radixSort(arrayList));
	}

	//bubble sort
	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> arrayList){
		boolean noSwap;
		for (int i = arrayList.size(); i >0 ; i--) {
			noSwap = true;
			for (int j = 0; j < i - 1; j++) {
				if(arrayList.get(j)>arrayList.get(j+1)){
					int temp = arrayList.get(j);
					arrayList.set(j,arrayList.get(j+1));
					arrayList.set(j+1, temp);
					noSwap = false;
				}
			}
			if(noSwap) break;
		}
		return arrayList;
	}



	//selection sort
	public static ArrayList<Integer> selectionSort(ArrayList<Integer> arrayList){
		for (int i = 0; i < arrayList.size(); i++) {
			int lowest = i;
			for (int j = i+1; j < arrayList.size(); j++) {
				if(arrayList.get(j)<arrayList.get(lowest)) lowest = j;
			}
			if (i!=lowest){
				int temp = arrayList.get(lowest);
				arrayList.set(lowest, arrayList.get(i));
				arrayList.set(i, temp);
			}
		}
		return arrayList;
	}



	//insertion sort
	public static ArrayList<Integer> insertionSort(ArrayList<Integer> arrayList){
		for (int i = 1; i < arrayList.size(); i++) {
			int currentValue = arrayList.get(i);
			for (int j = i-1; j>=0 && arrayList.get(j) > currentValue; j--){
				arrayList.set(j+1, arrayList.get(j));
				arrayList.set(j, currentValue);
			}
		}
		return arrayList;
	}



	//merge sort
	public static ArrayList<Integer> merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		ArrayList<Integer> result = new ArrayList<>();
		int left = 0, right = 0;
		while(left < arr1.size() && right< arr2.size()){
			if(arr1.get(left) < arr2.get(right)){
				result.add(arr1.get(left));
				left++;
			}else{
				result.add(arr2.get(right));
				right++;
			}
		}
		while(left< arr1.size()){
			result.add(arr1.get(left));
			left++;
		}
		while(right< arr2.size()){
			result.add(arr2.get(right));
			right++;
		}
		return result;
	}
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> arrayList){
		if(arrayList.size()<=1) return arrayList;
		ArrayList<Integer> left = mergeSort(new ArrayList<Integer>(arrayList.subList(0,arrayList.size()/2)));
		ArrayList<Integer> right = mergeSort(new ArrayList<Integer> (arrayList.subList(arrayList.size()/2,arrayList.size())));
		return merge(left, right);
	}



	// quick sort
	public static int pivotHelper(ArrayList<Integer> arrayList,int start ,int end){
		int pivot = arrayList.get(start);
		int swapIndex = start;
		for(int i=start+1; i<end; i++){
			if(arrayList.get(i)<pivot){
				swapIndex++;
				swap(arrayList, swapIndex, i);
			}
//			System.out.println(arrayList);
		}
		swap(arrayList, swapIndex, start);
//		System.out.println("final pivot "+ arrayList);
		return swapIndex;
	}
	public static void swap(ArrayList<Integer> array, int i1, int i2) {
		int temp = array.get(i1);
		array.set(i1, array.get(i2));
		array.set(i2, temp);
	}
	public static ArrayList<Integer> quickSort(ArrayList<Integer> arrayList, int left, int right){
		if(left < right){
			int pivot = pivotHelper(arrayList, left, right);

//			System.out.print("pivot " + pivot + ", ");
//			System.out.print("left  " + left + ", ");
//			System.out.print("right " + right + ".\n");
//
//			System.out.println("left: ");
			quickSort(arrayList, left, pivot);
//
//			System.out.println("right: ");
			quickSort(arrayList, pivot+1, right);
		}
//		System.out.println("* "+ arrayList);
		return arrayList;
	}



	// radix sort
	public static int getDigit(int n, int d){
		return Math.abs((n / (int) Math.pow(10,d)) % 10);
	}
	public static int numLen(int n){
		return (int) Math.log10(Math.abs(n)) + 1;
	}
	public static int greatestNumLen(ArrayList<Integer> numbers){
		int numLen = 0;
		for(int i : numbers){
			numLen = Math.max(numLen, numLen(i));
		}
		return numLen;
	}
	public static ArrayList<Integer> radixSort(ArrayList<Integer> arrayList){
		int greatestNumLen = greatestNumLen(arrayList);
		for(int i = 0; i<greatestNumLen; i++){
			ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
			for(int j = 0; j<10; j++){
				buckets.add(new ArrayList<Integer>());
			}
			for (Integer integer : arrayList) {
				buckets.get(getDigit(integer, i)).add(integer);
			}
			arrayList.clear();
			for(int j = 0; j<10; j++){
				arrayList.addAll(buckets.get(j));
			}
//			System.out.println(buckets);
//			System.out.println(arrayList);
			buckets.clear();
		}
		return arrayList;
	}
}
