package taller;

import java.util.Comparator;

public class BST<T> {
	private T elem;
	private BST<T> left;
	private BST<T> right;
	private Comparator<T> cmp;
	
	public BST(T elem, Comparator<T> cmp){
		this.cmp = cmp;
		this.elem = elem;
	}
	
	public BST(Comparator<T> cmp){
		this.cmp = cmp;
	}
	
	public void add(T elem){
		if(this.elem == null)
			this.elem = elem;
		
		int compare = cmp.compare(elem, this.elem);
		
		if(compare == 0)
			return;
		
		if(compare > 0){
			if(this.hasRightChild()){
				this.right.add(elem);
			} else {
				this.right = new BST(elem, this.cmp);
			}
		}	
		else if (compare <0){
			if(this.hasLeftChild()){
				this.left.add(elem);	
			} else {
				this.left = new BST(elem, this.cmp);
			}
		}
		return;
	}
	
	public boolean hasLeftChild(){
		return this.left != null;
	}
	
	public boolean hasRightChild(){
		return this.right != null;
	}
	
	public void printInorder(){
		printInorder(this);
	}

	private void printInorder(BST<T> tree) {
		if (tree == null)
			return;
		
		printInorder(tree.left);
		System.out.println(tree.elem.toString());
		printInorder(tree.right);
		
	}
	
	public void printPreOrder(){
		printPreOrder(this);
	}

	private void printPreOrder(BST<T> tree) {
		if (tree == null)
			return;
		
		System.out.println(tree.elem.toString());
		printPreOrder(tree.left);
		printPreOrder(tree.right);
		
	}
	
	public void printPostOrder(){
		printPostOrder(this);

	}

	private void printPostOrder(BST<T> tree) {
		if (tree == null)
			return;
		
		printPostOrder(tree.left);
		printPostOrder(tree.right);
		System.out.println(tree.elem.toString());
		
	}
}
