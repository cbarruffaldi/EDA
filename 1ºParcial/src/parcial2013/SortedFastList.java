package parcial2013;

public interface SortedFastList<T> {
	
	/*Agrega un elemento en la posicion correspondiente segun el comparador recibido en el constructor 
	 * Recorre a lo sumo N/2+1 nodos
	 */
	public void add(T elem);
	
	/*Imprime todos los elementos de la lista */
	public void print();
}
