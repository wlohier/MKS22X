public class MyDeque<E>{
    private E[] data;
    private int size;
    private int start;
    private int end;
    
    public MyDeque(){
	data = new E[10];
	size = 0;
	start = 0;
	end = 0;
    }
    public MyDeque(int init){
	data = new E[init];
	size = 0;
	start = 0;
	end = 0;
    }

    public int size(){
	return size;
    }

    private void resize(E[] data){
        E[] newdata = new E[data.length*2];
	for(int i = 0; i < size(); i++){
	    newdata[i] = data[(i+start)%size()];
	}
	start = 0;
	end = size();
        data = newData;
    }

    public void addFirst(E val){
	if((start-1)%(data.length) == end){
	    resize();
	}
	data[(start-1)%data.length] = val;
	first = (start-1)%data.length;
	size++;
    }

    public void addLast(E val){
	if((end+1)%(data.length)==start){
	    resize();
	}
	data[(end+1)%data.length] = val;
	last = (end+1)%data.length;
	size++;
    }

    public E removeFirst(){
	E ans = data[first];
	data[first] = null;
	size--;
	first = (first+1)%data.length;
	return ans;
    }

    public E removeLast(){
	E ans = data[last];
	data[last] = null;
	last = (end-1)%data.length;
	size--;
	return ans;
    }
    
}
