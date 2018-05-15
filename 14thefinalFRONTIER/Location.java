public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int dSofar;
    private int priority;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public int getx(){
	return x;
    }

    public int gety(){
	return y;
    }

    public Location getPrev(){
	return previous;
    }

    public int compareTo(Location other){
	return priority - other.getPriority();
    }

    public int getDSoFar(){
	return dSoFar;
    }

    public int getPriority(){
	return priority;
    }
}
