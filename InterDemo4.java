// Return Value According to the return type set by the user
/* @FunctionalInterface
interface Inter1<T,R>
{
	R   apply(T t);
}
public class InterDemo4
{
	public static void main(String [] args)
	{
		Inter1 <String,Integer> i = (a) -> a.length();
		System.out.println(i.apply("ram"));
		System.out.println(i.apply("sita"));
	}
} */



// Functional Interface Function
/* import java.util.function.Function;

public class InterDemo4
{
	public static void main(String [] args)
	{
		Function<String, Integer> i = a->a.length();
		System.out.println(i.apply("ram"));
		System.out.println(i.apply("abcdef"));
	}
} */

/*  
1.Function Interface is a Functional Interface.
2.We can define the return type and parameter of the method , it's both
type are generic type 
3.It has a abstract method apply() it's return type is also generic
*/

/* import java.util.function.Function;

public class InterDemo4
{
	public static void main(String [] args)
	{
		Function<Integer, Integer> i = a->a*a;
		System.out.println(i.apply(10));
		System.out.println(i.apply(20));
	}
} */


/*
return type of and method is Predicate and paramter is also predicate
import java.util.function.Predicate;

public class InterDemo4
{
	public static void main(String [] args)
	{
		int[] x = {10,5,15,2,1,10,20,21,30,51,80,40};
		Predicate<Integer > p1 = a->a%4==0;
		Predicate<Integer > p2 = a->a%5==0;
		Predicate<Integer > p3 = p1.and(p2);
		for(int i:x)
		{
			if(p3.test(i))System.out.println(i);
		}
	}
}

Same Program User Defined
interface Inter1
{
	boolean test(int x);
	default Inter1 and(Inter1 a)
	{
		return b->test(b) && a.test(b);
	}
}
public class InterDemo4
{
	public static void main(String [] args)
	{
		int[] x = {10,5,15,2,1,10,20,21,30,51,80,40};
		Inter1 i1 = a->a%4==0;
		Inter1 i2 = a->a%5==0;
		Inter1 i3= i1.and(i2);
		for(int i:x)
		{
			if(i3.test(i))System.out.println(i);
		}
	}
}
*/

/*

or method code manually :-
interface Inter1
{
	boolean test(int x);
	default Inter1 or(Inter1 a)
	{
		return b->test(b) || a.test(b);
	}
}
public class InterDemo4
{
	public static void main(String [] args)
	{
		int[] x = {10,5,15,2,1,10,20,21,30,51,80,40};
		Inter1 i1 = a->a%4==0;
		Inter1 i2 = a->a%5==0;
		Inter1 i3= i1.or(i2);
		for(int i:x)
		{
			if(i3.test(i))System.out.println(i);
		}
	}
}
*/

/*

working of all method code manually :-
interface Inter1
{
	boolean test(int x);
	default Inter1 and(Inter1 a)
	{
		return b->test(b) && a.test(b);
	}
	default Inter1 or(Inter1 a)
	{
		return b->test(b) || a.test(b);
	}
	default Inter1 negate()
	{
		return a->!test(a);
	}
}
public class InterDemo4
{
	public static void main(String [] args)
	{
		int[] x = {10,5,15,2,1,10,20,21,30,51,80,40};
		Inter1 i1 = a->a%4==0;
		Inter1 i2 = i1.negate();
		for(int i:x)
		{
			if(i2.test(i))System.out.println(i);
		}
	}
}
*/


// We have to print only words which ends with a
/*
import java.util.function.*;
public class InterDemo4
{
	public static void main(String [] args)
	{
		// String[] s = {"ram","abc","aabc","sita","gita","aaa","abhi","raa"};
		// String[] s = {"ram","abc",null,"aabc","sita","gita","aaa","abhi","raa"};
		// NullPointerException in above example why because operation on null can't performed
		Predicate<String> p = (x)->x.endsWith("a");
		
		// Removing NPE
		Predicate<String> p = (x)->x!=null && x.endsWith("a");
		for(String s1 : s){
			if(p.test(s1)){
				System.out.println(s1);
			}
		}
	}
}
*/

// printing employees whose salary greater than 20000 and lives in indore 
/* import java.util.function.Predicate;
class Employee{
	int id;
	String name;
	double sal;
	String add;
	Employee(int id,String name,double sal,String add)
	{
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.add = add;
	}
	public String toString()
	{
		return "id = " + id + ", name = " + name + ", sal = " + sal + ", add =" + add ;
	}
}
class InterDemo4{
	public static void main(String[]args){
		Employee[] e = {new Employee(1,"ramu",2000.00,"indore"),new Employee(2,"prem",20000.00,"indore"),new Employee(3,"love",789999.00,"mumbai"),new Employee(4,"keshav",20000.00,"bhopal")};
		Predicate<Employee> p1 = a -> a.add.equals("indore");
		Predicate<Employee> p2 = a -> a.sal>=20000;
		
		for(Employee e1 : e)
		{
			if(p1.and(p2).test(e1)){
				System.out.println(e1);
			}
		}
	}
} */


/*
addThen Example
import java.util.function.Function;
class InterDemo4{
	public static void main(String[] args){
		Function<Integer,Integer> f1 = a -> a+a;
		Function<Integer,Integer> f2 = a -> a*a;
		Function<Integer,Integer> f3 = a -> a*4;
		System.out.println(f1.apply(10)); // 20
		System.out.println(f2.apply(10)); // 100
		System.out.println(f1.addThen(f2).apply(10)); // 400
		System.out.println(f2.addThen(f1).apply(10)); // 200
		System.out.println(f1.compose(f2).apply(10)); // 200
		System.out.println(f2.compose(f1).apply(10)); // 400
		System.out.println(f1.addThen(f2).compose(f3).apply(10)); // 6400
		System.out.println(f1.compose(f2).addThen(f3),apply(10)); // 800
		
		Function<Integer,Integer> f4 = Function.identity();
		System.out.println(f4.apply(10)); // 10 what u will give u get back
	}
}
*/

/*
NOTE :- 
1. f1.addThen(f2) => first applies f1 then f2 on result
2. f1.compose(f2) => applies f2 first and then f1
*/

/*
Profile of Function interface

public interface java.util.function.Function<T, R> {
  public abstract R apply(T);
  public default <V> java.util.function.Function<V, R> compose(java.util.function.Function<? super V, ? extends T>);
  public default <V> java.util.function.Function<T, V> andThen(java.util.function.Function<? super R, ? extends V>);
  public static <T> java.util.function.Function<T, T> identity();
}

*/