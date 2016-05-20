package combSort;

/*Orden N^2 
 * */

public class CombSort {
	
	public void sortArray(int[] input) {
	    int gap = input.length;
	    boolean swapped = true;
	    while (gap > 1 || swapped) {
	        if (gap > 1) {
	            gap = (int) (gap / 1.3);
	        }
	        swapped = false;
	        for (int i = 0; i + gap < input.length; i++) {
	            if (input[i] > input[i+gap]) {
	                int t = input[i];
	                input[i] = input[i + gap];
	                input[i + gap] = t;
	                swapped = true;
	            }
	        }
	    }
	}
}
