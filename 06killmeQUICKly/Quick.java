import java.util.*;

public class Quick{

    public static quickSelect(int[] nums, int k){
	int start = partition(nums, 0, nums.length-1);
	if(start < k){
	    while
	}
    }
    
    public static int partition(int[] nums, int start, int end){
        int pivot = nums[end];
	int temp = end;
	end--;
        while(start < end){
	    if(nums[start] > pivot){
	        swap(nums, start, end);
		end--;
	    }
	    else{
		start++;
	    }
	}
        swap(nums, temp, start + 1);
	System.out.println(Arrays.toString(nums));
	return start + 1;
    }

    public static void swap(int[] nums, int I1, int I2){
	int temp = nums[I1];
	nums[I1] = nums[I2];
	nums[I2] = temp;
    }
}
