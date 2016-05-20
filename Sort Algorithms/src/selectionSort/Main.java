package selectionSort;

import combSort.CombSort;

public class Main {
	public static void main(String[] args) {
		SelectionSort b = new SelectionSort();
		int []arr = {3,2,0,4,6,1};
		b.sortArray(arr);
		
		for(int i = 0; i< arr.length; i++)
		System.out.println(arr[i]);
		
	}
}
