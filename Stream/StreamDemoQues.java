/*
🟢 Level 1 – Beginner (Must Know)

These questions help you master filter(), map(), sorted(), distinct(), count(), forEach().

Integer Problems
Print all even numbers.
Print all odd numbers.
Print numbers greater than 50.
Square every element.
Cube every element.
Remove duplicate elements.
Sort in ascending order.
Sort in descending order.
Count even numbers.
Count odd numbers.
Find maximum number.
Find minimum number.
Find first element.
Find any element.
Skip first 5 elements.
Print first 5 elements.
Reverse a list using Streams.
Sum of all numbers.
Average of numbers.
Convert Integer List → String List.
🟡 Level 2 – Intermediate (Most Asked)

These are real interview questions.

String Problems
Convert all names to uppercase.
Convert all names to lowercase.
Find strings starting with "A".
Find strings ending with "n".
Find strings having length > 5.
Sort strings by length.
Remove duplicate strings.
Count total strings.
Find longest string.
Find shortest string.
Join all strings using commas.
Count vowels in every string.
Reverse every string using map().
Find palindrome strings.
Find unique characters.
🟠 Level 3 – Employee Based (Most Important)

Create an Employee class.

class Employee{
    int id;
    String name;
    String department;
    double salary;
    int age;
}

Practice:

Employees whose salary > 50000
Employees whose age > 30
Sort employees by salary
Sort employees by age
Highest salary employee
Lowest salary employee
Average salary
Total salary expenditure
Employee names only
Department names only
Count employees
Group employees by department ⭐⭐⭐⭐⭐
Partition employees salary >50000 ⭐⭐⭐⭐
Find second highest salary ⭐⭐⭐⭐⭐
Find youngest employee
Find oldest employee
Find duplicate employee names
Convert List<Employee> → List<String>
🔴 Advanced Stream Interview Programs

These are asked in TCS, Infosys, Capgemini, Cognizant, Accenture, Deloitte, and many product companies.

Arrays / Integer
Second Largest Number ⭐⭐⭐⭐⭐
Second Smallest Number
Nth Largest Number
Frequency of every element ⭐⭐⭐⭐⭐
Duplicate Elements ⭐⭐⭐⭐⭐
Unique Elements
Missing Number
Sum of Digits
Largest Digit
Prime Numbers
Perfect Numbers
Armstrong Numbers
Fibonacci using Streams
Factorial
Merge two Lists
Common Elements of two Lists ⭐⭐⭐⭐⭐
Union of Lists
Intersection of Lists
Remove Null Values
Remove Negative Numbers
🟣 String Interview Programs (Very Frequently Asked)
Count frequency of characters ⭐⭐⭐⭐⭐
Count words
First non-repeated character ⭐⭐⭐⭐⭐
First repeated character
Reverse words
Reverse sentence
Sort words alphabetically
Longest word
Shortest word
Duplicate words
Remove duplicate words
Character occurrence map
Group anagrams ⭐⭐⭐⭐⭐
Find common characters
Find first unique word
⭐ Collectors (Very Important)

Don't skip these.

Collectors.toList()
Collectors.toSet()
Collectors.toMap()
Collectors.groupingBy() ⭐⭐⭐⭐⭐
Collectors.partitioningBy() ⭐⭐⭐⭐⭐
Collectors.joining()
Collectors.counting()
Collectors.mapping()
Collectors.summarizingInt()
Collectors.averagingDouble()
🔥 Top 20 Stream API Interview Questions (Highest Priority)

If you have limited time before interviews, master these first:

Print even numbers done
Print odd numbers done
Remove duplicates done
Sort ascending done
Sort descending done
Maximum element done
Minimum element done
Second largest number
Count frequency of elements
Group employees by department
Highest salary employee
Average salary
Convert names to uppercase
First non-repeated character
Find duplicate elements
Find palindrome strings
Merge two lists
Common elements of two lists
Collectors.groupingBy()
Collectors.partitioningBy()
*/
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
class Beginner{
	public void evenNumbers()
	{
		// Way1
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(13);
		list.add(5);
		list.add(57);
		list.add(90);
		list.add(2);
		
		
		list.stream().filter(a->a%2==0).forEach(System.out::println);
		
		System.out.println();
		
		// Way2
		Stream.of(90,10,0,23,24,25,26,27,45,34,47,86).filter(a->a%2==0).forEach(System.out::println);
		
		System.out.println();
		
		// Way3
		Integer[] arr = {1,2,3,4,5,5,6,7,8};
		Stream.of(arr).filter(a->a%2==0).forEach(System.out::println);
		
	}
	
