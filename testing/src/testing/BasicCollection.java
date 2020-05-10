/*
 * package testing;
 * 
 * import java.util.ArrayDeque; import java.util.ArrayList; import
 * java.util.Collections; import java.util.HashMap; import java.util.HashSet;
 * import java.util.LinkedHashMap; import java.util.LinkedHashSet; import
 * java.util.LinkedList; import java.util.List; import java.util.Map; import
 * java.util.Map.Entry; import java.util.PriorityQueue; import java.util.Queue;
 * import java.util.Set; import java.util.Stack; import java.util.TreeMap;
 * import java.util.TreeSet; import java.util.Vector;
 * 
 * import org.apache.commons.collections.comparators.ReverseComparator;
 * 
 * public class BasicCollection {
 * 
 * public static void main (String args[]) {
 * 
 * 
 * String s[]= {"abc","abc"}; System.out.println(s);
 * 
 * int[] array = new int[5]; array[0]=4;
 * 
 * ArrayList<Integer> arrayList = new ArrayList<Integer>(); arrayList.add(2);
 * arrayList.add(6); System.out.println(arrayList.isEmpty());
 * 
 * LinkedList<Integer> linkedList = new LinkedList<Integer>();
 * linkedList.add(2); linkedList.add(5);
 * 
 * //List<Integer> arrayList1= new ArrayList<Integer>(); //List<Integer>
 * linkedList1= new LinkedList<Integer>();
 * 
 * Vector<Integer> v = new Vector<Integer>(); v.add(1); System.out.println(v);
 * 
 * Stack<Integer> stack = new Stack<Integer>(); stack.add(5); stack.push(7);
 * stack.add(10); System.out.println(stack); stack.pop();
 * System.out.println(stack);
 * 
 * ArrayDeque<Integer> arrayDq = new ArrayDeque<Integer>(); arrayDq.addFirst(1);
 * arrayDq.addFirst(5); System.out.println(arrayDq);
 * 
 * Queue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());
 * pq.add(32); pq.add(13); pq.add(89);
 * 
 * 
 * for(int i=0; i<3; i++) { System.out.println(pq.poll()); }
 * 
 * Set<Integer> hashSet =new HashSet<Integer>(); hashSet.add(2); hashSet.add(3);
 * for(int a : hashSet) { System.out.println(a); }
 * 
 * 
 * Set<String> linkedSet = new LinkedHashSet<String>(); Set<String> treeSet =
 * new TreeSet<String>();
 * 
 * Map<String, String> hashMap = new HashMap<String, String>(); hashMap.put("1",
 * "A"); hashMap.put("2", "B"); hashMap.put("3", "C");
 * 
 * for(Entry e: hashMap.entrySet()) { System.out.println(e.getKey()+" "+
 * e.getValue()); }
 * 
 * Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
 * Map<String, String> treeMap = new TreeMap<String, String>();
 * 
 * } }
 */