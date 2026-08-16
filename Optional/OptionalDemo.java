/*
Problem = > NullPointerException
Way = > Check null or avoid it  (null safety)


*/
import java.util.*;
class OptionalDemo{
	public static void main(String[] args){
		// 1.
		String name = null;
		// int len = name.length(); // NPE
		// Solution before java 8 Optional
		
		
		// 2. Traditional Approach 1
		int len = 0;
		if(name!=null){
			len = name.length();
		}
		
		// Note:- null represents the absence
		// of an object, but Java's type system doesn't force us to handle that absence.
		
		/*
		The Older approach is well and good for this program but what happen when we have so to deal
		with soo many objects for ex:- in real production code, Springboot , etc project there 
		code become lengthy and ugly if we keep on putting this if condition 
		Sometimes called as null-check hell.
		*/
		
		// 3. Traditional Approach 2 (We can use default value also) Don't go with above example let's 
		// take new one 
		User u1 = new User();
		u1.setName("newUser1");
		System.out.println(u1.getName());
		User u2 = new User();
		System.out.println(u2.getName());
		/*
		for user2 we didn't set the actual name but whatever we are setting we are getting for default
		but what if suppose that named user exist then there may be issue so we also have to somehow avoid
		this issue also
		*/
		
		// 4.Traditional Approach 3 (throw Exception)
		/*Throwing exception for every user if that name not found is not at all good because
		there may be condition many times when we did'nt find the user*/
		
		
		// 5. public String getName() This method says i return name but in reality 
		// if user exists then name otherwise null,The method signature doesn't 
		// communicate that second possibility.This is the core problem that Optional tries to address.
		
		// 6. Optional is a final class introduced in java 8 present in java.util package.
		
		// What it means :-  It simply says i have one container now that continer either have something or 
		// nothing. Two Possibilities.  Instead of the fact that something or nothing the core idea is we 
		// have the container that's it 
		
		// means we explicitly represents the absence of value Optional<>
		
		// Methods and working
		
		// 1. public boolean isPresent()
		// 2. public T get();
		// 3. static Optional<T> ofNullable(T)
		// 4. static Optional<T> of(T)
		// 5. static Optional<T> empty()
		// 6. public T orElse(T)
		String s1 = "this is valid string";
		String s2 = null;
		Optional<String> op1 = Optional.ofNullable(s1);
		Optional<String> op21 = Optional.of(s1);
		// Optional<String> op22 = Optional.of(s2);// NPE
		/* of simply gives the Optional object with provided value if it is not null otherwise npe
		*/
		Optional<String> op3 = Optional.ofNullable(s1);
		/*ofNullable simply put the specified value in container if given other keep empty and return
		that optional*/
		Optional<String> op4 = Optional.empty();
		/* empty provides empty Optional container object (follows singleton pattern for object creation)
		*/
		
		System.out.println(op1);
		System.out.println(op1.isPresent()); //This method simply checks value present or not
		System.out.println(op1.get()); //This method return the contained value and if there is null
		// we get NoSuchElementException
		// System.out.println(op4.get()); // NoSuchElementException
		
		System.out.println(op1.orElse("Not Present"));
		System.out.println(op4.orElse("Not Present"));
		/*It simply provides or return the value if container have the value otherwise return our 
		specified value*/
	}
}
class User{
	String name;
	public String getName(){
		if(name!=null)
			return name;
		
		return "UnknownUser";
	}
	public void setName(String name){
		this.name = name;
	}
}