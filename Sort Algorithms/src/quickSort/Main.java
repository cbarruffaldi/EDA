package quickSort;


public class Main {
	public static void main(String[] args) {
		QuickSort b = new QuickSort();
		int []arr = {2,1,0,9,5,1,2};
		b.sortArray(arr);
		
		for(int i = 0; i< arr.length; i++)
		System.out.println(arr[i]);
		
	}
}
