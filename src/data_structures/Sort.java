package data_structures;

import java.util.ArrayList;

public class Sort{

	public static void main(String[] args) {
//		String a= "Asdf", b= "Dgfsd";
//		int h1 = a.hashCode();
//		int h2 = b.hashCode();
//
//		System.out.println(h1+ "\n" + h2);
//		System.out.println(h1>h2);
//		System.out.println(h1<h2);
//		System.out.println(h1==h2);

//		System.out.println(arrayList.get(3).compareTo(arrayList.get(1)));

		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(76);
		arrayList.add(2);
		arrayList.add(5);
		arrayList.add(8);
		arrayList.add(1);
//		ArrayList<Integer> arr2 = new ArrayList<>();
		arrayList.add(24);
		arrayList.add(56);
		arrayList.add(6);
		arrayList.add(10);
		System.out.println(mergeSort(arrayList));
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
	public static ArrayList<Integer> pivotHelper(ArrayList<Integer> arrayList,int start ,int end){
		int pivot = arrayList.get(start);
		int swapIndex = start;
		for(int i=start+!; i<end; i++){
			if(arrayList)
		}
	} 
}
