package StreamsInJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10, 20, 30, 40, 50, 60);
		
		//Sum of all the numbers
		System.out.println("Sum of all the numbers in the list : " +list.stream().mapToInt(Integer :: intValue).sum());
		
		System.out.println("Sum of all the numbers in the list : " +list.stream().reduce((a,b)-> a+b).get());
		
		//Square of given numbers (Interview)
		System.out.println("Square of all the numbers in the list : " +list.stream().map(num -> num*num).toList());
		
		System.out.println("Square of all the numbers in the list : " +list.stream().map(num -> num*num).collect(Collectors.toList()));
		
		System.out.println("Square of all the numbers and greater than 400 : " +
				list.stream().map(num -> num*num).filter(num -> num>400).toList());
		
		System.out.println("Square of all the numbers, greater than 400 and average : " +
				list.stream().map(num -> num*num).filter(num -> num>400).mapToInt(num -> num).average().getAsDouble());
		
		List<Integer> list2 = Arrays.asList(2, 2, 3, 4, 3, 6);
		
		System.out.println("Square of all the numbers and eliminate the duplicate ones : " +
				list2.stream().map(num -> num*num).distinct().toList());
		
		List<Integer> list3 = Arrays.asList(22, 232, 312, 412, -213, 116);
		
		//Print numbers starts with prefix 2 using streams(Interview)
		System.out.println("Print numbers starts with prefix 2 using streams : " +
				list3.stream().map(num -> String.valueOf(num)).filter(num -> num.startsWith("2") || num.startsWith("-2"))
				.map(num -> Integer.parseInt(num)).toList());
		
		//Print duplicate numbers using streams(Interview)
		List<Integer> list4 = Arrays.asList(2, 3, 2, 3, 1, 5, 7, 10, 1, 9, 101);
		
		System.out.println("Print duplicate numbers using streams : " +
				list4.stream().filter(num -> Collections.frequency(list4, num) > 1).distinct().toList());
		
		List<Integer> list5 = Arrays.asList(0, -2, 3, 12, 29, 37, 11, 5, 7, 10, 10, 9, 101, -107);
		
		//Interview
		System.out.println("Max number using streams : " + list5.stream().max((x,y) -> x > y ? 1 : -1).get());
		
		//Sort numbers ASC/DESC order using streams
		System.out.println("Sort numbers in ASC order : " + list5.stream().sorted().toList());
		
		System.out.println("Sort numbers in DESC order : " + list5.stream().sorted(Collections.reverseOrder()).toList());
		
		System.out.println("Get the sum of first 5 numbers : " + list5.stream().limit(5).reduce((a, b) -> a+b).get());
		
		System.out.println("Get the sum of first 5 numbers : " + list5.stream().limit(5).mapToInt(Integer :: intValue).sum());
		
		System.out.println("Get the sum by skipping first 5 numbers : " + list5.stream().skip(5).reduce((a, b) -> a+b).get());
		
		System.out.println("Get the second highest number : " + list5.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get());
		
		System.out.println("Get the second lowest number : " + list5.stream().sorted().skip(1).findFirst().get());
		
		List<String> names = Arrays.asList("Sanjeev", "Priti", "Yug", "Babu", "sanjeev", "Yug", "Yug", "Babu");
		
		System.out.println("Names start with S : " + names.stream().filter(str -> str.startsWith("S") || str.startsWith("s")).map(n->n).toList());
		
		//Interview
		System.out.println("Print duplicate strings using streams : " +
				names.stream().filter(str -> Collections.frequency(names, str) > 1).distinct().toList());
		
		names.stream().filter(str -> Collections.frequency(names, str) > 1).distinct().forEach((name) -> System.out.print(name + " "));
		
	}

}
