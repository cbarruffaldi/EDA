package bstTree;

public class Tree {
	
	/*Version NO eficiente, pues busca en cada paso el menor y el mayor valor del subárbol */
	public boolean isBST (Tree t){
		
		/*Si el arbol es vacio*/
		if(t == null)
			return true;
		
		/*Si tiene hijos a la izquierda y el mayor valor del subarbol izquierdo es mayor al valor del nodo actual */
		if (t.hasLeft() && (maxValue(t.left()) > t.getValue()))
			return false;
		
		/*Si tiene hijos a la derecha y el mayor valor del subarbol derecho es mayor al valor del nodo actual */
		if (t.hasRight() && (minValue(t.right()) < t.getValue()))
			return false;
		
		/*Si el los subarboles no son BST */
		if (!isBSTT(t.left()) || !isBST(t.right()))
			return false;
		
		return true;
		
	}
	
	/* Version mas eficiente que guarda en cada paso el mayor y el menor valor que puede tomar cada nodo 
	 * minValue retorna el menor valor de todo el árbol
	 * maxValue retorna el mayor valor de todo el árbol
	 * */
	 public boolean CheckifBST(Tree t) {
	        return isBST(t,t.minValue(), t.maxValue());
	    }


	    public boolean isBST(Tree t, int min, int max) {
	    	
	    	if (t==null)
	    		return true;
    	       
	    	  /*Si el valor del nodo supera al maximo o es menor que el mínimo no es BST */ 
	    	  if (t.getValue() < min || t.getValue() > max) 
	    	     return false; 
	    	 
	    	  /*Si tiene subarbol izquierdo, el maximo valor que pueden tener todos sus hijos es el valor del nodo menos 1 (no puede
	    	   * ser igual por definicion de BST) */
	    	  if (t.hasLeft() && !isBST(t.left(), min, t.getValue()-1))
	    		  return false;
	    	  
	    	  /*Si tiene subarbol derecho, el minimo valor que pueden tener todos sus hijos es el valor del nodo mas 1
	    	   *  (no puede ser igual por definicion de BST)*/
	    	  if (t.hasRight() && !isBST(t.right(), t.getValue() + 1, max))
	    		  return false;
	    	  
	    	  return true;    	
	    				
}
}
