package ejercicio3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree<T>{

	private Node<T> root;
	private Comparator<T> cmp;
	private int size;
	
	public BinaryTree(Comparator<T> cmp){
		this.cmp = cmp;
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
			size++;
			return;
		}
		
		insert(e,root);
		
		}
	
	private void insert(T e, Node<T> n){
		if(cmp.compare(e, n.elem) < 0){
			if(!n.hasLeftChild()){
				n.setLeftChild(new Node(e));
				size++;
			} else {
				insert(e,n.getLeftChild());
			}
		} else if (cmp.compare(e, n.elem) > 0) {
			if(!n.hasRightChild()){
				n.setRightChild(new Node<T>(e));
				size++;
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
				size--;
				return n;
			} else if( n.hasRightChild() && !n.hasBothChilds()){		//solo tiene hijo derecho
				n = n.getRightChild();
				size--;
				return n;
			} else if( n.hasLeftChild() && !n.hasBothChilds()){		//solo tiene hijo izquierdo
				n = n.getLeftChild();
				size--;
				return n;
			} else if(n.hasBothChilds()){
				T value = findMaxNode(n.getLeftChild()).elem;  //sera el maximo del subarbol izquierdo
				n.elem = value;
				n.setLeftChild(delete(value, n.getLeftChild()));	//el mayor del subarbol izquierdo será hoja asi que lo elimino
				size--;
			}
			}
			else if (cmp.compare(e, n.elem) < 0){
				n.setLeftChild(delete(e, n.getLeftChild()));
				
			}else {
				 n.setRightChild(delete (e, n.getRightChild()));
			}
			return n;
			
		}

	public boolean CheckifBST() {
		if(isEmpty())
			return true;
        return isBST(root,null,null);
    }


    private boolean isBST(Node<T> node, T min, T max) {
    	
    	if (node==null)
    		return true;

    	if (max != null && cmp.compare(node.elem, max) > 0)
    		return false;
    		
    	if (min != null && cmp.compare(node.elem, min) < 0)
    		return false;
    	
    	return isBST(node.left, node.elem, min) && isBST(node.right, max, node.elem);
    	
    	}
    	    	

	
	public boolean isAVL(){
		
		return isAVL(root,null,null) != -1 ;		//-1 es codigo de error -> "false"
		
		}
	
	private int isAVL(Node<T> node, T min, T max){
		if(node == null)
			return 0;
		
		if( max != null && cmp.compare(node.elem, max) > 0){			//Check BST
			return -1;
		}
		if( min != null && cmp.compare(node.elem, min) < 0){			//Check BST
			return -1;
		}
		
		int left = isAVL(node.left, min, node.elem);
		
		if(left == -1)													//Check AVL
			return -1;
		
		int right = isAVL(node.right,node.elem, max);
		
		if(right == -1)													//Check AVL
			return -1;
		
		if(Math.abs(left-right) > 1)									//Check AVL
			return -1;
		
		return 1 + Math.max(left, right);								
		
		}
	
	public int size(){
		return this.size;
	}
	
	public int getLevel(T elem){
		if(elem == null)
			throw new NullPointerException("elemento nulo");
		return getLevel(root,elem,0);
	}

	private int getLevel(Node<T> node, T elem, int i) {
		
		if(node == null)
			return -1;
		
		if(cmp.compare(elem, node.elem) == 0)
			return i;
		
		else if(cmp.compare(elem, node.elem) < 0)
			return getLevel(node.left,elem, i+1);

		return getLevel(node.right, elem, i+1);
		
	}
	
	public int LeavesQty(){
		return LeavesQty(root);
	}

	private int LeavesQty(Node<T> node) {
		if (node == null)
			return 0;
		
		if(!node.hasLeftChild() && !node.hasRightChild())
				return 1;
		
		if (node.hasBothChilds())
			return LeavesQty(node.left) + LeavesQty(node.right);
		
		else if( node.hasLeftChild() && !node.hasRightChild())
			return LeavesQty(node.left);
		else
			return LeavesQty(node.right);
	}
	
	private void printDescendants(Node<T> node){
		if(node == null)
			return;
		System.out.println(node.elem);
		printDescendants(node.left);
		printDescendants(node.right);
		
	}
	
	public void printDescendants(T elem){
		Node<T> node = findNode(root, elem);
		if(node == null)
			System.out.println("No se encontro el elemento");
		printDescendants(node.left);
		printDescendants(node.right);
	}

	private Node<T> findNode(Node<T> node,T elem) {
		if(node == null)
			return null;
		
		if(cmp.compare(node.elem, elem) == 0)
			return node;
		
		else if (cmp.compare(node.elem, elem) < 0)
			return findNode(node.right, elem);
		
		return findNode(node.left,elem);
		
	}

	public void printPredecesors(T elem){
		printPredecesors(root,elem,false);
	}

	private boolean printPredecesors(Node<T> node, T elem, boolean found) {
		if (node == null)
			return false;

		
		if(cmp.compare(node.elem, elem) == 0 && !found)
			return true;

		else if (cmp.compare(node.elem, elem) < 0 && !found)
			found =printPredecesors(node.right, elem,found);
		
		else if (cmp.compare(node.elem, elem) > 0 && !found)
			found = printPredecesors(node.left,elem,found);
		
		if(found)
			System.out.println(node.elem.toString());
		
		return found;
			
	}
	
	public List<T> getFromTo(T min, T max){
		List<T> list = new ArrayList<>();
		getFromTo(root,min, max, list);
		return list;
	}

	private void getFromTo(Node<T> node,T min, T max, List<T> list) {
		if(node == null)
			return;
		
		if(cmp.compare(node.elem, min) >= 0 && cmp.compare(node.elem, max) <= 0)
			list.add(node.elem);
		
		if(cmp.compare(node.elem, min) >= 0 && node.hasLeftChild())
			getFromTo(node.left,min,max, list);
			
		
		if(cmp.compare(node.elem, max) <= 0 && node.hasRightChild())	
			getFromTo(node.right,min,max,list);
		
	}
		
}
		
		
	
    
	

