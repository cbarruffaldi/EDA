package ejercicio3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 -o2;
			}
		});

		bt.insert(10);
		bt.insert(4);
		bt.insert(12);
		bt.insert(6);
		bt.insert(2);
		bt.insert(1);
		
		
		List<Integer> list = new ArrayList<Integer>();
		
		list = bt.getFromTo(6, 15);
		System.out.println(list);
		
	}
}
