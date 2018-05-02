public class Calculator{
    public static double eval(String s){
	String[] data = s.split(" ");
	for(int i = 0; i < data.length; i++){
	    if(data[i].equals("+")){
		data[i] = Double.parseDouble(data[i-1])+
		    Double.parseDouble(data[i-2]) + "";
	    }
	    if(data[i].equals("-")){
		data[i] = Double.parseDouble(data[i-1])-
		    Double.parseDouble(data[i-2]) + "";
	    }
	    if(data[i].equals("*")){
		data[i] = Double.parseDouble(data[i-1])*
		    Double.parseDouble(data[i-2]) + "";
	    }
	    if(data[i].equals("/")){
		data[i] = Double.parseDouble(data[i-1])/
		    Double.parseDouble(data[i-2]) + "";
	    }
	    if(data[i].equals("%")){
		data[i] = Double.parseDouble(data[i-1])%
		    Double.parseDouble(data[i-2]) + "";
	    }
	}
	return Double.parseDouble(data[data.length-1]);
    }
}