	public void oddNumbers()
	{
		// Way1
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(13);
		list.add(5);
		list.add(57);
		list.add(90);
		list.add(2);
		
		
		list.stream().filter(a->a%2==1).forEach(System.out::println);
		
		System.out.println();
		
		// Way2
		Stream.of(90,10,0,23,24,25,26,27,45,34,47,86).filter(a->a%2==1).forEach(System.out::println);
		
		System.out.println();
		
		// Way3
		Integer[] arr = {1,2,3,4,5,5,6,7,8};
		Stream.of(arr).filter(a->a%2==1).forEach(System.out::println);
		
	}
	
	public void greaterThanFiftyNumbers()
	{
		// Way1
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(13);
		list.add(5);
		list.add(57);
		list.add(90);
		list.add(2);
		
		
		list.stream().filter(a->a>50).forEach(System.out::println);
		
		System.out.println();
		
		// Way2
		Stream.of(90,10,0,23,24,25,26,27,45,34,47,86).filter(a->a>50).forEach(System.out::println);
		
		System.out.println();
		
		// Way3
		Integer[] arr = {1,2,3,4,5,5,6,7,8};
		Stream.of(arr).filter(a->a>50).forEach(System.out::println);
		
	}
	
	public void squareEachElement()
	{
		Integer[] a1 = {1,2,3,4,5,6,7,8,9};
		Stream.of(a1).map(a->a*a).forEach(System.out::println);
	}
	public void cubeEachElement()
	{
		Integer[] a1 = {1,2,3,4,5,6,7,8,9};
		Stream.of(a1).map(a->a*a*a).forEach(System.out::println);
	}
	
	public void removeDuplicateElements()
	{
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		Stream.of(a1).distinct().forEach(System.out::println);
	}
	
	public void sortAsc()
	{
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		Stream.of(a1).sorted().forEach(System.out::println);
	}

	public void sortDesc()
	{
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		Stream.of(a1).sorted((a,b)->b-a).forEach(System.out::println);
	}
	
