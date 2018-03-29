public class MyLinkedList{
    private int size;
    private Node first;
    private Node last;
    public MyLinkedList(){
	size = 0;
	first = null;
	last = null;
    }

    public boolean add(int i){
	Node n = new Node(i);
	last.setNext(n);
	size++;
	return true;
    }

    public boolean add(int index, int val){
	return true;
    }

    private Node getNode(int index){
	int i = 0;
	Node n = start;
        while(i < index){
	    n = n.getNext();
	    i++;
	}
	return n;
    }

    private class Node{
	private Node next,prev;
	int data;
	private Node(int i){
	    data = i;
	    next = null;
	    prev = null;
	}

	private Node getNext(){
	    return next;
	}

	private void setNext(Node n){
	    next = n;
	}

	private int getPrev(){
	    return prev;
	}

	private int setPrev(Node n){
	    prev = n;
	}

	private int getVal(){
	    return data;
	}

	private int setVal(int i){
	    data = i;
	}

	public String toString(){
	    return "" + i;
	}
    }
}
