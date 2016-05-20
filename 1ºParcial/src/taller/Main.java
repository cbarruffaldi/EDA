package taller;

import java.util.Comparator;

public class Main {
	public static void main(String[] args) {

		BST<Integer> bst = new BST<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 -o2;
			}
		});
		
		bst.add(5);
		bst.add(2);
		bst.add(3);
		bst.add(10);

		
		
	}
	
	
	
	
	
}
