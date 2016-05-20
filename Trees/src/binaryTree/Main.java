package binaryTree;

public class Main {
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.insert(10);
		bt.insert(4);
		bt.insert(13);
		bt.insert(1);
		bt.insert(14);
		bt.insert(15);
		
		bt.print();
		bt.delete(10);
		System.out.println(bt.CheckifBST());
		System.out.println("");
		bt.print();
	}
	
}
