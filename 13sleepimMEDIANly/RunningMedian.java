import java.util.*;

public class RunningMedian{
    private MyHeap<Double> maxH;
    private MyHeap<Double> minH;

    @SuppressWarnings("unchecked")
    public RunningMedian(){
	maxH = new MyHeap<>();
	minH = new MyHeap<>(false);
    }

    public double getMedian(){
	if(size() == 0){
	    throw new NoSuchElementException();
	}
	if(maxH.size() > minH.size()){
	    return maxH.peek();
	}
	else if(minH.size() > maxH.size()){
	    return minH.peek();
	}
	else{
	    return (minH.peek() + maxH.peek())/2;
	}
    }

    public void add(Double val){
	if(maxH.size()==0 && minH.size()==0){
	    maxH.add(val);
	}
	else if(val > maxH.peek()){
	    minH.add(val);
	}
	else{
	    maxH.add(val);
	}
	while(maxH.size()-minH.size() > 1){
	    minH.add(maxH.remove());
	}
	while(minH.size()-maxH.size() > 1){
	    maxH.add(minH.remove());
	}
    }

    public int size(){
	return maxH.size()+minH.size();
    }

    public String toString(){
	return "" +  getMedian();
    }
}
