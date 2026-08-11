class Sample{
	Sample()
	{
		System.out.println("Sample class Constructpr executed");
	}
	Sample(String s){
		System.out.println("Sample class Constructpr executed argument");
	}
}
interface Inter
{
	// public Sample get();
	public Sample get1(String s);
}
class InterDemo8
{
	public static void main(String[] arg){
		/* Constructor Reference :-
		Test::new
		When to use And where to use ?
		When a functional interface method returns an object
		In that particular case we can go for this concept
*/
    // Inter i = Sample::new ;
// Interface get ,method refer Sample class constructor
// Sample s1 = i.get();
// Sample s2 = i.get(); 	
// System.out.println(s1);
// System.out.println(s2);
/*Interface get method refer sample class constructor

What About the rule for argument compulsorily argument should match for both the method of 
functional  interface and as well as constructor
*/

// Sample s3 = i.get1("ruvi");
}
}