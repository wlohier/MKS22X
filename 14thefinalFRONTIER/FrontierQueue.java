public class FrontierQueue implements Frontier{    private FDeque<Location> queue;    private FrontierQueue(){	queue = new FDeque<>();    }    public void add(Location n){	queue.addLast(n);    }    public Location next(){	return queue.removeLast();    }    public boolean hasNext(){	return queue.size() > 0;    }}