	public void countEven()
	{
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		System.out.println(Stream.of(a1).filter(a->a%2==0).count());
	}
	public void countOdd()
	{
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		System.out.println(Stream.of(a1).filter(a->a%2==1).count());
	}
	public void maxElement()
	{
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		System.out.println(Stream.of(a1).max((a,b)->a-b));
	}
	public void minElement()
	{
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		System.out.println(Stream.of(a1).min((a,b)->a-b));
	}
	public void findFirst()
	{
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		System.out.println(Stream.of(a1).findFirst());
	}
	public void findAny()
	{
		Integer[] a1 = {2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		System.out.println(Stream.of(a1).findAny());
	}
	
	public void skipFirst5()
	{
		Integer[] a1 = {2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		Stream.of(a1).skip(5).forEach(System.out::println);
	}
	
	public void startFive()
	{
		Integer[] a1 = {2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		Stream.of(a1).limit(5).forEach(System.out::println);
	}
	
	public void reverseList()
	{
		List<Integer> al = new  ArrayList<>();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		al.add(50);
		al.stream().sorted((a,b)->b-a).forEach(System.out::println);
	}
	public void sumAll()
	{
		Integer[] a1 = {2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		System.out.println(Stream.of(a1).mapToInt(Integer::intValue).sum());
	}
	public void averageAll()
	{
		Integer[] a1 = {2,3,4,5,6,7,8,9,9,2,3,4,5,67,5};
		System.out.println(Stream.of(a1).mapToInt(Integer::intValue).sum()/Stream.of(a1).count());
	}
	public void convertIntlistToStringlist()
	{
		List<Integer> al = new  ArrayList<>();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		al.add(50);
		List<String> s1 = al.stream().map(String::valueOf).toList();
		System.out.println(s1.get(0).getClass());
	}
}
class Intermediate{
	public void convertToUpper()
	{
		List<String> s = List.of("hello","dear","near","neo4j");
		
		s.stream().map(String::toUpperCase).forEach(System.out::println);
	}
	public void convertToLower()
	{
		List<String> s = List.of("hELLO","DEARr","REST","PLOICE");
		
		s.stream().map(String::toLowerCase).forEach(System.out::println);
	}
	public void startsWithA()
	{
		List<String> s = List.of("hELLO","DEARr","REST","PLOICE","Allu","allu","Akash","bAA");
		s.stream().filter(a->a.charAt(0)=='A').forEach(System.out::println);
	}
	public void endsWithN()
	{
		List<String> s = List.of("hELLn","DEARN","RESTN","PLOICE","AllN","allu","Akash","bAA");
		s.stream().filter(a->a.charAt(a.length()-1)=='N').forEach(System.out::println);
	}
	public void lengthGreaterThan5()
	{
		List<String> s = List.of("hELLn","DEARaN","REaaaSTN","PaLOICE","AllN","allu","Akash","bAA");
		s.stream().filter(a->a.length()>5).forEach(System.out::println);
	}
	public void sortByLength()
	{
		List<String> s = List.of("hELLn","DEARaN","REaaaSTN","PaLOICE","AllN","allu","Akash","bAA","ria","om");
		s.stream().sorted((a,b)->a.length()-b.length()).forEach(System.out::println);
	}
	public void removeDuplicateStrings()
	{
		List<String> s = List.of("hELLn","allu","allu","bAA","bAA","ria","ria");
		s.stream().distinct().forEach(System.out::println);
	}
	public void findLongestString()
	{
		List<String> s = List.of("hELLn","allu","allu","bAA","bAA","ria","ria");
		System.out.println(s.stream().max((a,b)->a.length()-b.length()).orElse("stream is empty"));
	}
	public void countTotalString()
	{
		List<String> s = List.of("hELLn","allu","allu","bAA","bAA","ria","ria");
		System.out.println(s.stream().count());
	}
	public void findShortestString()
	{List<String> s = List.of("hELLn","allu","allu","bAA","bAA","ria","ria");
		System.out.println(s.stream().min((a,b)->a.length()-b.length()).orElse("stream is empty"));
	}
	public void joinUsingComma()
	{
		List<String> s = List.of("hELLn","allu","allu","bAA","bAA","ria","ria");
		String ans = s.stream().collect(Collectors.joining(","));
		System.out.println(ans);
	}
	public void countVowels()
	{
		String s = "aabviahofniascpoklhfias";
		long l = s.chars().mapToObj(c->(char)c).filter(c->"aeiouAEIOU".indexOf(c)!=-1).count();
		System.out.println();
	}
	public void reverseEveryString()
	{
		List<String> s = List.of("hELLn","allu","allu","bAA","bAA","ria","ria");
		s.stream().map(str->new StringBuilder(str).reverse().toString()).forEach(System.out::println);
	}
	public void findPalindromeString()
	{
		List<String> s = List.of("hELLn","allu","allu","bAb","bAA","ria","riair");
		s.stream().filter(str->new StringBuilder(str).reverse().toString().equals(str)).forEach(System.out::println);
	}
	public void findUniqueChars()
	{
		String s = "absbabbasbabjkbcv";
		String uniqueChars = s.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
		System.out.println(uniqueChars);

	}
}
class Employee{
	int id;
    String name;
    String department;
    double salary;
    int age;
	public Employee(int id,String name,String dept,double sal,int age){
		this.id = id;
		this.name = name;
		this.department = dept;
		this.salary = sal;
		this.age = age;
	}
	public String toString()
	{
		return id+" "+name+" "+department+" "+salary+" "+age;
	}
	public Employee()
	{}
	public void employeeSalGreaterThan5000(){
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",90.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",9000.9999,22));
		e1.add(new Employee(103,"mohan","Python",90000.9999,87));
		e1.add(new Employee(104,"raju","O.S",8989.9999,45));
		e1.add(new Employee(105,"pari","BDE",55687.9999,29));
		
		e1.stream().filter(e->e.salary>5000).forEach(System.out::println);
	}
	
	public void sortBySal()
	{
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",90.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",9000.9999,22));
		e1.add(new Employee(103,"mohan","Python",90000.9999,87));
		e1.add(new Employee(104,"raju","O.S",8989.9999,45));
		e1.add(new Employee(105,"pari","BDE",55687.9999,29));
		
		e1.stream().sorted((a,b)->(int)(a.salary-b.salary)).forEach(System.out::println);
	}
	
