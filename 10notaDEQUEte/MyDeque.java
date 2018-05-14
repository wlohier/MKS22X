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
	D1.addFirst("hi");
	D1.addFirst("Hello");
	D1.addFirst("Fish");
	System.out.println(D1);
	/*
	D1.removeFirst();
	System.out.println(D1);
        D1.removeFirst();
	System.out.println(D1);
	D1.removeFirst();
	System.out.println(D1);
	*/
	D1.addLast("Tacos");
	System.out.println(D1);
	D1.addLast("Cardi");
	System.out.println(D1);
	D1.removeLast();
	System.out.println(D1);
	D1.removeLast();
	System.out.println(D1);
	System.out.println(D1.getFirst());
	System.out.println(D1.getLast());
	
    }
    
}
