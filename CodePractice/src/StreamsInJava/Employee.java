package StreamsInJava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee
{
    int id;
    String name;
    int age;
    String gender;    
    String department;    
    int yearOfJoining;    
    double salary;
     
    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
    
    public static void main(String[] args) {
	    List<Employee> employeeList = new ArrayList<Employee>();
	    
	    employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
	    employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
	    employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
	    employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
	    employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
	    employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
	    employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
	    employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
	    employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
	    employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
	    employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
	    employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
	    employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
	    employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
	    employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
	    employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
	    employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
	    
	    //INTERVIEW EY: WAP to print the names of all Departments which have more than 3 male Employees?
	    System.out.println(employeeList.stream().filter(emp -> emp.getGender().equals("Male")).collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.counting()))
		.entrySet().stream().filter(entry -> entry.getValue() >= 3).map(entry -> entry.getKey()).collect(Collectors.toList()));
	    
	    //INTERVIEW Mphasis: WAP to print the names of all Employees group by Departments?
	    System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.toList())));
	    
	    //How many male and female employees are there in the organization?
	    Map<String, Long> employeeGenderWiseMap = employeeList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.counting()));
	    System.out.println("Male and female employees are there in the organization : " +employeeGenderWiseMap);
	    System.out.println("--------------------------------------");
    
	    //Print the name of all departments in the organization?
	    System.out.println("The name of all departments in the organization : " +employeeList.stream().map(Employee :: getDepartment).distinct().toList());
	    System.out.println("--------------------------------------");
	    employeeList.stream().map(Employee :: getDepartment).distinct().forEach(System.out :: println);
	    
	    //What is the average age of male and female employees?
	    Map<String, Double> averageAgeOfMaleFemaleEmployee = employeeList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.averagingDouble(Employee :: getAge)));
	    System.out.println("Average age of male and female employees : " +averageAgeOfMaleFemaleEmployee);
	    System.out.println("--------------------------------------");
	
	    //Get the details of highest paid employee in the organization?
	    Employee highesTPaidEmployee = employeeList.stream().max((e1, e2) -> (int) (e1.getSalary() - e2.getSalary())).get();
	    System.out.println("Highest paid employee name is " + highesTPaidEmployee.getName() + " with salary : " +highesTPaidEmployee.getSalary());
	    
	    System.out.println("Highest paid employee in the organization : " +employeeList.stream().max((e1, e2) -> e1.salary > e2.salary ? 1 : -1).get());
	    System.out.println("--------------------------------------");
	    
	    //Get the names of all employees who have joined after 2015?
	    List<String> joinedAfter2015 = employeeList.stream().filter(e1 -> e1.getYearOfJoining() > 2015).map(e1 -> e1.getName()).toList();
	    System.out.println("Names of all employees who have joined after 2015: " + joinedAfter2015);
	    System.out.println("--------------------------------------");
	    
	    //Count the number of employees in each department?
	    Map<String, Long> employeeDepartmentWiseMap = employeeList.stream().collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.counting()));
	    System.out.println("Count the number of employees in each department : " +employeeDepartmentWiseMap);
	    System.out.println("--------------------------------------");
	    
	    //What is the average salary of each department?
	    Map<String, Double> avgSalaryDepartmentWiseMap = employeeList.stream().collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.averagingDouble(Employee :: getSalary)));
	    System.out.println("The average salary of each department : " +avgSalaryDepartmentWiseMap);
	    System.out.println("--------------------------------------");
	    
	    //Get the details of youngest male employee in the product development department?
	    String youngestMaleEmployeeName = employeeList.stream().filter(e1 -> e1.getGender().equals("Male") && e1.getDepartment().equals("Product Development"))
	    		.min((e1, e2) -> e1.getAge() > e2.getAge() ? 1 : -1).map(e -> e.getName()).get();
	    System.out.println("The youngest male employee in the product development department : " +youngestMaleEmployeeName);
	    System.out.println("--------------------------------------");
	    
	    //Who has the most working experience in the organization?
	    Employee mostWorkingExperienceEmployee = employeeList.stream().min((e1, e2) -> e1.getYearOfJoining() > e2.getYearOfJoining() ? 1 : -1).get();
	    System.out.println("The most working experience in the organization : " +mostWorkingExperienceEmployee.getName());
	    
	    System.out.println("The most working experience in the organization : " +employeeList.stream().sorted((e1, e2) -> e1.getYearOfJoining() - e2.getYearOfJoining()).toList());
	    
	    System.out.println("The most working experience in the organization : " +employeeList.stream().sorted(Comparator.comparing(Employee :: getYearOfJoining)).map(e -> e.getName()).findFirst().get());
	    
	    //System.out.println("The most working experience in the organization : " +employeeList.stream().map(e1 -> e1.getYearOfJoining()).sorted().findFirst().get());
	    System.out.println("--------------------------------------");
	    
		//How many male and female employees are there in the sales and marketing team?
	    Map<String, Long> employeesInSalesAndMarketing = employeeList.stream().filter(e1 -> e1.getDepartment().equals("Sales And Marketing")).
	    		collect(Collectors.groupingBy(Employee :: getGender , Collectors.counting()));
	    System.out.println("Male and female employees are there in the sales and marketing team : " +employeesInSalesAndMarketing);
	    System.out.println("--------------------------------------");
	    
		//What is the average salary of male and female employees?
	    Map<String, Double> averageSalaryOfMaleFemaleEmployee = employeeList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.averagingDouble(Employee :: getSalary)));
	    System.out.println("Average salary of male and female employees : " +averageSalaryOfMaleFemaleEmployee);
	    System.out.println("--------------------------------------");
	    
		//List down the names of all employees in each department?
	    Map<String, List<Employee>> employeesInEachDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee :: getDepartment));
