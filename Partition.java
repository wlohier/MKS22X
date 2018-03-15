public class Partition{
    public static void partition(int[] nums, int start, int end){
	random Ran = new random();
	int RI = (Ran.nextInt()%(end - start))+start;
	swap(nums, start, RI);
	swap(nums, i, start);
        while(start < end){
	    if(nums[j] < Rih & j > i){
		addFirst(nums[j], start);
		start+=1;
	    }
	    else if(nums[j] > Rih & j < i){
		addLast(nums[j], end);
		last -= 1
	    }
	    start++
	}
    }

    public static void swap(int[] nums, int I1, int I2){
	int temp = nums[I1];
	nums[I1] = nums[I2];
	nums[I2] = temp;
    }
}
