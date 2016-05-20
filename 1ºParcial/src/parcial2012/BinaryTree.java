package parcial2012;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
		
	private T value;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	
	public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right){
		this.value = value;
		this.right = right;
		this.left = left;
	}
	
	public T getValue(){
		return this.value;
	}
	
	public BinaryTree<T> getLeft(){
		return this.left;
	}
	
	public BinaryTree<T> getRight(){
		return this.right;
	}
	
	public static <T> BinaryTree<T> spanning(BinaryTree<T> tree, T value){
		if ( tree == null)
			return null;
		
		if(tree.getValue().equals(value)){
			return new BinaryTree<T>(value, spanning(tree.left,value), spanning(tree.right,value));
			
		}
		
		BinaryTree<T> left = spanning(tree.left,value);
		BinaryTree<T> right = spanning(tree.right,value);
		
		if(left == null && right == null)
			return null;
		
		return new BinaryTree<T>(tree.value,left,right);
	}
	
	public boolean checkHeap(BinaryTree<T> tree, Comparator<T> cmp){
		Queue<BinaryTree<T>> q = new LinkedList<>();
		q.add(tree);
		boolean firstNull = false;		//a partir del primer null, todos los siguientes deberian ser null;
		
		while(!q.isEmpty()){
			BinaryTree<T> t = q.poll();
			
			if(firstNull){
				if(t != null)
					return false;
			}
			else {
				if(t == null){
					firstNull = true;
				} else{
					boolean ok = checkSons(tree, cmp);
					if(!ok){
						return false;
					}
					q.offer(tree.left);
					q.offer(tree.right);
				}
			}
			
		}
		
		return true;			//el arbol es un heap;
	}
	
	private boolean checkSons(BinaryTree<T> tree, Comparator<T> cmp){
		if(tree == null)
			return true;
		if(cmp.compare(tree.value, tree.left.value) < 0)
			return false;
		if(cmp.compare(tree.value, tree.right.value) < 0)
			return false;
		
		return true;
	}
}
