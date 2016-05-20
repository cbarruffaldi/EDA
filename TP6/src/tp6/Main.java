package tp6;

public class Main {
	public static void main(String[] args) {
		SimpleMapImpl<Integer,String> map = new SimpleMapImpl<>();
		
//		map.put(0, "a");
//		map.put(1, "b");
//		map.put(2, "c");
//		map.put(3, "d");
//		map.put(0, "e");
//		map.put(5, "f");
//		
		for(int i = 0; i< 100; i++){
			map.put(i, "A" +i);
		}
	}
}
