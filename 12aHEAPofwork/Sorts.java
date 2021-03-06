public class Sorts{
    public static void heapSort(int[] data){
	heapify(data);
	int part = data.length-1;
	for(int i = 0; i < data.length; i++){
	    swap(data, 0, part);
	    pushDMax(data, data[0], 0, part);
	    part--;
	}
    }

    public static void heapify(int[]data){
	for(int i = data.length-1; i >= 0; i--){
	    pushDMax(data, data[i], i, data.length);
	}
	System.out.println(toString(data));
    }

    public static void pushDMax(int[] data, int val, int index, int maxI){
	int compInd1 = index*2+1;
	int compInd2 = index*2+2;
	int comp = compInd1;
	if(compInd2 < maxI && data[compInd1] < data[compInd2]){
	    comp = compInd2;
	}
	if(comp < maxI){
	    if(val < data[comp]){
		swap(data, index, comp);
		pushDMax(data, val, comp, maxI);
	    }
	}
    }

    public static  void swap(int[] data, int ind1, int ind2){
	int temp = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = temp;
    }

    public static String toString(int[] data){
	String ans = "[";
	for(int i = 0; i < data.length; i++){
	    ans += data[i] + ",";
	}
	ans = ans.substring(0, ans.length()-1);
	ans += "]";
	return ans;
    }

    public static void main(String[] args){
	/*
	int[] dataa = {1,3,2,55,3,6,7,6,2,0,0,6,5,7,8};
	heapSort(dataa);
	System.out.println(toString(dataa));
	*/
    }
}
