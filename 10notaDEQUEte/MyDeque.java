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

    private int[] resize(E[] data){
        E[] newdata = new E[data.length*2];
	for(int i = 0; i < size(); i++){
	    newdata[i] = data[(i+start)%size()];
	}
	start = 0;
	end = size();
	return newdata;
    }

    public void addFirst(E val){
	
    }
    
}
