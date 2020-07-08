import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.Comparator;


public class OccurrenceSet<T> implements Set<T> {
	
	private HashMap<T, Integer> map;
	
	public OccurrenceSet() {
		super();
		
		map = new HashMap<T, Integer>();
	}
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
	}
	
	@Override
	public int size() {
		return map.size();
	}
	
	@Override
	public Iterator<T> iterator() {
		ArrayList<T> list = new ArrayList<T>(map.keySet());
		Collections.sort(list, new OccurrenceComparator());
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		ArrayList<T> list = new ArrayList<T>(map.keySet());
		Collections.sort(list, new OccurrenceComparator());
		return list.toArray();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <E> E[] toArray(E[] a) {
			E[] items = (E[])this.toArray();
		
		if (a.length >= this.size()) {

			for (int i = 0; i < items.length; i++) {
				a[i] = items[i];
			}
			
			if (a.length > this.size()) {
				a[items.length] = null;
			}
			
			return a;
		}
		
		else {
			return items;
		}
		
	}

	@Override
	public boolean add(T t) {
		map.put(t, map.getOrDefault(t, 0) + 1);
		return true; 
	}

	@Override
	public boolean remove(Object o) {
		
		if (map.containsKey(o)) {
			map.remove(o);
			return true;
		}
		
		else {
			return false;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean doesContainAll = true;
		for (Object o : c) {
			doesContainAll = contains(o);
		}
		return doesContainAll;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (T t : c) {
			add(t);
		}
		return true;
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		HashMap<T, Integer> map1;
		boolean setChanged = false;
		map1 = new HashMap<T, Integer>(map);
		for (T element : map.keySet()) {
			if (!c.contains(element)) {
				setChanged = true;
				map1.remove(element);
			}
		}
		map = map1;
		return setChanged;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean setChanged = false;
		for (Object o : c) {
			setChanged |= c.remove(o);
		}
		return setChanged;
	}

	@Override
	public void clear() {
		map.clear();
		
	}
	public String toString() {
		ArrayList<T> list = new ArrayList<T>(map.keySet());
		Collections.sort(list, new OccurrenceComparator());
		return list.toString();
		
	}
	
	private class OccurrenceComparator implements Comparator<T> {
		public int compare(T o1, T o2) {
			int count1 = map.get(o1);
			int count2 = map.get(o2);
			int count = count1 - count2;
			return count;
		}
	}
}
