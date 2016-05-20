package parcial2013;

import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		SortedFastListImpl<Integer> list = new SortedFastListImpl<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}});
		
		list.add(2);
		list.add(10);
		list.add(4);
		list.add(0);
		list.add(25);
		list.print();
		
		
	}
	
}
