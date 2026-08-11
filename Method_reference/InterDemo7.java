//Method Referencing :-
/*
Method Reference is a feature introduced in Java 8 that provides a highly compact, readable way to 
write a Lambda expression by reusing an already existing method
Only used in Functional Interface ::
*/

// import java.util.function.*;

// class InterDemo7{
	// public static void main(String[] args){
		// Function<Integer,Double> f = Math.sqrt;
		// Consumer c = System.out::println;
		// c.accept(f.apply(25));
	// }
// }


class InterDemo7
{
	public static void m1()
	{
		for(int i = 0 ; i<10; i++)System.out.println("Childer");
	}
	public static void main(String[] args){
		/*
		Runnable r = () -> {
			for(int i = 0 ; i<10; i++)System.out.println("Childer");
		};
		
		*/
		Runnable r = InterDemo7::m1;
		/*
		Above Lambda Expression implements run() method 
		Instead of Writing lambda expression separately we have some alternative syntax :-
		Method and Constructor Reference
		What is the Advantage?
		In case of lambda expression we have to write separately everytime it is required,
		but in case of method reference we can use already existing code multiple time;
		Ex in method m1
		1. The job of child thread already available in m1 method  	
		if this functional interface refer this method instead of writing again then it will become
		more easy 
		How can we tell our functionalinterface to refer to that method : 
Very Simple Sytax :=
Runnable r = InterDemo7::m1;
        |Whereever lambda expression required just use method reference 
		biggest advantage we get is code reusability
		*/
		Thread t = new Thread(r);
		t.start();
		for(int i = 0 ; i<10; i++)System.out.println("Main Thread");
		
		/*
		Functional Interface method can be mapped to our speicified method by using :: colon operateor 
		this is called method refercne.
		In above example Runnable interface run method refers to Test class m2 method.
		
		Q: What type of method it can be ?
		If Static Sytax :- class name::method name
		(if we use same sytax in instance we get non static method m1 cannot be referenced from 
		static context like this )
		If Instance :- object reference::method name
		*/
		
		/*
		Example if instance method :--
		Test t1 = new Test();
		Runnable r = t1::m1;
		*/
		
		/*
		 Rules To Care About method Reference :--
		
		1. The argument must be same of both the methods except arguments we have to not worry
        about any other things , return type and modifiers can be different no issue. 		
		ex : public void run() , public void m1()
		
		learnt about invokedynamic a nice update in jvm pov to this topic or java 8 
		*/
	}
}
