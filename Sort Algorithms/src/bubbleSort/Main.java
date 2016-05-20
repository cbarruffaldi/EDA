package bubbleSort;

public class Main {
	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();
		int []arr = {3,2,0,4,6,1};
		b.sortArray(arr);
		
		for(int i = 0; i< arr.length; i++)
		System.out.println(arr[i]);
		
	}
}
