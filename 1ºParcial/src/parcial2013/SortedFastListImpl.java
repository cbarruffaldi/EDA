package parcial2013;

import java.util.Comparator;

public class SortedFastListImpl<T> implements SortedFastList<T>{

	private Comparator<T> cmp;
	private Node<T> first;
	
	private static class Node<T>{
		private T elem;
		private Node<T> next, jump;
		
		public Node(T elem){
			this.elem = elem;
		}
		public Node(T elem, Node<T> n1, Node<T> n2){
			this.elem = elem;
			this.next = n1;
			this.jump = n2;
		}
	}
	
	public SortedFastListImpl(Comparator<T> cmp) {
		this.cmp = cmp;
	}

	@Override
	public void add(T elem) {
		first = add(elem, first);
	}

	private Node<T> add(T elem, Node<T> node) {
		if( node == null)	// si es el ultimo
			return new Node<T>(elem);

		int comp = cmp.compare(node.elem, elem);
		
		if( comp > 0){
			return new Node<T>(elem,node, node.next);
		} else if (comp < 0){
			if( node.jump != null && cmp.compare(elem, node.jump.elem) > 0){
				node.jump = add(elem,node.jump);
			} else{
					node.next = add(elem, node.next);
					node.jump = node.next.next;
				}
			}
		return node;	
		}
		
	

	@Override
	public void print() {
		printNodes(first);
		
	}

	private void printNodes(Node<T> n) {
		if(n == null)
			return;
		System.out.println(n.elem.toString());
		printNodes(n.next);
		
	}
	
}
