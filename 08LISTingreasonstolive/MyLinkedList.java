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

    public void clear(){
	first = null;
	last = null;
	size = 0;
    }

    public boolean add(int index, Integer val){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	
        if(index == size()){
	    add(val);
	    return true;
	}
	else if(index == 0){
	    Node n = new Node(val);
	    n.setNext(first);
	    first = n;
	    size++;
	    return true;
	}
        else{
	    Node newNode = new Node(val);
	    newNode.setNext(getNode(index));
	    newNode.setPrev(getNode(index-1));
	    getNode(index-1).setNext(newNode);
	    getNode(index+1).setPrev(newNode);
	    size++;
	    return true;
	}
    }

    public int size(){
        return size;
    }

    public Integer get(int index){
	if(index > size()-1 || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getVal();
    }

    public Integer set(int index, Integer value){
	if(index >= size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Integer i = getNode(index).getVal();
	getNode(index).setVal(value);
	return i;
    }

    public int indexOf(Integer value){
	int i = 0;
	Node n = first;
	while(i < size()){
	    if(n.getVal().equals(value)){
		return i;
	    }
	    i++;
	    n = n.getNext();
	} return -1;
    }

    public boolean remove(Integer value){
	Node n = getNode(value);
	if(n.equals(null)){
	    return false;
	}
        n.getPrev().setNext(n.getNext());
	n.getNext().setPrev(n.getPrev());
	return true;
    }

    public Integer remove(int index){
	if(index >= size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	
	Node n = getNode(index);
	Integer i = n.getVal();
	n.getPrev().setNext(n.getNext());
	n.getNext().setPrev(n.getPrev());
	return i;
    }

    private Node getNode(int index){
	int i = 0;
	Node n = first;
        while(i < index){
	    n = n.getNext();
	    i++;
	}
	return n;
    }

    private Node getNode(Integer val){
	int i = 0;
	Node n = first;
	while(i < size()){
	    if(n.getVal().equals(val)){
		return n;
	    }
	    i++;
	    n = n.getNext();
	}
	return null;
    }

    public String toString(){
	String ans = "[";
	int i = 0;
	Node n = first;
        while(i < size()){
	    ans += n.toString();
	    ans += ", ";
	    n = n.getNext();
	    i++;
	}
	ans = ans.substring(0, ans.length()-2);
	ans += "]";
	return ans;
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

	private Node getPrev(){
	    return prev;
	}

	private void setPrev(Node n){
	    prev = n;
	}

	private Integer getVal(){
	    return data;
	}

	private void setVal(int i){
	    data = i;
	}

	public String toString(){
	    return "" + data;
	}
    }
}
