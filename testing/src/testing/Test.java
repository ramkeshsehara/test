package testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test{
	public static void main(String args[]) {

		List<Student> stdList= new ArrayList<>();		
		Student std1= new Student(12,"ram","mahwa");
		Student std2 = new Student(4,"skk", "Jaipur");
		stdList.add(std1);
		stdList.add(std2);

		Collections.sort(stdList, new AgeComparator());; stdList.forEach(std ->{
			System.out.println(std.age); System.out.println(std.name); });


		Map<Integer ,String> mapData = new LinkedHashMap<>();
		mapData.put(11, "rk");
		mapData.put(2,"sk");
		mapData.put(30, "abc");

		System.out.println("Map data without sorting");
		printMap(mapData);

		System.out.println("Map data in sorted format");

		Map<Integer, String> sortMap = new TreeMap<>(mapData);
		printMap(mapData);

	}

	private static void printMap(Map<Integer, String> mapData) {

		mapData.forEach((k,v) -> {
			System.out.println("Key: "+ k  + "Value" + v);			
		});

		for(Integer key: mapData.keySet()) {
			System.out.println( "Key" + key);
			System.out.println("value" +mapData.get(key));
		}


		for(Entry<Integer, String> e: mapData.entrySet()) {
			System.out.println(e.getKey());
			System.out.println(e.getValue()); 

		}


	}
}

class NameComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getName().compareTo(s2.getName())<0) return -1; 
		return 1;
	}	
}

class AgeComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getAge() < s2.getAge()) return -1;
		return 1;

	}

}

class Student{
	int age;
	String name;
	String address;

	public Student() {

	}
	public Student(int age, String name, String address){
		this.age=age;
		this.name= name;
		this.address=address;
	}
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;		
	}
	public String getAddress() {
		return address;
	}
}