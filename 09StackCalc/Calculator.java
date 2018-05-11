public class Calculator{
    public static double eval(String s){
	String[] data = s.split(" ");
	for(int i = 0; i < data.length; i++){
	    if(data[i].equals("+")){
		data[i] = Double.parseDouble(data[i-1])+
		    Double.parseDouble(data[i-2]) + "";
	    }
	    if(data[i].equals("-")){
		data[i] = Double.parseDouble(data[i-2])-
		    Double.parseDouble(data[i-1]) + "";
	    }
	    if(data[i].equals("*")){
		data[i] = Double.parseDouble(data[i-1])*
		    Double.parseDouble(data[i-2]) + "";
	    }
	    if(data[i].equals("/")){
		data[i] = Double.parseDouble(data[i-2])/
		    Double.parseDouble(data[i-1]) + "";
	    }
	    if(data[i].equals("%")){
		data[i] = Double.parseDouble(data[i-2])%
		    Double.parseDouble(data[i-1]) + "";
	    }
	}
	return Double.parseDouble(data[data.length-1]);
    }

    public static void main(String[] args){
	System.out.println(eval("10 2.0 +"));
	System.out.println(eval("11 3 - 4 + 2.5 *"));
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
