import java.util.*;
public class Merge{
    
    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	int middleton = mid + 1;
	int JLo = lo;
	int index = lo;
        while(JLo <= mid && middleton <= hi){
	    if(data[JLo] <= data[middleton]){
		temp[index] = data[JLo];
		JLo++;
		index++;
	    }
	    else{
		temp[index] = data[middleton];
		index++;
		middleton++;
	    }
	}

	while(JLo <= mid){
		temp[index] = data[JLo];
		index++;
		JLo++;
	}
        while(middleton <= hi){
		temp[index] = data[middleton];
		index++;
		middleton++;
	}
	System.out.println("data: "+ Arrays.toString(data));
	System.out.println("temp: "+ Arrays.toString(temp));
    }

    public static void mergesort(int[] nums){
	if(nums.length < 2){
	    return;
	}
	int[] temp = new int[nums.length];
	for(int i = 0; i < nums.length; i++){
	    temp[i] = nums[i];
	}
	help(nums, temp, 0, nums.length - 1);
    }

    public static void help(int[] data, int[] temp, int lo, int hi){
	if(lo >= hi){
	    return;
	}
        int mid = lo/2 + hi/2;
        help(temp, data, lo, mid);
        help(temp, data, mid + 1, hi);
        merge(temp, data, lo, mid, hi);
	
    }

    public static void main(String[] args){
	int[] data = {1,4,33,6,2,5,0,0,0,6,4,6,3,6,9,2,234,6,3};
	mergesort(data);
	System.out.println(Arrays.toString(data));
    }
    
}
