public class MyHeap<E extends Comparable<E>>{
    private E[] data;
    private int size;
    private boolean MAX;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	data = (E[])new Object[10];
	size = 0;
	MAX = true;
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean b){
	if(b){
	    MAX = true;
	}
	else{
	    MAX = false;
	}
	data = (E[])new Object[10];
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

    public String remove(){
	String ans = data[0].toString();
	data[0] = data[size-1];
	if(MAX){
	    pushDMax(data[0], 0);
	}
	else{
	    pushDMin(data[0], 0);
	}
	size--;
	return ans;
    }

    private void pushMin(E val, int index){
	int compInd = (index-1)/2;
        if(compInd > 0){
	    if(val.compareTo(data[compInd]) < 0){
		swap(index, compInd);
		pushMin(val, compInd);
	    }
	}
    }

    private void pushMax(E val, int index){
	int compInd = (index-1)/2;
        if(compInd > 0){
	    if(val.compareTo(data[compInd]) >= 0){
		swap(index, compInd);
		pushMax(val, compInd);
	    }
	}
    }

    private void pushDMax(E val, int index){
	int compInd1 = index*2+1;
	int compInd2 = index*2+2;
	int comp = compInd1;
	if(data[compInd1].compareTo(data[compInd2]) < 0){
	    comp = compInd2;
	}
	if(comp < size){
	    if(val.compareTo(data[comp]) < 0){
		swap(index, comp);
		pushDMax(val, comp);
	    }
	}
    }

    private void pushDMin(E val, int index){
	int compInd1 = index*2+1;
	int compInd2 = index*2+2;
	int comp = compInd1;
	if(data[compInd1].compareTo(data[compInd2]) > 0){
	    comp = compInd2;
	}
	if(comp < size){
	    if(val.compareTo(data[comp]) > 0){
		swap(index, comp);
		pushDMin(val, comp);
	    }
	}
    }

    public int size(){
	return size;
    }

    public String peek(){
	return data[0].toString();
    }

    private void swap(int ind1, int ind2){
	E temp = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = temp;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	E[] newdata = (E[])new Object[size*2];
	for(int i = 0; i < size; i++){
	    newdata[i] = data[i];
	}
	data = newdata;
    }
}
