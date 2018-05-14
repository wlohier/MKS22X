public class MyHeap<E extends Comparable<E>>{
    private E[] data;
    private int size;
    private boolean MAX;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	data = (E[])new Comparable[10];
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
	data = (E[])new Comparable[10];
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

    public E remove(){
        E ans = data[0];
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
        if(compInd >= 0){
	    if(val.compareTo(data[compInd]) < 0){
		swap(index, compInd);
		pushMin(val, compInd);
	    }
	}
    }

    private void pushMax(E val, int index){
	int compInd = (index-1)/2;
        if(compInd >= 0){
	    if(val.compareTo(data[compInd]) > 0){
		swap(index, compInd);
		pushMax(val, compInd);
	    }
	}
    }

    private void pushDMax(E val, int index){
	int compInd1 = index*2+1;
	int compInd2 = index*2+2;
	int comp = compInd1;
	if(compInd2 < size && data[compInd1].compareTo(data[compInd2]) < 0){
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
	if(compInd2 < size && data[compInd1].compareTo(data[compInd2]) > 0){
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

    public E peek(){
	return data[0];
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

    public String toString(){
	String ans = "[";
	for(int i = 0; i < size; i++){
	    ans += data[i] + ",";
	}
	ans = ans.substring(0, ans.length()-1);
	ans += "]";
	return ans;
    }

    public static void main(String[] args){
	/*
	MyHeap<Integer> H1 = new MyHeap<>(false);
	H1.add(1);
	H1.add(10);
	H1.add(2);
	H1.add(11);
	H1.add(15);
	H1.add(19);
	H1.add(5);
	H1.add(2);
	H1.add(20);
	H1.add(100);
	System.out.println(H1);
	H1.remove();
	System.out.println(H1);
        H1.remove();
	System.out.println(H1);
	*/
    }
}
