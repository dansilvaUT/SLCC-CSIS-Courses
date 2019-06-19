import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyValuePair p1 = new KeyValuePair("SLC",189899);
		KeyValuePair p2 = new KeyValuePair("NY",8244910);
		
		KeyValuePair p3 = new KeyValuePair("LA",3819702);
		KeyValuePair p4 = new KeyValuePair("SF",812826);
		
		List<KeyValuePair> cities = new ArrayList<>();
		cities.add(p1);
		cities.add(p2);
		cities.add(p3);
		cities.add(p4);
		
		System.out.println("p1: " + p1.toString());
		System.out.println("p2: " + p2.toString());
		System.out.println("p1.equals(p2): "  + p1.equals(p2));
		System.out.println();
		
		p1 = p2;
		
		System.out.println("p1: " + p1.toString());
		System.out.println("p2: " + p2.toString());
		System.out.println("p1.equals(p2): "  + p1.equals(p2));
		System.out.println();
		
		
		printList(cities);
		System.out.println();
		printSortedList(cities);
	}

	private static void printList(List<KeyValuePair> cities) {
		for(KeyValuePair kv : cities) {
			System.out.println(kv);
		}
	}
	
	private static void printSortedList(List<KeyValuePair> cities) {
		Collections.sort(cities);
		for(KeyValuePair kv : cities) {
			System.out.println(kv);
		}
	}

}
