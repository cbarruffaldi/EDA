package ejercicio3;

public class Main {

	public Tree<Integer> makeBinaryTree(int []arr){
		Tree<Integer> t = new Tree<Integer>();
		t.root = makeBinaryTree(arr,0,arr.length+1);
		return t;
	}
	
	public Tree<Integer> makeBinaryTree(int []arr, int inf, int sup){
		if(sup - inf < 0)
			return null;
		
		int middle = (sup + inf) / 2;
		Node<Integer> n = new Node<Integer>(arr[middle]);
		
		n.left = makeBinaryTree(arr, inf, middle-1);
		n.right = makeBinaryTree(arr,middle + 1, sup);
		
		return n;
		
	}
	
}
