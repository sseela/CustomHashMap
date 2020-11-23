import java.util.HashMap;

public class CustomHashMapImpl {
	public static void main(String[] args) {
		CustomHashMap<String, String> map = new CustomHashMap<>(10);
		HashMap<K, V>
		String key = "first";
		map.put(key, "sandeep");
		map.put("second", "krishna");
		map.put("third", "rupesh");
		map.put(key, "seenu");
		map.printMap();
		
		System.out.println("get based on key");
		System.out.println(map.get(key).get(0));
	}
}
