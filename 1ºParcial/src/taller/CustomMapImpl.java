package taller;

import java.util.Comparator;

public class CustomMapImpl<K,V> {

	/*
	 * Corresponde al de menos accedido
	 */
	Node<K,V> first;	
	
	/*
	 * Corresponde al mas accedido
	 */
	Node<K,V> last;

	
	private static class Node<K,V>{
		private K key;
		private V value;
		private int access;
		private Node<K,V> next;
		
		public Node(K key, V value){
			this.key = key;
			this.value = value;
		}
		
	}
	
	public V get(K key){
		Node<K,V> prev= null, current = first;
		
		if(first == null)		//No hay elementos, por lo tanto la clave no existe
			return null;
		
		while(current != null && key != current.key){
			prev = current;
			current = current.next;			
		}
			
		if(current == null)
			return null;
		
		current.access++;
		V ans = current.value;
		swap(prev,current);
		
		return ans;
		
	}
	
	public void put(K key, V value){
		Node<K,V> node = new Node(key,value);
		
		if(isEmpty()){
			node.next = null;
			first = node;
			last = node;
			return;
		}
		node.next = first;
		first = node;
		return;
			
	}
	
	public void swap(Node<K, V> prev, Node<K, V> current){
		
		if (prev == null && current.next != null && current.access > current.next.access) {
			first = current.next;
			swap2(prev, current);
			prev = first;
		}

		while (current.next != null && current.access > current.next.access) {
			swap2(prev, current);
			prev = prev.next; 
		}

		if (current.next == null) //es el ultimo de la lista
			last = current;
	}

				
		

	
		private void swap2(Node<K, V> prev, Node<K ,V> n) {
			if (n.next != null) {
				Node<K, V> next = n.next;
				if (prev != null)
					prev.next = next;
				n.next = next.next;
				next.next = n;
			}
		}
	
	
	public boolean isEmpty(){
		return first == null && last == null;
	}
}
