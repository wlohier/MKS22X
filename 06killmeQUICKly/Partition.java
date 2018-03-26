import java.util.Random;
import java.util.*;

public class Partition{
    
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

    public static void main(String[] args){
	int[] nums = {999,999,999,4,1,0,3,2,999,999,50};
	System.out.println(Partition.partition(nums, 0, 10));
	//System.out.println(Arrays.toString(nums));
    }
}
