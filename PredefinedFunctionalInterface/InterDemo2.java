/*Ex 1.
interface Inter1
{
	int show(int x,int y);
}
class InterDemo2
{
	public static void main(String[]args)
	{
		Inter1 i=(x,y)->{return x+y;};
		System.out.println(i.show(10,20));
		System.out.println(i.show(110,220));
	}
}
*/

/* Ex 2.
interface Inter1
{
	int show(int x,int y);
}
class InterDemo2
{
	public static void main(String[]args)
	{
		// Inter1 i=(x,y)->return x+y; //give error illegal start of expression
		
		//Agr Single statement hai lambda expression ke andar to esa return use nhi kran skte
		//kyki vo automatic hi return kar deta hai.
		
		Inter1 i=(x,y)->x+y;
		System.out.println(i.show(10,20));
		System.out.println(i.show(110,220));
	}
}
*/


/*  Ex 3.
interface Inter1
{
	void show(int x);
}
class InterDemo2
{
	public static void main(String[]args)
	{
		Inter1 i=(x) -> System.out.println(x) ;
		i.show(10);
		i.show("ram");
		// Error above : incompatible types:String cannot be converted to int
	}
}
 */
 
 
/*  // Ex 4.
interface Inter1 <T>
{
	void show(T x);
}
class InterDemo2
{
	public static void main(String[]args)
	{
		Inter1 i=(x) -> System.out.println(x) ;
		i.show(10);
		i.show("ram");
	}
}
*/
 
/* // Ex 5.
interface Inter1 <T>
{
	boolean show(T x); 
	
	//yahya above par particular kuch d.T specify nhi kara to byDefault raw(Object) type hi hoga
	//or object me realtional operator use nhi kar skte he 
	
}
class InterDemo2
{
	public static void main(String[]args)
	{
		Inter1 i=(x) -> x>18 ;  //Error ayega yaha par
		//error: bad operand types for binary operator '>'
		System.out.println(i.show(10));
	}
} 
*/

/*  // Ex 6.
interface Inter1 <T>
{
	boolean show(T x); 
}
class InterDemo2
{
	public static void main(String[]args)
	{
		Inter1<Integer> i = (x) -> x>18 ;  
		System.out.println(i.show(10));
		System.out.println(i.show(20));
		
		//He to Object hi lekin autoboxing or autounboxing use horha he yah par jab comparison hoga
		//Integer par 
	}
}  */

// IMP_NOTE:- Lambda Expression ka use sirf Functional Interface me hi kar skte he.


/* Ex.7 
interface Inter1 <T>
{
	boolean show(T x);
	void show2(int x,int y);
}
class InterDemo2
{
	public static void main(String[]args)
	{
		Inter1<Integer> i = (x) -> x>18 ;  
		Inter1<Integer> i2 = (x) -> x>18 ;  
		
		2 errors same 
		incompatible types: Inter1 is not a functional interface
		multiple non-overriding abstract methods found in interface Inter1
		System.out.println(i.show(10));
		System.out.println(i.show(20));
		 LAmda expression par ek hi abstract method ko use kar skte hai.
	}
}  */


//Ex.8
/* import java.util.function.Predicate;
class InterDemo2
{
	public static void main(String []args)
	{
		Predicate<Integer> i=(x) -> x>18;
		System.out.println(i.test(10));
		System.out.println(i.test(20));
	}
} */


//Ex.9  Display Even No.
/* import java.util.function.Predicate;
class InterDemo2
{
	public static void main(String []args)
	{
		int x[]={10,5,15,2,1,10,21,30,51,40};
		Predicate<Integer> p=(a) -> a%2==0;
		for(int i:x)
		if(p.test(i))System.out.println(i);
	}
}
 */
 

