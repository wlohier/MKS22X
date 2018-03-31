import java.util.*;

public class Quick{


    public static void quicksort(int[] nums){
        sort(nums, 0, nums.length-1);
    }

    public static void sort(int[] nums, int low, int high){
	if(low < high){
	    int k = partition(nums, low, high);
	    sort(nums, k+1, high);
	    sort(nums, low, k-1);
	}
    }

    public static int quickselect(int[] nums, int k){
        return select(nums, 0, nums.length-1, k);
    }

    public static int select(int[] nums, int low, int high, int k){
	int start = partition(nums, low, high);
	if(start < k){
	    return select(nums, start+1, nums.length-1, k);
	}
	if(start > k){
	    return select(nums, 0, start - 1, k);
	}
	return nums[start];
    }
    
    public static int partition(int[] nums, int start, int end){
        Random n = new Random();
	int Rihanna = (n.nextInt(end - start)) + start;
	int pivot = nums[Rihanna];
	System.out.println(pivot);
	int temp = start;
	int temp2 = end;
	swap(nums, start, Rihanna);
	start++;
        while(start < temp2){
	    System.out.println(start);
	    if(nums[start] > pivot){
	        swap(nums, start, temp2);
		temp2--;
	    }
	    else{
		start++;
	    }
	}
	if (nums[start] > pivot){
	    start --;
	}
	swap(nums,temp,start);
	System.out.println(start);
	return start;

    }

    public static void swap(int[] nums, int I1, int I2){
	int temp = nums[I1];
	nums[I1] = nums[I2];
	nums[I2] = temp;
    }

    public static void main(String[] args){
	int[] nums = {9,8,7,6,5,4,3,2,1,0};
	partition(nums,0,9);
	System.out.println(Arrays.toString(nums));
	//Quick.partition(nums, 0, 9);
	//Quick.partition(nums, 1, 9);
	quicksort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
