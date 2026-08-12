/*
Lecture 1:

Note:

1. Java 8 se interface ka bahut acha concept aya he (Most Important Java 8) 
2. Sum of two numbers using lambda expression.
3. Comparable and Comparator (Most Imp.)
4. Difference between ArrayList and LinkedList (MIMP)
5. Real World Examples of everything you should know ?
6. Lambda Expression Most Important

*/

// Lambda Expression Sum Of Two Numbers

/*
interface Inter1{
	int sum(int a,int b); // Check we can use it or not => we can't use it
    // Single Abstract Method or Functional Interface	
} 
class InterDemo1
{
	public static void main(String[] args)
	{
		Inter1 i = (x,y) -> x+y;
		System.out.println(i.sum(10,20));
	}
}
*/

/* Concept Of JAVA 1.8 Predicate

1. Predicate predefined functional interface hai.
2. import java.util.function.Predicate; is package par rkha hua he 
3. Iske andar jo abstract method rkha he uska name test() hai or iska return type boolean hai.

import java.util.function.Predicate;
class InterDemo1
{
	public static void main(String[] args)
	{
		Predicate<Integer> p = a -> a>=18;
		System.out.println(p.test(10));
		System.out.println(p.test(20));
	}
}
*/

/* Examples and Points :- 
1. we cannot create object of interface but we can make reference variable of interface.
2. In interface method java compiler by default add 2 keyword abstract and public. 
*/


/*
interface Inter1
{
	void show(); //Functional Interface
}
class A implements Inter1 
{
	public void show()
	{
		System.out.println("Class A");
	}
}
class InterDemo1
{
	public static void main(String[] args)
	{
		// Inter1 i= new A(); // Op:- Class A
		
		// Inter1 i= new Inter1(); // Op:- Inter1 is abstract can not be instantiated
		
		// Inter1 i= new Inter1(){}; 
		//error: <anonymous InterDemo1$1> is not abstract and 
		//does not override abstract method show() in Inter1
		
		// Anonymous Inner Class 
		Inter1 i= new Inter1(){
			public void show()
			{
				System.out.println("Anonymous inner class");
			}
		}; // Op:- Anonymous Inner Class
		i.show();
		
		Inter1 i2=()->{System.out.println("Using Lambda Expression Anonymous Inner Class method override");};
		i2.show();
		
		Inter1 i3=()->System.out.println("Without Bracketr only single Statement ");
		i3.show();
	}
}
*/

interface Inter1
{
	void show(int x);
}
class InterDemo1
{
	public static void main(String []args)
	{
		Inter1 i=(a)->System.out.println("a="+a);
		i.show(10);
		i.show(100);
		i.show(1000);
	}
}