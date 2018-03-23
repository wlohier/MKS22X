import java.util.Random;
import java.util.*;

public class Partition{
    
    public static int partition(int[] nums, int start, int end){
	Random Ran = new Random();
	int RI = java.lang.Math.abs((Ran.nextInt()%(end - start)))+start;
	System.out.println(RI);
	swap(nums, start, RI);
	int temp = start;
	start++;
        while(start < end){
	    if(nums[start] > nums[temp]){
	        swap(nums, start, end);
		end--;
	    }
	    else{
		start++;
	    }
	    System.out.println(Arrays.toString(nums));
	}
	int pivotTemp = nums[temp];
	for(int i = 1; i < end; i++){
	    nums[i-1] = nums[i];
	}
	nums[end] = pivotTemp;
	return end;
    }

    public static void swap(int[] nums, int I1, int I2){
	int temp = nums[I1];
	nums[I1] = nums[I2];
	nums[I2] = temp;
    }

    public static void main(String[] args){
	int[] nums = {999,999,999,4,1,0,3,2,999,999,999};
	System.out.println(Partition.partition(nums, 0, 10));
	//System.out.println(Arrays.toString(nums));
    }
}
