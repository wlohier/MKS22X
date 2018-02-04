import java.util.ArrayList;

public class Recursion{

    public int fact(int n){ // basic factorial funcion, breaks down for larger numbers
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 1;
	}
	return(n * fact(n - 1));
    }
    

    public int fib(int n){ //calculates the nth term of the fibonacci sequence
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return fibHelp(0, 1, n);
    }

    public int fibHelp(int t0, int t1, int n){ //cycles through the fibonacci sequence starting with 0 and 1
	if(n == 0){
	    return t0;
	}
	return fibHelp(t1, t0 + t1, n-1);
    }

    public double sqrt(double n){ //calculates an estimate of the square root of n
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 0;
	}
	return sqrtHelp(n/2, n);
    }

    public double sqrtHelp(double guess, double n){//uses Newton's formula to obtain increasingly accurate square root guesses
	if(java.lang.Math.abs(((Math.pow(guess, 2) - n)/2)) < .00001){ //checks to make sure estimate squared is close to the actual number
	    return guess;
	}
	double newGuess = (n/guess + guess)/2;
	return(sqrtHelp(newGuess, n));
    }

}
