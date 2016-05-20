package parcial2012;

public class BagImpl<T> implements Bag<T> {

	private Node<T> first;
	private Node<T> last;
	
	private static class Node<T>{
		private T elem;
		private int qty;
		private Node<T> next, prev;
		
		public Node(T elem, Node<T> prev, Node<T> next){
			this.elem = elem;
			this.prev = prev;
			this.next = next;
		}
		public Node(T elem){
			this.elem = elem;
		}
		
	}


	@Override
	public void add(T elem) {
		if(elem == null)
			throw new IllegalArgumentException();
		if(first == null && last == null){
			Node<T> n = new Node(elem);
			first = n;
			last = n;
			return;
		}
		
		Node<T> current = first;
		
		while(current != null && !current.equals(elem)){
			current = current.next;
		}	
			if( current == null){
				last.next = new Node(elem, last, current);
				last = last.next;
			} else {
				current.qty++;
				swapLeft(current);
			}
			
	}
		
	


	private void swapLeft(Node<T> n) {
		
		if( n == first){			//si ya es era el que mas tenia
			return;			
		}
		if (n == last && n.prev != null &&  n.qty > n.prev.qty){
			last = n.prev;				//cambio el last sabiendo que voy a swappear
		}
		while(n.prev != null && n.qty > n.prev.qty){
			swapOneLeft(n);
		}
		
		if(n.prev == null){			//quedo en la primera posicion
			first = n;
		}
		
		
	}




	private void swapOneLeft(Node<T> n) {
		Node<T> node = n.prev;
		
		if( node.prev != null)
			node.prev.next = n;
		node.next = n.next;
		if(n.next != null)
			n.next.prev = node;
		
		n.prev = node.prev;
		node.prev = n;
		n.next = node;
		
		
	}




	@Override
	public void remove(T elem) {
		// Parecido al add, nada mas que resta y swapRight
		
	}


	@Override
	public void print() {
		Node<T> current = first;
		String s = "";
		while(current != null){
			s = s +current.elem + "(" + current.qty + ")	" ;
		}
	}
	
	
}
