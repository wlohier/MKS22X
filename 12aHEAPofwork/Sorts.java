public class Sorts{
    public static void heapSort(int[] data){
    }

    public static void heapify(int[]data){
	for(int i = data.len);
    }

    public static pushDOWN(index i){
	
    }

    private static void pushDMax(int val, int index){
	int compInd1 = index*2+1;
	int compInd2 = index*2+2;
	int comp = compInd1;
	if(data[compInd1] < data[compInd2]){
	    comp = compInd2;
	}
	if(comp < data.length){
	    if(val < data[comp]){
		swap(index, comp);
		pushDMax(val, comp);
	    }
	}
    }

    private void swap(int ind1, int ind2){
	int temp = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = temp;
    }
}
