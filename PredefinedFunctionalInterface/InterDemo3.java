//Ex.1 Working of isEqual() method
/* import java.util.function.Predicate;
class InterDemo3
{
	public static void main(String[]args)
	{
		Predicate<String> p = Predicate.isEqual("ram");
		System.out.println(p.test("ram")); //true 
		System.out.println(p.test("sita")); //false 
	}
}
 */
 
 // Ex.2 Working of negate() method
/* import java.util.function.Predicate;
class InterDemo3
{
	public static void main(String[]args)
	{
		int[] x={10,5,15,2,1,10,21,30,51,40};
		Predicate<Integer> p1=(a)->a>20;
		show(p1.negate(),x); 
	}
	public static void show(Predicate<Integer> p1,int[] x)
	{
		for(int i:x){
			if(p1.test(i))
				System.out.println(i);
		}
	}
}
 */

 // Ex.3 Working of or() method
/* import java.util.function.Predicate;
class InterDemo3
{
	public static void main(String[]args)
	{
		int[] x={10,5,15,2,1,10,21,30,51,40};
		Predicate<Integer> p1=(a)->a>20;
		Predicate<Integer> p2=(a)->a<40;
		show(p1.or(p2),x); 
	}
	public static void show(Predicate<Integer> p1,int[] x)
	{
		for(int i:x){
			if(p1.test(i))
				System.out.println(i);
		}
	}
} */

/*
NOTE: 
return type of isEqual() is Predicate
return type of test() is boolean
*/

/*
# Profile of Predicate.java in java 1.8

public interface java.util.function.Predicate<T>{
	
	public abstract boolean test(T);
	public default java.util.function.Predicate<T> and(java.util.function.Predicate<T>);
	public default java.util.function.Predicate<T> negate();
	public default java.util.function.Predicate<T> or(java.util.function.Predicate<T>);
	public static java.util.function.Predicate<T> isEqual(java.lang.Object);
	
}

*/

// Internal Working of isEqual() through Lambda
/* import java.util.function.Predicate;
interface Inter1
{
	boolean test(String s);
	static Inter1 isEqual(String s)
	{
		return s1->s.equals(s1);
		//This line is internally returning Inter1 (Predicate) becoz of lambda Expression
	}
}
class InterDemo3
{
	public static void main(String[]args)
	{
		Inter1 p= Inter1.isEqual("ram");
		System.out.println(p.test("ram")); //true
		System.out.println(p.test("ab"));  // false
		System.out.println(p.getClass().getName()); //Inter1$$Lambda/HexaDecimalNo.
	}
} */



// Internal Working of isEqual() in easy through anonymous inner class 
/* import java.util.function.Predicate;
interface Inter1
{
	boolean test(String s);
	static Inter1 isEqual(String s)
	{
		Inter1 i=new Inter1(){
			public boolean test(String s1)
			{
				return s1.equals(s);
			}
		};
		return i;
	}
}
class InterDemo3
{
	public static void main(String[]args)
	{
		Inter1 p = Inter1.isEqual("ram");
		System.out.println(p.test("ram")); //true
		System.out.println(p.test("ab"));  // false
		System.out.println(p.getClass().getName()); //Inter1$1
	}
} */


// import java.util.function.Predicate;
interface Inter1
{
	boolean test(String s);
	static Inter1 isEqual(String s)
	{
		Inter1 i = (s1) -> s.equals(s1);
		return i;
	}
}
class InterDemo3
{
	public static void main(String[]args)
	{
		Inter1 p = Inter1.isEqual("ram");
		System.out.println(p.test("ram")); //true
		System.out.println(p.test("ab"));  // false
		System.out.println(p.getClass().getName()); //Inter1$$Lambda/HexaDecimalNo.
	}
}

/*
Note: Java ke andar ham method ke andar method nhi bana skte he but lambda ki help se ham ek 
method ke andar abstract method ko define kar skte he Exaple Above Code

# Annotation:

@FunctionalInterface
	interface Inter1{
		
	}
	error:unexpected @FunctionalInterface annotation Inter1 is not a functional interface
	no abstract method found in interface Inter1

@FunctionalInterface
	interface Inter1{
		void show();
	}
	will work
	
@FunctionalInterface
	interface Inter1{
		void show1();
		void show2();
	}
	error:unexpected @FunctianlInterface annotation
	Inter1 is not a Functional interface multiple non-overriding abstract methods found in interface
	Inter1
	
@FunctionalInterface
	interface Inter1{
		void show1();
		default void show2();
	}
	error:missing method body or declare abstract 
	default void show()

@FunctionalInterface
	interface Inter1{
		void show1();
		default void show2(){}
		default void show3(){}
		static void show3(){}
	}
    will work properly
	
@FunctionalInterface
	interface Inter1{
		void show1();
	}
	interface Inter2 extends Inter1
	{
		void show2();
	}
    will work properly
	
	Note:- yaha par @FunctionalInterface annotations ka use hua hai our interface Inter1 ke pass ek
	hi abstract method hai tohh program run ho jayega.
	
@FunctionalInterface
   interface Inter1
   {
	   void show();      yaha par ek hi abstract method he 
   }
@FunctionalInterface
   interface Inter2 extends Inter1
   {
	   void show2();      yaha par 2 he isisliye error 
   }
   error: unexpected @FunctionalInterface annotation 
   Inter2 is not a functional interface multiple non overriding methods found in Inter2  
*/