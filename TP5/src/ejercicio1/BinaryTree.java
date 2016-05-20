package ejercicio1;

import java.util.Comparator;

public class BinaryTree<T>{

	private Node<T> root;
	private Comparator<T> cmp;
	
	public BinaryTree(Comparator<T> cmp){
		this.cmp = cmp;
	}
	public BinaryTree(){
		
	}
	
	private static class Node<T>{
		private Node<T> left, right;
		private T elem;
		
		public Node(T elem){
			this.elem=elem;
		}
		
		public void setRightChild(Node<T> n){
			this.right = n;
		}
		public void setLeftChild(Node<T> n){
			this.left=n;
		}
		
		public Node<T> getRightChild(){
			return this.right;
		}
		
		public Node<T> getLeftChild(){
			return this.left;
		}
		
		public boolean hasBothChilds(){
			return hasRightChild() && hasLeftChild();
		}
		
		public boolean hasRightChild(){
			return right!= null;
		}
		
		public boolean hasLeftChild(){
			return left != null;
		}
		public T getElem(){
			return this.elem;
		}
		
		public boolean isLeaf(){
			return !hasLeftChild() && !hasRightChild();
		}
	}
	
	public void insert(T e){
		if(isEmpty()){
			root = new Node<T>(e);
			return;
		}
		
		insert(e,root);
		
		}
	
	private void insert(T e, Node<T> n){
		if(cmp.compare(e, n.elem) < 0){
			if(!n.hasLeftChild()){
				n.setLeftChild(new Node(e));
			} else {
				insert(e,n.getLeftChild());
			}
		} else if (cmp.compare(e, n.elem) > 0) {
			if(!n.hasRightChild()){
				n.setRightChild(new Node<T>(e));
			} else {
				insert(e,n.getRightChild());
			}
		}
		
		
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void print() {
		print(root);
	}

	private void print(Node<T> n) {
		if (n != null) {
			print(n.getLeftChild());
			System.out.print(n.getElem() + " ");
			print(n.getRightChild());
		}
	}
	
	public boolean contains(T e){
		if(isEmpty())
			return false;
		return contains(e,root);
	}

	private boolean contains(T e, Node<T> n) {
		if(cmp.compare(e, n.elem) == 0)
			return true;
		
		if(cmp.compare(e, n.elem) < 0){
			if(n.hasLeftChild()){
				return contains(e,root.getLeftChild());
			}
		} else if (cmp.compare(e, n.elem) > 0){
			if(n.hasRightChild()){
				return contains(e, root.getRightChild());
			}
		}
		return false;
			
	}
	
	public Node<T> findMaxNode(Node<T> n){
		if(!n.hasRightChild())
			return n;
		
		return findMaxNode(n.getRightChild());
	}
	
	public Node<T> findMinNode(Node<T> n){
		if(!n.hasLeftChild())
			return n;
		
		return findMinNode(n.getLeftChild());
	}
	
	public void delete(T e){
		if(isEmpty())
			return;
		root = delete(e, root);
	}

	private Node<T> delete(T e, Node<T> n) {
		if(n == null)
			return n;
		if(cmp.compare(e, n.elem) == 0){
			if(n.isLeaf()){
				n = null;
				return n;
			} else if( n.hasRightChild() && !n.hasBothChilds()){		//solo tiene hijo derecho
				n = n.getRightChild();
				return n;
			} else if( n.hasLeftChild() && !n.hasBothChilds()){		//solo tiene hijo izquierdo
				n = n.getLeftChild();
				return n;
			} else if(n.hasBothChilds()){
				T value = findMaxNode(n.getLeftChild()).elem;  //sera el maximo del subarbol izquierdo
				n.elem = value;
				n.setLeftChild(delete(value, n.getLeftChild()));	//el mayor del subarbol izquierdo será hoja asi que lo elimino
			}
			}
			else if (cmp.compare(e, n.elem) < 0){
				n.setLeftChild(delete(e, n.getLeftChild()));
				
			}else {
				 n.setRightChild(delete (e, n.getRightChild()));
			}
			return n;
			
		}

//	public boolean CheckifBST() {
//		if(isEmpty())
//			return true;
//        return isBST(root,this.findMinNode(root).getElem(), findMaxNode(root).getElem());
//    }
//
//
//
//	
//    private boolean isBST(Node n, T min, T max) {
//    	
//    	if (n==null)
//    		return true;
//	       
//    	  /*Si el valor del nodo supera al maximo o es menor que el mínimo no es BST */ 
//    	  if (cmp.compare((T)n.getElem(), min) < 0 || cmp.compare((T)n.getElem(), max) > 0) 
//    	     return false; 
//    	 
//    	  /*Si tiene subarbol izquierdo, el maximo valor que pueden tener todos sus hijos es el valor del nodo menos 1 (no puede
//    	   * ser igual por definicion de BST) */
//    	  if (n.hasLeftChild() && !isBST(n.getLeftChild(), min, (T)n.getElem()))
//    		  return false;
//    	  
//    	  /*Si tiene subarbol derecho, el minimo valor que pueden tener todos sus hijos es el valor del nodo mas 1
//    	   *  (no puede ser igual por definicion de BST)*/
//    	  if (n.hasRightChild() && !isBST(n.getRightChild(), (T)n.getElem(), max))
//    		  return false;
//    	  
//    	  return true;    	
//    				
//}

	public <S> BinaryTree<S> transform(BinaryTree<T> tree, Function f){
		BinaryTree<S> t = new BinaryTree<S>();
		t.root= transform(this.root, f);
		return t;
		
		
	}
	
	public <S> Node<S> transform(Node<T> node, Function f){
		if ( node == null)
			return null;
		
		Node<S> n = new Node(f.transform(node.elem));
		n.left = transform(node.left, f);
		n.right = transform(node.right, f);
		
		return n;
			
	}
    
}	

