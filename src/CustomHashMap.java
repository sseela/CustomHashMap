import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomHashMap<K, V> {
	
	private int capacity;
	private Entry<K, V> buckets[];
	
	public CustomHashMap(int capacity) {
		this.capacity = capacity;
		buckets = new Entry[capacity];
	}
	
	public int getHash(K key) {
		return key.hashCode();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void put(K key, V value) {
		int bucketIndex = getHash(key) % capacity;
		if(this.buckets[bucketIndex] != null) {
			this.buckets[bucketIndex].setNext(new Entry(key, value));
		} else {
			this.buckets[bucketIndex] = new Entry(key, value);
		}
	}
	
	public List<V> get(K key) {
		List<V> list = new ArrayList<V>();
		
		int bucketIndex = getHash(key) % capacity;
		Entry<K, V> entry = this.buckets[bucketIndex];
		list.add(entry.getValue());
		while(entry.getNext() != null) {
			list.add(entry.getValue());
			entry = entry.getNext();
		}
		return list;
	}
	
	public void printMap() {
		for(Entry<K, V> entry: buckets) {
			if(entry != null) {
				System.out.println(entry.getKey()+"-"+entry.getValue());
				Entry nextEntry = entry.getNext();
				while(nextEntry != null) {
					System.out.println(nextEntry.getKey()+"-"+nextEntry.getValue());
					nextEntry = nextEntry.getNext();
				}
			}
		}
	}
	
	
}
