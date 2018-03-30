public class MyLinkedList{
    private int size;
    private Node first;
    private Node last;
    public MyLinkedList(){
	size = 0;
	first = null;
	last = null;
    }

    public boolean add(Integer i){
	Node n = new Node(i);
	last.setNext(n);
	last = n;
	size++;
	return true;
    }

    public boolean add(int index, Integer val){
        if(val == list.length()){
	    add(val);
	    return true;
	}
	if(index == 0){
	    Node n = new Node(val);
	    n.setNext(first);
	    first = n;
	    size++;
	    return true;
	}
        
	Node newNode = new Node(val);
        newNode.setNext(getNode(index));
	newNode.setPrev(getNode(index-1));
	getNode(index-1).setNext(newNode);
	getNode(index+1).setPrev(newNode);
	size++;
	return true;
    }

    public int size(){
        return size;
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

    private Node getNode(Integer val){
	
    }

    private class Node{
	private Node next,prev;
	private Integer data;
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
