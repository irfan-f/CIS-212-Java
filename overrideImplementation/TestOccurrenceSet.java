import java.util.Arrays;

public class TestOccurrenceSet {

	public static void main(String[] args) {
		
		OccurrenceSet<Integer> intSet = new OccurrenceSet<Integer>();
		OccurrenceSet<String> stringSet = new OccurrenceSet<String>();
		
		intSet.add(1);
		intSet.add(3);
		intSet.add(5);
		intSet.add(5);
		intSet.add(3);
		intSet.add(3);
		intSet.add(3);
		
		stringSet.add("hello");
		stringSet.add("hello");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("here");
		
		System.out.println(intSet.toString());
		System.out.println(stringSet.toString());
		System.out.println();
		
		System.out.println("Should be identical");
		
		System.out.println(Arrays.toString(intSet.toArray()));
		System.out.println(Arrays.toString(stringSet.toArray()));
		
		OccurrenceSet<Integer> largeIntSet = new OccurrenceSet<Integer>();
		largeIntSet.addAll(intSet);
		largeIntSet.add(7);
		largeIntSet.add(9);
		largeIntSet.add(6);
		
		System.out.println();
		
		System.out.println(largeIntSet);
		largeIntSet.retainAll(intSet);
		System.out.println("Retain the small integers");
		System.out.println(largeIntSet);
	}
	

}
