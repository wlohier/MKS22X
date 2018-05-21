import java.util.*;

public class MyDeque<E>{
    private E[] data;
    private int size;
    private int start;
    private int end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (E[])new Object[10];
	size = 0;
	start = 0;
	end = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int init){
	if(init < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[init];
	size = 0;
	start = 0;
	end = 0;
    }

    public int size(){
	return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        E[] newdata = (E[])new Object[data.length*2];
	for(int i = 0; i < size(); i++){
	    newdata[i] = data[(i+start)%size()];
	}
	start = 0;
	end = size();
        data = newdata;
    }

    public void addFirst(E val){
	if(val.equals(null)){
	    throw new IllegalArgumentException();
	}
	if(size == 0){
	    data[0] = val;
	    size++;
	    end++;
	    return;
	}
        if(data.length == size()){
	    resize();
	}
	data[(start + data.length-1)%data.length] = val;
	start = (start + data.length-1)%data.length;
	size++;
    }

    public void addLast(E val){
	if(val.equals(null)){
	    throw new IllegalArgumentException();
	}
	if(size() == 0){
	    data[0] = val;
	    size++;
	    end+=1;
	    start = data.length-1;
	    return;
	}
	if(data.length == size()){
	    resize();
	}
	data[(end)%data.length] = val;
	end = (end+1)%data.length;
	size++;
    }

    public E removeFirst(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	E ans = data[start];
	data[start] = null;
	size--;
	start = (start+1+data.length)%data.length;
	return ans;
    }

    public E removeLast(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	E ans = data[(end+data.length-1)%data.length];
	data[(end+data.length-1)%data.length] = null;
	end = (end+data.length-1)%data.length;
	size--;
	return ans;
    }

    public E getFirst(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public E getLast(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	return data[(end+data.length-1)%data.length];
    }

    /*

    public String toString(){
	String ans = "[";
        for(int i = 0; i < data.length; i++){
	    ans += data[i] + " ";
	}
	ans += "]";
	return ans;
    }

    public static void main(String[]args){
	
	MyDeque<String> D1 = new MyDeque<>(3);
	MyDeque<Integer> D2 = new MyDeque<>(5);
	D2.add(
	
    }
    */

    public String toString(){
    String ans = "[";
    if(start < end){
      for (int i = start; i <= end; i++){
        ans += data[i] + " , ";
      }
    }
    else{
      for(int i = start; i < data.length; i++){
        ans += data[i] + ", ";
      }
      for(int i = 0; i <= end; i++){
        ans += data[i] + ", ";
      }
    }
    ans = ans.substring(0, ans.length() - 2) + "]";
    return ans;
  }

    public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();

    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 1000);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      //System.out.println("MyDeque: " + a1);
      //System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }
  }
    
}