//Ex.10  Predicate to find number is PRime or not .
/* import java.util.function.Predicate;
class InterDemo2
{
	public static void main(String []args)
	{
		Predicate<Integer> p=(n) -> {
			int s=0;
			int a;
			int n1=n;
			while(n!=0)
			{
				a=n%10;
				s=s*10+a;
				n/=10;
			}
			return s==n1;
		};
		System.out.println(p.test(121));
		System.out.println(p.test(12));
		System.out.println(p.test(13431));
	}
} */

 
//Ex.11 How to pass predicate in function and Print even numbers  
/* import java.util.function.Predicate;
class InterDemo2
{
	public static void main(String []args)
	{
		int x[]={10,5,15,2,1,10,21,30,51,40};
		Predicate<Integer> p = (a) -> a%2==0;
		show(p,x);
	}
	static void show(Predicate<Integer> p,int[] x)
	{
		for(int i:x)
		{
			if(p.test(i))
			{
				System.out.println(i);
			}
		}
	}
}  */

// Ex.12 No. Greater Than 20 and less than 50 using Predicate
/* import java.util.function.Predicate;
class InterDemo2
{
	public static void main(String []args)
	{
		int x[]={10,5,15,2,1,10,21,30,51,40};
		Predicate<Integer> p1 = (a) -> a>20;
		Predicate<Integer> p2 = (a) -> a<50;
		show(p1.and(p2),x);  // and() method of Predicate Interface
	}
	static void show(Predicate<Integer> p,int[] x)
	{
		for(int i:x)
		{
			if(p.test(i))
			{
				System.out.println(i); // OP-> 21,30,40
			}
		}
	}
} */

//Ex.13 Prime Number :- Number which is only divisible only 1 time other than 1.
// Prime Number Through Predicate 
/* import java.util.function.Predicate;
class InterDemo2
{
	public static void main(String []args)
	{
		Predicate<Integer> p1= (n) -> {
			int c=0;
			for(int i=1;i<=n;i++)
			{
				if(n%i==0)c++;
			}
			return c==2;
		};
		show(p1);
	}
	static void show(Predicate<Integer> p1)
	{
		System.out.println(p1.test(1));
		System.out.println(p1.test(11));
		System.out.println(p1.test(13));
		System.out.println(p1.test(12));
	}
} */


//Ex.14 Prime Number :- Number which is only divisible only 1 time other than 1.
// Prime Number Series Through Predicate 
/* import java.util.function.Predicate;
class InterDemo2
{
	public static void main(String []args)
	{
		Predicate<Integer> p1= (n) -> {
			int c=0;
			for(int i=1;i<=n;i++)
			{
				if(n%i==0)c++;
			}
			return c==2;
		};
		show(p1);
	}
	static void show(Predicate<Integer> p1)
	{
		for(int i=1000;i<=1500;i++)
		{
			if(p1.test(i))
			{
				System.out.println(i);
			}
		}
	}
} */

//Ex.15 Prime && Palindrome Series Through Predicate 
/* import java.util.function.Predicate;
class InterDemo2
{
	public static void main(String []args)
	{
		Predicate<Integer> p1= (n) -> {
			int c=0;
			for(int i=1;i<=n;i++)
			{
				if(n%i==0)c++;
			}
			return c==2;
		};
		Predicate<Integer> p2= (n)-> {
			int n1=n;
			int a;
			int s=0;
			while(n!=0)
			{
				a=n%10;
				s=s*10+a;
				n/=10;
			}
			return n1==s;
		};
		show(p1.and(p2));
	}
	static void show(Predicate<Integer> p1)
	{
		for(int i=100;i<=1000;i++)
		{
			if(p1.test(i))
			{
				System.out.println(i);
			}
		}
	}
}
 */

/* Note:- Functional Interface me single abstract method hoti he lekin multiple default and static
method ho skti he . */

/*Task:- 
1. Series of Prime or Palindrome
2. Series of neither Prime nor Palindrome
*/

