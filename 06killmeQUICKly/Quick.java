import java.util.*;

public class Quick{

<<<<<<< HEAD
    public static quickSelect(int[] nums, int k){
	int start = partition(nums, 0, nums.length-1);
	if(start < k){
	    while
	}
    }
=======

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

    
>>>>>>> 6b94a1402edae9a2e76c538df45a5cf6858e51cc
    
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
<<<<<<< HEAD
	}
        swap(nums, temp, start + 1);
	System.out.println(Arrays.toString(nums));
	return start + 1;
=======
	    //System.out.println(Arrays.toString(nums));
	}
	
        swap(nums, temp, start+1);
	//System.out.println(Arrays.toString(nums));
	return start+1;
>>>>>>> 6b94a1402edae9a2e76c538df45a5cf6858e51cc
    }

    public static void swap(int[] nums, int I1, int I2){
	int temp = nums[I1];
	nums[I1] = nums[I2];
	nums[I2] = temp;
    }
<<<<<<< HEAD
=======

    public static void main(String[] args){
	int[] nums = {9,8,7,6,5,4,3,2,1,0};
	System.out.println(Arrays.toString(nums));
	//Quick.partition(nums, 0, 9);
	//Quick.partition(nums, 1, 9);
	Quick.quicksort(nums);
        System.out.println(Arrays.toString(nums));
    }
>>>>>>> 6b94a1402edae9a2e76c538df45a5cf6858e51cc
}
