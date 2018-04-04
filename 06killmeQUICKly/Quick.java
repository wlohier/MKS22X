import java.util.*;

public class Quick{


    public static void quicksort(int[] nums){
	if(nums.length < 1){
	    return;
	}
        sort(nums, 0, nums.length-1);
    }

    public static void sort(int[] nums, int low, int high){
	if(low < high){
	    int[] k = Dpartition(nums, low, high);
	    sort(nums, k[1], high);
	    sort(nums, low, k[0] - 1);
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
    
    public static int[] Dpartition(int[] nums, int start, int end){
        Random n = new Random();
	int Rihanna = (n.nextInt(end - start)) + start;
	//System.out.println("pivot:" + nums[Rihanna]);
	swap(nums, start, Rihanna);	
	int temp = start;
	int temp2 = end;
	int Beyonce = start+1;
        while(Beyonce <= temp2){
	    //System.out.println("start =" + temp);
	    //System.out.println("comp:" + Beyonce);
	    //System.out.println("end:" + temp2);
	    if(nums[Beyonce] > nums[temp]){
	        swap(nums, Beyonce, temp2);
		temp2--;
	    }
	    else if(nums[Beyonce] == nums[temp]){
		Beyonce++;
	    }
	    else{
		swap(nums, Beyonce, temp);
		Beyonce++;
		temp++;
	    }
	    //System.out.println(Arrays.toString(nums));
	}
	int[] ans = {temp, Beyonce};
        return ans;

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
	int[] nums = {9,8,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,2,3,14,14,14,5};
	//Dpartition(nums,0,9);
	//System.out.println(Arrays.toString(nums));
	//Quick.Dpartition(nums, 0, 9);
	//Quick.Dpartition(nums, 1, 9);
	quicksort(nums);
        //System.out.println(Arrays.toString(nums));
    }
}
