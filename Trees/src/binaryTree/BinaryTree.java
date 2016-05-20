package binaryTree;


public class BinaryTree {

	private Node root;
	
	private static class Node<T>{
		private Node left, right;
		private int elem;
		
		public Node(int elem){
			this.elem=elem;
		}
		
		public void setRightChild(Node n){
			this.right = n;
		}
		public void setLeftChild(Node n){
			this.left=n;
		}
		
		public Node getRightChild(){
			return this.right;
		}
		
		public Node getLeftChild(){
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
		public int getElem(){
			return this.elem;
		}
		
		public boolean isLeaf(){
			return !hasLeftChild() && !hasRightChild();
		}
	}
	
	public void insert(int e){
		if(isEmpty()){
			root = new Node(e);
			return;
		}
		
		insert(e,root);
		
		}
	
	private void insert(int e, Node n){
		if(e < n.elem){
			if(!n.hasLeftChild()){
				n.setLeftChild(new Node(e));
			} else {
				insert(e,n.getLeftChild());
			}
		} else if (e > n.elem) {
			if(!n.hasRightChild()){
				n.setRightChild(new Node(e));
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

	private void print(Node n) {
		if (n != null) {
			print(n.getLeftChild());
			System.out.print(n.getElem() + " ");
			print(n.getRightChild());
		}
	}
	
	public boolean contains(int e){
		if(isEmpty())
			return false;
		return contains(e,root);
	}

	private boolean contains(int e, Node n) {
		if(e == n.getElem())
			return true;
		
		if(e < n.getElem()){
			if(n.hasLeftChild()){
				return contains(e,root.getLeftChild());
			}
		} else if (e > n.getElem()){
			if(n.hasRightChild()){
				return contains(e, root.getRightChild());
			}
		}
		return false;
			
	}
	
	public Node findMaxNode(Node n){
		if(!n.hasRightChild())
			return n;
		
		return findMaxNode(n.getRightChild());
	}
	
	public Node findMinNode(Node n){
		if(!n.hasLeftChild())
			return n;
		
		return findMinNode(n.getLeftChild());
	}
	
	public void delete(int e){
		if(isEmpty())
			return;
		root = delete(e, root);
	}

	private Node delete(int e, Node n) {
		if(n == null)
			return n;
		if(e == n.getElem()){
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
				int value = findMaxNode(n.getLeftChild()).elem;  //sera el maximo del subarbol izquierdo
				n.elem = value;
				n.setLeftChild(delete(value, n.getLeftChild()));	//el mayor del subarbol izquierdo será hoja asi que lo elimino
			}
			}
			else if (e < n.getElem()){
				n.setLeftChild(delete(e, n.getLeftChild()));
				
			}else {
				 n.setRightChild(delete (e, n.getRightChild()));
			}
			return n;
			
		}

	public boolean CheckifBST() {
		if(isEmpty())
			return true;
        return isBST(root,this.findMinNode(root).getElem(), findMaxNode(root).getElem());
    }


	
    private boolean isBST(Node n, int min, int max) {
    	
    	if (n==null)
    		return true;
	       
    	  /*Si el valor del nodo supera al maximo o es menor que el mínimo no es BST */ 
    	  if (n.getElem() < min || n.getElem() > max) 
    	     return false; 
    	 
    	  /*Si tiene subarbol izquierdo, el maximo valor que pueden tener todos sus hijos es el valor del nodo menos 1 (no puede
    	   * ser igual por definicion de BST) */
    	  if (n.hasLeftChild() && !isBST(n.getLeftChild(), min, n.getElem()-1))
    		  return false;
    	  
    	  /*Si tiene subarbol derecho, el minimo valor que pueden tener todos sus hijos es el valor del nodo mas 1
    	   *  (no puede ser igual por definicion de BST)*/
    	  if (n.hasRightChild() && !isBST(n.getRightChild(), n.getElem() + 1, max))
    		  return false;
    	  
    	  return true;    	
    				
}

	
}