	public void highestSalEmp()
	{
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",90.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",9000.9999,22));
		e1.add(new Employee(103,"mohan","Python",90000.9999,87));
		e1.add(new Employee(104,"raju","O.S",8989.9999,45));
		e1.add(new Employee(105,"pari","BDE",55687.9999,29));
		System.out.println();
		System.out.println(
		e1.stream().max((a,b)->(int)(a.salary-b.salary)).orElse(new Employee()));		
	}
	public double getSalary()
	{
		return salary;
	}
	public void avgSal()
	{
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",90.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",9000.9999,22));
		e1.add(new Employee(103,"mohan","Python",90000.9999,87));
		e1.add(new Employee(104,"raju","O.S",8989.9999,45));
		e1.add(new Employee(105,"pari","BDE",55687.9999,29));
		double avg = e1.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
		System.out.println(avg);
	}
	public void totalSal()
	{
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",90.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",9000.9999,22));
		e1.add(new Employee(103,"mohan","Python",90000.9999,87));
		e1.add(new Employee(104,"raju","O.S",8989.9999,45));
		e1.add(new Employee(105,"pari","BDE",55687.9999,29));
		double total = e1.stream().mapToDouble(Employee::getSalary).sum();
		System.out.println(total);
	}
	
	public void empNameOnly()
	{
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",90.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",9000.9999,22));
		e1.add(new Employee(103,"mohan","Python",90000.9999,87));
		e1.add(new Employee(104,"raju","O.S",8989.9999,45));
		e1.add(new Employee(105,"pari","BDE",55687.9999,29));
		
		List<String> li = e1.stream().map(a->a.name).collect(Collectors.toList());
		System.out.println(li);
	}
	public void countEmp()
	{
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",90.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",9000.9999,22));
		e1.add(new Employee(103,"mohan","Python",90000.9999,87));
		e1.add(new Employee(104,"raju","O.S",8989.9999,45));
		e1.add(new Employee(105,"pari","BDE",55687.9999,29));
		
		System.out.println(e1.stream().count());
	}
	public String getDepartment()
	{
		return department;
	}
	public void grpByDept()
	{
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",90.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",9000.9999,22));
		e1.add(new Employee(103,"mohan","Python",90000.9999,87));
		e1.add(new Employee(104,"raju","JAVA",8989.9999,45));
		e1.add(new Employee(105,"pari","HR",55687.9999,29));
		
		// need
		// Map<String,List<Employee>>
		
		Map<String,List<Employee>> map = e1.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		
		System.out.println(map);
	}
	
	public void partitionEmployeeSalaryGreaterThan50K()
	{
		/*Here initially first we have to know the idea that what type of result we need then only
		we can do something in this case for partitioning we use Map one key is true which follows 
		the condition and another one is false which doesn't follow this condition of partition*/
		// Map<Boolean,List<Integer>> 
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",900000.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",78888.9999,22));
		e1.add(new Employee(103,"mohan","Python",45777.9999,87));
		e1.add(new Employee(104,"raju","JAVA",50000.9999,45));
		e1.add(new Employee(105,"pari","HR",32444.9999,29));
		Map<Boolean,List<Employee>> map = e1.stream().collect(Collectors.partitioningBy(emp->emp.salary>50000));
		System.out.println(map.get(true));
		System.out.println(map.get(false));
		
		
	}
	
	public void findSecondHighestSal()
	{
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",900000.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",78888.9999,22));
		e1.add(new Employee(103,"mohan","Python",45777.9999,87));
		e1.add(new Employee(104,"raju","JAVA",50000.9999,45));
		e1.add(new Employee(105,"pari","HR",32444.9999,29));
		double sal  = e1.stream().map(a->a.salary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0.0);
		double sal1  = e1.stream().map(a->a.salary).distinct().sorted(Comparator.reverseOrder()).skip(1).max((a,b)->(int)(a-b)).orElse(0.0);
		System.out.println(sal);
		System.out.println(sal1);
		
		
	}
	public String getName()
	{
		return name;
	}
	public void duplicateEmployeeName()
	{
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",900000.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",78888.9999,22));
		e1.add(new Employee(103,"mohan","Python",45777.9999,87));
		e1.add(new Employee(106,"mohan","Python",45777.9999,87));
		e1.add(new Employee(104,"raju","JAVA",50000.9999,45));
		e1.add(new Employee(105,"pari","HR",32444.9999,29));
		e1.add(new Employee(107,"pari","HR",32444.9999,29));
		
		List<String> dup = e1.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()))
		.entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(dup);
	}
	public void convertEmpListToListString()
	{
		List<Employee> e1 = new ArrayList();
		e1.add(new Employee(101,"kriti","HR",900000.9999,24));
		e1.add(new Employee(102,"shyam","JAVA",78888.9999,22));
		e1.add(new Employee(103,"mohan","Python",45777.9999,87));
		e1.add(new Employee(106,"mohan","Python",45777.9999,87));
		e1.add(new Employee(104,"raju","JAVA",50000.9999,45));
		e1.add(new Employee(105,"pari","HR",32444.9999,29));
		e1.add(new Employee(107,"pari","HR",32444.9999,29));
		List<String> li = e1.stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(li);
	}
}
class Advanced{
	public Advanced(){}
	
