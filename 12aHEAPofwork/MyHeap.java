public class MyHeap<E extends comparable<E>>{
    private E[] data;
    private int size;
    private boolean MAX;

    public MyHeap(){
	data = new E[10];
	size = 0;
    }

    public MyHeap(boolean b){
	if(b){
	    MAX = true;
	}
	else{
	    MAX = false;
	}
	data = new E[10];
	size = 0;
    }

    public void add(E val){
	if(size == data.length){
	    resize();
	}
	data[size] = val;
	if(MAX){
	    pushMax(val, size);
	}
	else{
	    pushMin(val, size);
	}
	size++;
    }

    private void pushMin(E val, int index){
	compInd = (index-1)/2;
        if(compInd > 0){
	    if(val.compareTo(data[compInd]) < 0){
		swap(index, compInd);
		pushMin(val, compInd);
	    }
	}
    }

    private void pushMax(E val){
	compInd = (index-1)/2;
        if(compInd > 0){
	    if(val.compareTo(data[compInd]) >= 0){
		swap(index, compInd);
		pushMax(val, compInd);
	    }
	}
    }

    public int size(){
	return size;
    }

    private void swap(int ind1, int ind2){
	E temp = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = temp;
    }

    private void resize(){
	E[] newdata = new E[size*2];
	for(int i = 0; i < size; i++){
	    newdata[i] = data[i];
	}
	data = newdata;
    }
}