// Task1:
/* import java.util.function.Predicate;
class InterDemo2
{
	public static void main(String[]args)
	{
		Predicate<Integer> p1= (n) -> {
			int c=0;
			for(int i=1;i<=n;i++)
			{
				if(n%i==0)c++;
			}
			return c==2;
		};
		Predicate<Integer> p2= (n) -> {
			int n1=n;
			int s=0;
			int a=0;
			while(n!=0)
			{
				a=n%10;
				s=s*10+a;
				n/=10;
			}
			return n1==s;
		};
		show(p1.or(p2));
	}
	static void show(Predicate<Integer> p)
	{
		for(int i=100;i<1000;i++)
		{
			if(p.test(i))
			{
				System.out.println(i);
			}
		}
	}
}
 */
 
 // Task2:
import java.util.function.Predicate;
class InterDemo2
{
	public static void main(String[]args)
	{
		Predicate<Integer> p1= (n) -> {
			int c=0;
			for(int i=1;i<=n;i++)
			{
				if(n%i==0)c++;
			}
			return c==2;
		};
		Predicate<Integer> p2= (n) -> {
			int n1=n;
			int s=0;
			int a=0;
			while(n!=0)
			{
				a=n%10;
				s=s*10+a;
				n/=10;
			}
			return n1==s;
		};
		show(p1.or(p2).negate());
	}
	static void show(Predicate<Integer> p)
	{
		for(int i=100;i<1000;i++)
		{
			if(p.test(i))
			{
				System.out.println(i);
			}
		}
	}
}

//Questions From Above Topics:--
/*
1. Question: Predicate is of which type if Interface?
Ans:- Predicate is a Predefined functional interface.

2. Question: Which abstract method is inside the Predicate?
Ans:- Test().

3. Question: Return type of test method?
Ans:- Boolean.

4. Question: What is lambda Expression in java?
Ans:- . A lambda Expression in java is a short block of code that takes parameters and return a value.
It is essentially a anonymous function ( a function without name ) that can be used to provide the 
implementation of a method defined by functional interface.
. Lambda Expression was introduced in java 8 to enable functional Programming & make code more concise
especially when working with collections and streams.

(paramters) -> expression; 
(paramters) -> {statements;};
parameters => Input to the lambda Expression
Arrows => separated parameters from the body 
expression / block => the action to perform 

5. Question: Can we Make Object of Interface?
Ans:- No we can't create Object of interface.

6. Question: Can we Make R.V of Interface?
Ans:- Yes we can Make R.V of interface.

7. Question: Difference between lambda expression and anonymous inner class?
Ans:- Lambda Expression                 |                Anonymous Inner Class
   1. a Lambda is essentially a function           1. It is a class wihtout a name that provides
    without a name (java 8 introduce)              implementation for a interface or extends a class.
   2. Only works with functional interface         2. CAn implements any interface with multiple 
                                                   methods or extends a classw
   3. Does not create a separate class file        3. Creates an extra class at runtime(synthetic class)
   at runtime treated as function

8. Question: From which version interface support static and default method ?
Ans:- v.8

9. Question: Why Default method intrduced in interface?
Ans:- Before java 8 if you added a new method to an existing interface , all implementing classes 
would break becoz they are forced to implement the new method. Wtih Default methods you can add new
methods to interface without breaking existing code becoz the interface provides a default 
implementation.

10. Predicate Interface in which Package.
Ans:- import java.util.function.Predicate;

11. Functinal interface also called single abstract method.

12. Question: Can Lambda Expressions have mutiple statements in thier body?
Ans:- YEs a lambda expression in java can have multiple statements in itsbody but in that case:-
You must enclose the body in curly braces
If you want to return a statement value you must use an explicit return statement.

13. Can you assign lambda expressions to a variable.
Ans:- Yes you can but, only if that variable's Type is Functional interface 
(Exaple above of Predicate any one )

14. Can a Lambda Expression return a value?
ans:- YEs but it depends on functional interface it is implementing 
1. If the functional interface's abstract method returns a value tehn lambda must return the value of 
same type.
2. If the Lambda Body has Single expression then return keyword is Optional.
3. If the Lambda body hass multiple statements you must use {} and an explicit return( if a value is returned )

   


*/