	public void secondLargest()
	{
		List<Integer> li = new ArrayList<>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		li.add(5);
		
		int ans = li.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().orElse(-1);
		System.out.println(ans);
	}
	public void nthLargest(int n)
	{
		List<Integer> li = new ArrayList<>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(3);
		li.add(4);
		li.add(5);
		li.add(5);
		
		int ans = li.stream()
		.distinct()
		.sorted(Comparator.reverseOrder())
		.skip(n-1)
		.findFirst()
		.orElse(-1);
		System.out.println(ans);
	}
	public void freqOfAll()
	{
		List<Integer> li = new ArrayList<>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(3);
		li.add(4);
		li.add(5);
		li.add(5);
		
		Map<Integer,Long> map = li
		.stream().
		collect(Collectors.groupingBy(
		Function.identity(),
		Collectors.counting()
		));
		System.out.println(map);
	}
	
	public void duplicate()
	{
		List<Integer> li = new ArrayList<>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(3);
		li.add(4);
		li.add(5);
		li.add(5);
		
		Set<Integer> uniqueItems = new HashSet<>();
		List<Integer> duplicates = li.stream()
        .filter(n -> !uniqueItems.add(n)) // Keeps 'n' if it already exists in the set
        .distinct()                       // Ensures the output only lists each duplicate once
        .collect(Collectors.toList());
		System.out.println(duplicates);
	}
	
