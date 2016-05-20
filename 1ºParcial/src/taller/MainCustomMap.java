package taller;

public class MainCustomMap {
	public static void main(String[] args) {
		CustomMapImpl<String, Integer> map =  new CustomMapImpl<>();
		
		map.put("carla", 10);
		map.put("hola", 0);
		map.put("mundo", 3);
		
		map.get("mundo");
	}
}
