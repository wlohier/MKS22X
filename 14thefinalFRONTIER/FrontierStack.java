public class FrontierQueue implements Frontier{
    private FDeque<Location> stack;

    private FrontierQueue(){
	stack = new FDeque<>();
    }

    public void add(Location n){
	queue.addLast(n);
    }

    public Location next(){
	return queue.removeLast();
    }

    public boolean hasNext(){
	return stack.size() > 0;
    }
}
