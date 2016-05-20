package parcial2012;

/*TODOS LOS METODOS DEBEN SER DE ORDEN TEMPORAL Y ESPACIAL N */ 
public interface Bag<T> {
	/* Agrega un elemento a la coleccion */
	public void add(T elem);
	
	/*Elimina un elemento de la coleccion */
	public void remove(T elem);
	
	/*Imprime todos los elementos sin repetir, indicando la cantidad de veces que aparece cada uno
	 * y ordenado descendentemente por dicha cantidad.
	 */
	public void print();
	
}
