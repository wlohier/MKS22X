public class Merge{
    public static void merge(int[] data, int[] temp, int lo1, int lo2, int hi1, int hi2){
	for(int i = lo1, i < hi2, i++){
	    if(data[lo1] < data[lo2]){
		temp[i] = data[lo1];
	        if(lo1 < hi1){
		    lo1++;
		}
	    }
	    else{
		temp[i] = data[lo2];
		if(lo2 < hi2){
		    lo2++;
		}
	    }
	}
    }

    public static void mergesort(int[] nums){
	int[] temp = new int[nums.length];
	help(data, temp, 0, nums.length - 1);
    }

    public static void help(int[] data, int[] temp, int lo, int hi){
	if(lo < hi){
	    int mid = lo/2 + hi/2;
	    help(temp, data, lo, mid);
	    help(temp, data, mid+1, hi);
	    merge(data, temp, lo, mid+1, mid, hi)
	}
    }
    
}