//	    employeesInEachDepartment.forEach((departments, employeeLists) -> {System.out.println("The department is : " +departments); employeeLists
//	    	.forEach(emp -> System.out.println(emp.getName()));});
	    for(Map.Entry<String, List<Employee>> entryMap : employeesInEachDepartment.entrySet()) {
	    	System.out.println("--------------------------------------");
	    	System.out.println("The department is : " +entryMap.getKey());
	    	System.out.println("--------------------------------------");
	    	List<Employee> empList = entryMap.getValue();
	    	for(Employee employee : empList) {
	    		System.out.println(employee.getName());
	    	} 
	    }
	    System.out.println("--------------------------------------");
	    //System.out.println("The names of all employees in each department : " +employeesInEachDepartment);
	    
		//What is the average salary and total salary of the whole organization? 
	    DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
	    		         
	    System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());
	    		         
	    System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());
	    System.out.println("--------------------------------------");
	    
		//Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years?
	    Map<Boolean, List<Employee>> partitionEmployeesByAge = employeeList.stream().collect(Collectors.partitioningBy(e1 -> e1.getAge() > 25));
//	    System.out.println("Employee age is more than 25 years");
//	    partitionEmployeesByAge.get(true).forEach(emp -> System.out.println(emp.getName())); 
//	    
//	    System.out.println("Employees are younger or equal to 25 years");
//	    partitionEmployeesByAge.get(false).forEach(emp -> System.out.println(emp.getName())); 
	    
	    for(Map.Entry<Boolean, List<Employee>> mapEntry : partitionEmployeesByAge.entrySet()) {
	    	System.out.println("--------------------------------------");
	    	if(mapEntry.getKey()) {
	    		System.out.println("Employee age is more than 25 years");
	    	}
	    	else {
	    		System.out.println("Employees are younger or equal to 25 years");
	    	}
	    	System.out.println("--------------------------------------");
	    	List<Employee> employeeList1 = mapEntry.getValue();
	    	for(Employee emp : employeeList1) {
	    		System.out.println(emp.getName());
	    	}
//	    	for(Employee emp : mapEntry.getValue()) {
//	    		System.out.println(emp.getName());
//	    	}
	    }
	    System.out.println("--------------------------------------");
	    
		//Who is the oldest employee in the organization? What is his age and which department he belongs to?
	    Employee emp = employeeList.stream().max((e1, e2) -> e1.getAge() > e2.getAge() ? 1 : -1).get();
	    System.out.println("The oldest employee in the organization : " +emp.getName() + " his age is " +emp.getAge() + " and department is " +emp.getDepartment());
	    System.out.println("--------------------------------------");
	    
	    //All Department names with delimiter :::
	    String empDepartments = employeeList.stream().map(Employee :: getDepartment).collect(Collectors.joining(":::"));
	    System.out.println("Department names with delimiter : " +empDepartments);
	    
	    System.out.println("--------------------------------------");
	    
	    //Find the max salary Department wise
	    Map<String, Optional<Employee>> maxSalaryByDepts = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy((e1, e2) -> e1.salary > e2.salary ? 1 : -1)));
	    
	    Map<String, Optional<Employee>> maxSalaryByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
	                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

    	maxSalaryByDept.forEach((dept, empOpt) -> empOpt.ifPresent(emps -> 
	                System.out.println("Department: " + dept + ", Employee: " + emps.getName() + ", Salary: " + emps.getSalary())));
    }

    public int getId() 
    {
        return id;
    }
     
    public String getName() 
    {
        return name;
    }
     
    public int getAge() 
    {
        return age;
    }
     
    public String getGender() 
    {
        return gender;
    }
     
    public String getDepartment() 
    {
        return department;
    }
     
    public int getYearOfJoining() 
    {
        return yearOfJoining;
    }
     
    public double getSalary() 
    {
        return salary;
    }
     
    @Override
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }
}
