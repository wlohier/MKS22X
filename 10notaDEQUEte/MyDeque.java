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
	if((start-1)%(data.length) == end){
	    resize();
	}
	data[(start-1)%data.length] = val;
	start = (start-1)%data.length;
	size++;
    }

    public void addLast(E val){
	if(val.equals(null)){
	    throw new IllegalArgumentException();
	}
	if((end+1)%(data.length)==start){
	    resize();
	}
	data[(end+1)%data.length] = val;
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
	start = (start+1)%data.length;
	return ans;
    }

    public E removeLast(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	E ans = data[end];
	data[end] = null;
	end = (end-1)%data.length;
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
	return data[end];
    }
    
}
