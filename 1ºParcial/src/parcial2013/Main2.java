package parcial2013;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		
		BinaryTree.BuildFromList(list).printPreorder();
		
	}
}
