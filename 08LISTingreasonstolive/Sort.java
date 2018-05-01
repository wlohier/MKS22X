import java.util.*;
import java.lang.*;

public class Sort extends MyLinkedListImproved{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	MyLinkedListImproved<Integer> pos = new MyLinkedListImproved<Integer>();
	MyLinkedListImproved<Integer> neg = new MyLinkedListImproved<Integer>();
	for(Integer x : data){
	    if(x > 0){
		pos.add(x);
	    }
	    else{
		neg.add(x);
	    }
	}
	if(pos.size() > 0 && neg.size() > 0){
	    radixSortPositive(pos);
	    radixSortNegative(neg);
	    neg.extend(pos);
	}
	else if(pos.size() > 0){
	   radixSortPositive(pos);
	}
	else{
	   radixSortNegative(neg);
	}
	return;
    }
    
    private static void radixSortPositive(MyLinkedListImproved<Integer> data){
        @SuppressWarnings("unchecked")MylinkedListImproved<Integer>[] bucket = new MyLinkedListImproved<Integer>[10];
	for(int Bey=0; Bey < 10; Bey++){
	    bucket[Bey] = new MyLinkedListImproved<Integer>();
	}

	int maxVal = data.max();
	int numDigs = log(maxVal);

	for(int dig = 0; dig < numDigs; dig++){
	    for(Integer i : data){
		int num = (int)(i/java.lang.Math.pow(10, dig))%10;
		bucket[num].add(i);
	    }

	    data.clear();
	    data.add(-1);

	    for(int riri = 0; riri < 10; riri++){
		data.extend(bucket[riri]);
	    }

	    data.remove(0);
	    
	}
	
    }

    public static int log(Integer i){
	int ans = 0;
	while(!i.equals(0)){
	    ans++;
	    i = i/10;
	}
	return ans;
    }
}
