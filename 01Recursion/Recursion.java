import java.util.ArrayList;

public class Recursion{

    public static int fact(int n){ // basic factorial funcion, breaks down for larger numbers
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 1;
	}
	return(n * fact(n - 1));
    }
    

    public static int fib(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return fibHelp(0, 1, n);
    }

    public static int fibHelp(int t0, int t1, int n){
	if(n == 0){
	    return t0;
	}
	return fibHelp(t1, t0 + t1, n-1);
    }





    
    public static void main(String[] args){
	//System.out.println(factorial(-2));
	//	System.out.println(fact(0));
	//	System.out.println(fact(1));
	//	System.out.println(fact(5));
	//        System.out.println(fact(11));
	//	System.out.println(fact(12));
	//System.out.println(fib(-1));
	System.out.println(fib(0));
	System.out.println(fib(1));
	System.out.println(fib(10));
	System.out.println(fib(20));
	System.out.println(fib(30));
    }

}
