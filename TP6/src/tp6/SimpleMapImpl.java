package tp6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleMapImpl<K,V> implements SimpleMap<K, V> {

	private int mod = 5;
	private int initialcap = 10;		//deberian ser de clase
	private int p;
	private int condition = 3;
	private int size;
	private List<Node<K,V>>[] array;
	
	
	private static class Node<K,V> {
		private K key;
		private V value;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	
	public SimpleMapImpl(){
		array = (List<Node<K, V>>[])Array.newInstance(List.class, initialcap);
		initialize(0,mod);
		
	}
	
	public void initialize(int inf, int sup){
		for(int i = inf; i < sup ; i++) {
			array[i] = new ArrayList<Node<K,V>>();
		}
	}

	@Override
	public void put(K key, V value) {
		int index = getArrayIndex(key);
		
		int listindex = getListIndex(array[index],key);
		
		if(listindex != -1) {
			array[index].get(listindex).value = value;
		} else {
			array[index].add(new Node<K,V>(key,value));
			size++;
		}

			if(checkCondition()) {
				addBucket();
			}
		}
		
	

	/*
	 * El espacio que se usa del array 
	 */
	private int arrayLength(){
		return p + mod;
	}

	private void addBucket() {
		array[arrayLength()] = new ArrayList<Node<K,V>>();		//agrego un bucket
		reHash();
		size++;
		p++;
		
		if( p == mod) {		//llego al tope del array
			mod = mod *2;
			p = 0;
			Arrays.copyOf(array, mod*2);
		}
		
	}

	private void reHash() {
		List<Node<K,V>> old = array[p];		//del que cambio
		List<Node<K,V>> last = array[arrayLength()];
		
		for(Node<K,V> node : old) {
			int i = node.key.hashCode() % (mod*2);
			
			if(i != p) {
				old.remove(node);
				last.add(node);
			}
		}
	}

	/*
	 * Retorna false si no cumple la condicion y hay que expandir, true si no
	 */
	private boolean checkCondition (){
		return (size % arrayLength()) > condition;
	}
	
	private int getArrayIndex(K key) {
		int hashCode = key.hashCode() % mod;
		
		if( hashCode < p) {
			hashCode = hashCode % (mod * 2);
		}
		
		return hashCode;
	}

	private int getListIndex(List<Node<K, V>> list, K key) {
		int i = 0;
		for(Node<K,V> node : list){
			if(node.key.equals(key)){
				return i;
			}
			i++;
			
		}
		return -1;		//-1 es codigo de NOT FOUND
		
		

	}

	@Override
	public V get(K key) {
		int i = getArrayIndex(key);
		int k = getListIndex(array[i], key);
		if(k == -1 )
			return null;
		
		return array[i].get(k).value;
			
		}
	

	@Override
	public void remove(K key) {
		int index = getArrayIndex(key);
		
		for(Node<K,V> node : array[index]) {
			if(node.key.equals(key)) {
				array[index].remove(node);
				size--;
				return;
			}
		}
		return;
		
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<>();
		for( int i = 0; i < arrayLength(); i++) {
			for(Node<K,V> node : array[i]){
				set.add(node.key);
			}
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		Collection<V> coll = new ArrayList<>();
		for( int i = 0; i < arrayLength(); i++) {
			for(Node<K,V> node : array[i]){
				coll.add(node.value);
			}
		}
		return coll;
	}

	@Override
	public int size() {
		
		return size;
	}
	
	
	
	
}
