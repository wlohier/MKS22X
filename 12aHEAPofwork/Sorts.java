public class Sorts{
    public static void heapSort(int[] data){
	heapify(data);
	int part = data.length-1;
	for(int i = 0; i < data.length; i++){
	    swap(data, 0, part);
	    pushDMax(data, data[0], 0);
	    part--;
	}
    }

    public static void heapify(int[]data){
	for(int i = data.length-1; i >= 0; i--){
	    pushDMax(data, data[i], i);
	}
    }

    public static void pushDMax(int[] data, int val, int index){
	int compInd1 = index*2+1;
	int compInd2 = index*2+2;
	int comp = compInd1;
	if(data[compInd1] < data[compInd2]){
	    comp = compInd2;
	}
	if(comp < data.length){
	    if(val < data[comp]){
		swap(data, index, comp);
		pushDMax(data, val, comp);
	    }
	}
    }

    public static  void swap(int[] data, int ind1, int ind2){
	int temp = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = temp;
    }
}
