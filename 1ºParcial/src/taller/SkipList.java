package taller;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SkipList<T> {
	
	private HeaderNode<T> header = new HeaderNode<>();	
	private Comparator<T> cmp;
	
	public SkipList(Comparator<T> cmp){
		this.cmp = cmp;
	}
	
	
	private class HeaderNode<T>{
		
		List<Node<T>> pointers = new LinkedList<Node<T>>(); //Contiene una lista de punteros a Nodos
		
		private class Node<T>{
			
			T elem;
			List<Node<T>> list = new LinkedList<>();		//Contiene una lista de punteros a nodos 
															//Bajo mi criterio el primero siempre será el siguiente
			public Node(T elem){
				this.elem = elem;
			}
		}
		
	}
	
	
	private boolean belongs(T elem){
		Node
		
		
	}
	

	
	
}
