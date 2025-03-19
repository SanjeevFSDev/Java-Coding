package String;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Employee {
	
	int id;
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee();
		e1.setId(10);
		e1.setName("Sanjee");
		
		Employee e2 = new Employee();
		e2.setId(10);
		e2.setName("Sanjee");
		
		System.out.println(e1.equals(e2));
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8 , 9, 10);

		List<Integer> list2 = list1.stream().filter(a -> a%2 == 0).map(a -> 2*a).collect(Collectors.toList());
		
		System.out.println(list2);
		
	}

}
