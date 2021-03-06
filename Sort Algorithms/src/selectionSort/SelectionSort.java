package selectionSort;

/* Orden N^2 */

public class SelectionSort {
	public void sortArray(int[] arr) {
	      int i, j, minIndex, tmp;
	      int n = arr.length;
	      for (i = 0; i < n - 1; i++) {
	            minIndex = i;
	            for (j = i + 1; j < n; j++)
	                  if (arr[j] < arr[minIndex])
	                        minIndex = j;
	            if (minIndex != i) {
	                  tmp = arr[i];
	                  arr[i] = arr[minIndex];
	                  arr[minIndex] = tmp;
	            }
	      }
	}
	
	void swap (int a, int b){
		int tmp;
		tmp = a;
		a = b;
		b = tmp;
	}
}
