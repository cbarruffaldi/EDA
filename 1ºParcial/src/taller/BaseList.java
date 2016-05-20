package taller;

public class BaseList<T> {
	private T head;
	private BaseList<T> tail;
	
	public BaseList(){
		
	}
	public BaseList(BaseList<T> next){
		this.tail = next;
	}
	
}
