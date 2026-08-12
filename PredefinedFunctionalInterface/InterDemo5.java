// import java.util.function.*;

// public class InterDemo5
// {
	// public static void main(String[] args){
		// Consumer<String> c1 = a -> System.out.println(a);
		// c1.accept("ram ");
		
		// Consumer<Integer> i1 = (a) -> System.out.println(a);
		// Consumer<Integer> i2 = (a) -> System.out.println("a->"+a*a*a);
		
		// for(int i = 1 ; i <= 10 ; i++)
		// {
			// i1.andThen(i2).accept(i);
		// }
	// }
// }

/*
Profile Of Consumer:-
public interface java.util.function.Consumer<T> {
  public abstract void accept(T);
  public default java.util.function.Consumer<T> andThen(java.util.function.Consumer<? super T>);
}
*/

/*
Profile of Supplier:-
public interface java.util.function.Supplier<T> {
  public abstract T get();
}
*/


// import java.util.function.*;
// @FunctionalInterface
// interface Inter1<R>{
	// R get();
// }
// public class InterDemo5
// {
	// public static void main(String[] args){
		// Inter1<String> i1 = () -> "ram";
		// System.out.println(i1.get());
	// }
// }



/*
import java.util.function.*;

public class InterDemo5
{
	public static void main(String[] args){
		Supplier<String> s1 = ()->"Hello this is supplier";
		System.out.println(s1.get());
	}
}
*/


/*
Profile of BiPredicate interface
public interface java.util.function.BiPredicate<T, U> {
  public abstract boolean test(T, U);
  public default java.util.function.BiPredicate<T, U> and(java.util.function.BiPredicate<? super T, ? super U>);
  public default java.util.function.BiPredicate<T, U> negate();
  public default java.util.function.BiPredicate<T, U> or(java.util.function.BiPredicate<? super T, ? super U>);
}
*/

/*
import java.util.function.*;

public class InterDemo5
{
	public static void main(String[] args){
		BiPredicate<Integer,Integer> i = (a,b) -> (a+b)%2==0;
		System.out.println(i.test(10,20));
	}
}
*/

/*

import java.util.function.*;
@FunctionalInterface
interface Inter1<T,U>{
	boolean test(T t,U u);
}
public class InterDemo5
{
	public static void main(String[] args){
		Inter1<Integer,Integer> i = (a,b) -> a+b%2==0;
		System.out.println(i.test(20,34));
	}
}

*/



/*
Profile of BiFunction Functional Interface:-
public interface java.util.function.BiFunction<T, U, R> {
  public abstract R apply(T, U);
  public default <V> java.util.function.BiFunction<T, U, V> andThen(java.util.function.Function<? super R, ? extends V>);
}

BiFunction<Integer,Double,Double> i = (a,b) -> a+b;
System.out.println(i.apply(10,20.8)); 

 
*/



/*
BiConsumer Profile :-
public interface java.util.function.BiConsumer<T, U> {
  public abstract void accept(T, U);
  public default java.util.function.BiConsumer<T, U> andThen(java.util.function.BiConsumer<? super T, ? super U>);
}
*/

/*
import java.util.function.*;
class Demo2{
	public static void main(String... adr){
		BiConsumer<Integer,String> i = (a,b) -> System.out.println("id="+a+"\t name="+b);
		i.accept(101,"aaaa");
	}
}
*/

/*

import java.util.function.*;
@FunctionalInterface
interface Inter1<T,U>{
	void accept(T e,U v);
}
public class InterDemo5
{
	public static void main(String[] args){
		Inter1<Integer,String> i = (a,b) -> System.out.println("id = "+a+"   name="+b);
		i.accept(10,"aaa");
		i.accept(11,"bbb");
		i.accept(13,"ccc");
		System.out.println(i.test(20,34));
	}
}

*/
