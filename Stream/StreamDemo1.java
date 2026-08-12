/*
Stream
-------------------------
Que:1. Collection vs Stream:-
Collection :-If we want to represent a group of individual objects as a single entity then we 
should go for collection.
Stream :-If we want to process objects from the collection.


Que:2. Want to get the Stream Which method to use ?
Stream s = c.stream(); (on collection if we are calling stream method it will give stream object)
Stream is an interface present inside java.util.stream package 
*/
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
class StreamDemo1
{
	public static void main(String[] args){
		ArrayList<Integer> al = new ArrayList<>();
		al.add(12);
		al.add(13);
		al.add(1);
		al.add(5);
		al.add(6);
		al.add(68);
		al.add(90);
		al.add(97);
		al.add(56);
		 /*
		 Que 3: If we want to filter out only even from this list how we can?
		 Steps :-
		 by using filter method
		 1. First get the stream now by using that Stream we can process that objects
		 al.stream().filter(condition(means predicate boolean we have to give))
		 al.stream().filter(i->i%2==0)
		 now once we configured the filter collect the elements 
		 al.stream().filter(i->i%2==0).collect()
		 collect the element in the list 
		 al.stream().filter(i->i%2==0).collect(Collectors.toList())
		 now store this 
		 List<Integer> l2 = al.stream().filter(i->i%2==0).collect(Collectors.toList());
		 */
		 List<Integer> l2 = al.stream().filter(i->i%2==0).collect(Collectors.toList());
		 System.out.println(l2);
		 
		 /*
		 Que 4: How can we do mapping 
		 Requirement : for every student can we add 5 gracemarks 
		 */
		 ArrayList<Integer> marks = new ArrayList<>();
		 marks.add(9);
		 marks.add(56);
		 marks.add(78);
		 marks.add(99);
		 marks.add(45);
		 marks.add(32);
		 marks.add(63);
		 marks.add(32);
		 List<Integer> updatedMarks = marks.stream().map(i->i+5).collect(Collectors.toList());
		 System.out.println(updatedMarks);
		 
		 /*
		 Note: If we want to do some operation and generate a new object then go for map
		 method this is called mapping.
		 Note: Assume in java 8 stream concept is not there then code length increases i.e 
		 approx 8-10 line code for that 
		 Note: Where we going to use this streams concept : Everywhere we are going to use wherever
		 there is collections concept is there stream concept is applicable by default ex: store group of 
		 customers object or student or records coming from databases
		 Task suppose i want to filter only bsnl numbers then we should filter it from collection using
		 stream or airtel stream like this type of case if it is simple sms based application 
		 Java 8 funda => all features to reduce code number of lines 
		 */
		 
		 /*
		 1. filter(Predicate(boolean valued(to perform conditional checks go for this)))
		 2. map(Function(it can return any type of value(to perform some operation go for thiss)))
		 */
		 
		 
		 /*Method used upto now :-
		 1. stream() 2. filter() 3. map() 4. collect() 5. count()
		 */
		 
		 /*
		 count() this method tells how many elements in our stream
		 It tells or work to count how many objects in the processed collection 
		 return long value
		 */
		 
		 long noOfFailedStudents = marks.stream().filter(i->i<33).count();
		 System.out.println(noOfFailedStudents);
		 
		 /*
		 sorted() Method use to get sorted databases		 
		 */		 
		 List<Integer> studentSorted = marks.stream().sorted().collect(Collectors.toList());
		 System.out.println(studentSorted); // default natural sorting order
		 
		 // To get custom sorting order or descending then go for Comparator 
		 // contains compare method compare(obj1,obj2)
		 /*Ex 10,20 (i1,i2) -> (i1<i2)?1:(i1>i2)?-1:0;
		 */
		 
		 /*
		 sorted() => Default Natural Sorting Order (internally it uses Comparable compareTo method)
		 sorted(Comparator) => Customized Sorting order 
		 */
		 
		 List<Integer> studentSortedDesc = marks.stream().sorted((i1,i2) -> (i1<i2)?1:(i1>i2)?-1:0).collect(Collectors.toList());
		 System.out.println(studentSortedDesc); // default natural sorting order
		 
		 
		 ArrayList<String> al1 = new ArrayList<>();
		 al1.add("sunny");
		 al1.add("shraddha");
		 al1.add("kirti");
		 al1.add("rashmika");
		 al1.add("pornima");
		 al1.add("raja keshav badri");
		 al1.add("namay pokli");
		 al1.add("redy hiro hariom");
		 List<String> heroinesDesc = al1.stream().sorted((i1,i2) -> i2.compareTo(i1) ).collect(Collectors.toList());
		 List<String> heroinesLen = al1.stream().sorted((i1,i2) -> {
			 int l1 = i1.length();
			 int len2 = i2.length();
			 return len2-l1;
		 } ).collect(Collectors.toList());
		 System.out.println(heroinesDesc); // default natural sorting order
		 System.out.println(heroinesLen); // default natural sorting order
		 // 1:20 completed
		 
		 /*
		 min() , max()
		 min and max defined based on sorting for ex:-
		 1. 5, 10, 15, 30, 50 = min =5, max = 50 Ascending order |(first ele mn andd last el is max
		 2. 50, 30, 15, 10, 5 = min =50, max = 5 Descending order| in both)
		 Compulsory we have to talk about sorting for finding this min or max so for that 
		 we have to pass comparator 
		 */
		 
		 ArrayList<Integer> al2= new ArrayList<>();
		 al2.add(10);
		 al2.add(0);
		 al2.add(15);
		 al2.add(25);
		 al2.add(5);
		 al2.add(20);
		 System.out.println(al2);
		 
		 Integer minVal1 = al2.stream().min((i1,i2)->i1.compareTo(i2)).get(); // Default natural sorting it means ascending 
		 System.out.println(minVal1);
		 Integer maxVal1 = al2.stream().max((i1,i2)->i1.compareTo(i2)).get(); // Default natural sorting it means ascending 
		 System.out.println(maxVal1);
		 
		 //Changing the DFNSO by applying minus
		 Integer minVal2 = al2.stream().min((i1,i2)->-i1.compareTo(i2)).get();  
		 System.out.println(minVal2);
		 Integer maxVal2 = al2.stream().max((i1,i2)->-i1.compareTo(i2)).get(); 
		 System.out.println(maxVal2);
		 
		 /*
		 Suppose i want to process each element present inside the stream want to print like that
		 Ex: for(Integer i : al2){System.out.println(i);}
		 use forEach method to apply or use this type of use case
		 al2.stream().forEach(Consumer)
		 that means dont go for messy stuuf such like iterators 
		 
		 Steps:
		 1.We can pass Consumer |Funcional interface 
		 2.It means we can pass lambda expression the method inside this is accept method
		 take argument return type void
		 3.Here we pass Method refernce 
		 al2.stream().forEach(System.out::println)
		 */
		 al2.stream().forEach(System.out::println);
		 Consumer<Integer> c = (a) -> System.out.println("Square is : "+ a*a);
		 al2.stream().forEach(c);
		 
		 
		 
		 /*
		 To convert stream of objects into array
		 toArray() method we can use 	
		Integer[] i =  al2.stream().toArray(Integer[]::new);
		Consturcutor refernce is working convert to this array
two methods for this purpose one is non argument which returns object type array
another take IntFunction functional interface as argument 		
		 */
		 
		Integer[] i =  al2.stream().toArray(Integer[]::new);
		for(Integer i1 : i)System.out.println(i1);
		/*
		How can we get Stream of array
		Stream.of(i) here we got the stream 
		
		Stream.of(i).forEach(System.out::println);
		*/
		Stream.of(i).forEach(System.out::println);
		
		// Note in very small line we converted list to array and then array to stream 
		
		
		/*
		Method learnt upto now :-
		stream()
		filter()
		collect()
		map()
		count()
		sorted()
		sorted(Comparator)
		min(Comparator)
		max(Comparator)
		forEach()
		toArray()
		-----------------------
		Stream.of()
		-----------------------
		Wherever group of values are there then happily we can go for Streams concept 
		or Arrays are there 
		Dont feel stream only applicable for Collection only
		Very easy terms everything 
		*/
		
		Stream<Integer> s = Stream.of(9,99,999,9999,99999);
		// 5 elements represented by Stream
		s.forEach(System.out::println);
		
		Integer[] arr = {10,20,304,50,60};
		Stream.of(arr).forEach(System.out::println);
	}
}