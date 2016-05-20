package parcial2013;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T> {
	private T value;
	private BinaryTree<T> right, left;
	
	public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T>right){
		this.value = value;
		this.right = right;
		this.left= left;
	}
	
	public static <T> BinaryTree BuildFromList(List<T> list){
		if(list.isEmpty())
			return null;
		
		Queue<BinaryTree<T>>q = new LinkedList();
		Iterator<T> it = list.iterator();
		BinaryTree<T> root = new BinaryTree<T>(it.next(),null,null);
		q.offer(root);			//Pongo la raiz en la cola por que ya se que no es null
		
		while(it.hasNext()){		//Consumo la lista
			BinaryTree<T> parent = q.poll();
			
			BinaryTree<T> l = new BinaryTree(it.next(),null,null);		//pusheo el hijo izquierdo
			q.offer(l);
			parent.left = l;			//asocio al parent su hijo
			if(it.hasNext()){
				BinaryTree<T> r = new BinaryTree<T>(it.next(), null, null);
				q.offer(r);			//pusheo el hijo izquierdo
				parent.right = r;		//asocio al parent su hijo
			}
			
		}
		
		return root;		//retorno el nodo raiz;
		
	}
	
	public void printPreorder(){
		if(this == null)
			return;
		printRec(this);
		
	}

	private void printRec(BinaryTree<T>t ) {
		if (t == null)
			return;
		System.out.println(t.value.toString());
		printRec(t.left);
		printRec(t.right);
		
	}
}