	public void uniqueElements()
	{
		List<Integer> li = new ArrayList<>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(3);
		li.add(4);
		li.add(5);
		li.add(5);
		
		Set<Integer> uniqueItems = new HashSet<>(li);
		System.out.println(uniqueItems);
		//Preserve Order
		Set<Integer> unique = new LinkedHashSet<>(li);
		System.out.println(unique);
		List<Integer> u = li.stream().distinct().collect(Collectors.toList());
		System.out.println(u);
	}
}
class StreamDemoQues
{
	public static void main(String[] args){
		Beginner b = new Beginner();
		// All beginner questions
		
		// 1.print even numbers
		b.evenNumbers();
		// 2.print odd numbers
		b.oddNumbers();
		// 3.print greater than 50 numbers
		b.greaterThanFiftyNumbers();
		// 4.print square of each element
		b.squareEachElement();
		// 5.print cube of each element
		b.cubeEachElement();
		// 6.removing duplicates
		b.removeDuplicateElements();
		// 7.sort in ascending order
		b.sortAsc();
		// 8.sort in descending order
		b.sortDesc();
		// 9.count even
		b.countEven();
		// 10.count odd
		b.countOdd();
		// 11.find max
		b.maxElement();
		// 12.find min
		b.minElement();
		// 13.find first element
		b.findFirst();
		// 14.Find any element
		b.findAny();
		// 15.Skip first five element
		b.skipFirst5();
		// 16.print only 5
		b.startFive();
		// 17.Reverse a list using streams
		b.reverseList();
		// 18.Sum of all numbers
		b.sumAll();
		// 19.Average of numbers 
		b.averageAll();
		// 20.stringlisttointlist
		b.convertIntlistToStringlist();
		
		Intermediate i = new Intermediate();
		// 1.Convert all names to uppercase
		i.convertToUpper();
		// 2.Convert all names to lowercase
		i.convertToLower();
		// 3.String starts with A
		i.startsWithA();
		// 4.Find strings ending with "n".
		i.endsWithN();
		// 5.Find strings having length > 5.
		i.lengthGreaterThan5();
		// 6.Sort strings by length.
		i.sortByLength();
		// 7.Remove duplicate strings.
		i.removeDuplicateStrings();
		// 8.Find longest string.
		i.findLongestString();
		// 9.Count total strings.
		i.countTotalString();
		// 10.Find shortest string.
		i.findShortestString();
		// 11.Join all strings using commas.
		i.joinUsingComma();
		// 12.Count vowels in every string.
		i.countVowels();
		// 13.Reverse every string using map().
		i.reverseEveryString();
		// 14.Find palindrome strings.
		i.findPalindromeString();
		// 15.Find unique characters.
		i.findUniqueChars();
		
		Employee e1 = new Employee();
		// 1.Empl sal greater than 5k
		e1.employeeSalGreaterThan5000();
		// 2.logic same for age almost
		// 3.Sort employees by salary
		e1.sortBySal();
		// 4.Sort employees by age (similar logic as above)
        // 5.Highest salary employee (lowest is also similar logic)
		e1.highestSalEmp();
        // 6.Average salary
		e1.avgSal();
		// 7.total sal expenditure
		e1.totalSal();
		// 8.Employee names only
		e1.empNameOnly();
        // 9.Department names only (similar to above)
		// 10.Count employees
		e1.countEmp();
		// 11.Group employees by department ⭐⭐⭐⭐⭐
		e1.grpByDept();
        // 12.Partition employees salary >50000 ⭐⭐⭐⭐
		e1.partitionEmployeeSalaryGreaterThan50K();
        // 13.Find second highest salary ⭐⭐⭐⭐⭐
		e1.findSecondHighestSal();
        // 14.Find youngest employee (very simple idea just sort on basis of age and get using max or min)
        // 15.Find oldest employee
        // 16.Find duplicate employee names
		e1.duplicateEmployeeName();
        // 17.Convert List<Employee> → List<String>
		e1.convertEmpListToListString();
		
		//Advanced Questions
		Advanced ad = new Advanced();
		// 1.Second Largest Number ⭐⭐⭐⭐⭐
		ad.secondLargest();
        // 2.Second Smallest Number (same only change the sorting order)
		// 3.Nth Largest Number
		ad.nthLargest(1);
		ad.nthLargest(2);
		ad.nthLargest(3);
		ad.nthLargest(4);
		// 4.Frequency of every element ⭐⭐⭐⭐⭐
		ad.freqOfAll();
		// 5.Duplicate Elements ⭐⭐⭐⭐⭐
		ad.duplicate();
        // 6.Unique Elements
		ad.uniqueElements();
		/*
Missing Number
Sum of Digits
Largest Digit
Prime Numbers
Perfect Numbers
Armstrong Numbers
Fibonacci using Streams
Factorial
Merge two Lists
Common Elements of two Lists ⭐⭐⭐⭐⭐
Union of Lists
Intersection of Lists
Remove Null Values
Remove Negative Numbers
		*/
	}
}