import java.util.Random;

public class Partition{
    public static void partition(int[] nums, int start, int end){
	Random Ran = new Random();
	int RI = (Ran.nextInt()%(end - start))+start;
	swap(nums, 0, RI);
        while(start < end){
	    if(nums[start] > nums[0]){
	        swap(nums, start, end);
		end--;
	    }
	    else{
		start++;
	    }
	}
	swap(nums, 0, end);
    }

    public static void swap(int[] nums, int I1, int I2){
	int temp = nums[I1];
	nums[I1] = nums[I2];
	nums[I2] = temp;
    }
}
