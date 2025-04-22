package StreamsInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class ProductStream {
	
	int pId;
	String pName;
	float pPrice;
	String type;
	
	public ProductStream(int pId, String pName, float pPrice) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
	}
	
	public static void main(String[] args) {
		
		List<ProductStream> productsList = new ArrayList<ProductStream>();
		
		productsList.add(new ProductStream(1, "HP Laptop", 35000f));
		productsList.add(new ProductStream(2, "Dell Laptop", 45000f));
		productsList.add(new ProductStream(3, "Lenevo Laptop", 30000f));
		productsList.add(new ProductStream(4, "Sony Laptop", 55000f));
		productsList.add(new ProductStream(5, "Apple Laptop", 90000f));
		productsList.add(new ProductStream(6, "Apple Laptop", 85000f));
		
		List<String> productsName = productsList.stream().filter(p -> p.pPrice >= 45000).map(p -> p.pName).toList();
		System.out.println("Get the productName having price >= 45000 : " +productsName);
		
		ProductStream productMaxPrice = productsList.stream().max((p1, p2) -> p1.getpPrice() > p2.getpPrice() ? 1 : -1).get();
		System.out.println("Get the productName having max price : " +productMaxPrice.getpPrice());
		
		//System.out.println(productsList.stream().max((p1, p2) -> (int) (p1.getpPrice() - p2.getpPrice())).get());
		
		ProductStream productMinPrice = productsList.stream().min((p1, p2) -> p1.pPrice > p2.pPrice ? 1 : -1).get();
		System.out.println("Get the productName having min price : " +productMinPrice.pPrice);
		
		//Interview
		List<Float> sortedSalaryAsc = productsList.stream().map(p -> p.pPrice).sorted().toList();
		System.out.println("Get the sortedSalary in ASC : " +sortedSalaryAsc);
		
		List<Float> sortedSalaryDesc = productsList.stream().map(p -> p.pPrice).sorted(Collections.reverseOrder()).toList();
		System.out.println("Get the sortedSalary in DESC : " +sortedSalaryDesc);
		
		//Interview
		Float secondHighestSalary = productsList.stream().map(p -> p.pPrice).sorted(Collections.reverseOrder()).skip(1).findFirst().get();;
		System.out.println("Get the secondHighestSalary : " +secondHighestSalary);
		
		//Interview
		double sumOfSalery = productsList.stream().collect(Collectors.summingDouble(ProductStream :: getpPrice));
		System.out.println("Get the sumOfSalery : " +sumOfSalery);
		
		DoubleSummaryStatistics summary = productsList.stream().collect(Collectors.summarizingDouble(ProductStream :: getpPrice));
		System.out.println("Get the summarySalary : " +summary);
		
		//Interview
		List<ProductStream> products = productsList.stream().sorted(Comparator.comparing(ProductStream :: getpName)
				.thenComparing(p -> p.pPrice)).toList();
		for(ProductStream p : products) {
			System.out.println("Sorted products on name and price : " +p.pName + " " +p.pPrice);
		}
		
		//Interview
		List<String> inputList = Arrays.asList("apple", "dog", "banana", "cat", "grape");

        List<String> sortedList = inputList.stream().sorted(Comparator.comparing(String::length)
                .thenComparing(Comparator.naturalOrder())).toList();

        System.out.println(sortedList); // Output: [cat, dog, apple, grape, banana]
		
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public float getpPrice() {
		return pPrice;
	}

	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
