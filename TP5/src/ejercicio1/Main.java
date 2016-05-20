package ejercicio1;

import java.util.Comparator;

public class Main {
	public static <T> void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		tree.insert(5);
		tree.insert(1);
		tree.insert(3);
		tree.insert(2);
		
		BinaryTree<String> tree2 = tree.transform(tree, new Function<Integer, String>() {

			@Override
			public String transform(Integer elem) {
				return elem.toString() + "**";
			}
		});
		
		tree2.print();
		
		
	}
}
