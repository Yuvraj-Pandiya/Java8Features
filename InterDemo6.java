import java.util.function.*;
public class InterDemo6
{
	public static void main(String[] ar){
		int[] x = {10,20,30,40,50,607,0,80,2,5,15,41,21};
		IntPredicate i = (a) -> a>=20 && a<=40;
		for(int i1:x){
			if(i.test(i1)){
				System.out.println(i1);
			}
		}
	}
}

/*
Profile of IntPredicate:-
public interface java.util.function.IntPredicate {
  public abstract boolean test(int);
  public default java.util.function.IntPredicate and(java.util.function.IntPredicate);
  public default java.util.function.IntPredicate negate();
  public default java.util.function.IntPredicate or(java.util.function.IntPredicate);
}
*/

/*
Profile of LongPredicate:-
public interface java.util.function.LongPredicate {
  public abstract boolean test(long);
  public default java.util.function.LongPredicate and(java.util.function.LongPredicate);
  public default java.util.function.LongPredicate negate();
  public default java.util.function.LongPredicate or(java.util.function.LongPredicate);
}
*/

/*
Profile of DoublePredicate
  public abstract boolean test(double);
  public default java.util.function.DoublePredicate and(java.util.function.DoublePredicate);
  public default java.util.function.DoublePredicate negate();
  public default java.util.function.DoublePredicate or(java.util.function.DoublePredicate);
}
*/

/*
Profile of IntFunction
public interface java.util.function.IntFunction<R> {
  public abstract R apply(int);
}
*/


/*
Profile of LongFunction
public interface java.util.function.LongFunction<R> {
  public abstract R apply(long);
}
*/

/*
Profile of DoubleFunction
public interface java.util.function.DoubleFunction<R> {
  public abstract R apply(double);
}



/*
Profile of IntConsumer
public interface java.util.function.IntConsumer {
  public abstract void accept(int);
  public default java.util.function.IntConsumer andThen(java.util.function.IntConsumer);
}
*/


/*
Profile of LongConsumer
  public abstract void accept(long);
  public default java.util.function.LongConsumer andThen(java.util.function.LongConsumer);
}
*/

/*
Profile of DoubleConsumer
public interface java.util.function.DoubleConsumer {
  public abstract void accept(double);
  public default java.util.function.DoubleConsumer andThen(java.util.function.DoubleConsumer);
}
*/

/*
Profile of IntSupplier
  public abstract int getAsInt();
}
*/


/*
Profile of LongSupplier
public interface java.util.function.LongSupplier {
  public abstract long getAsLong();
}
*/


/*
Profile of DoubleSupplier
public interface java.util.function.DoubleSupplier {
  public abstract double getAsDouble();
}
*/

/*
Profile of BooleanSupplier
public interface java.util.function.BooleanSupplier {
  public abstract boolean getAsBoolean();
}
*/