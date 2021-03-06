import java.util.Iterator;
@SuppressWarnings("unchecked")

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    private int size;
    private Node first;
    private Node last;
    public MyLinkedListImproved(){
	size = 0;
	first = null;
	last = null;
    }

    public Node getFirst(){
	return first;
    }

    public Node getLast(){
	return last;
    }

    public boolean add(T i){
	Node n = new Node(i);
	if(size > 0){
	    size++;
	    last.setNext(n);
	    last = n;
	    return true;
	}
	size++;
	first = n;
	last = n;
	return true;
	
    }

    public void clear(){
	first = null;
	last = null;
	size = 0;
    }

    public boolean add(int index, T val){
	if(index > size || index < 0){
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

    public T get(int index){
	if(index > size()-1 || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getVal();
    }

    public T set(int index, T value){
	if(index >= size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}
        T i = getNode(index).getVal();
	getNode(index).setVal(value);
	return i;
    }

    public int indexOf(T value){
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

    public boolean remove(T value){
	if(!inList(value)){
	    return false;
	}
	Node n = getNode(value);
	if(indexOf(n.getVal()) == 0){
	    first = n.getNext();
	    size--;
	    first.setPrev(null);
	    n.setNext(null);
	    n.setPrev(null);
	    return true;
	}
	if(indexOf(n.getVal()) == size()-1){
	    last = n.getPrev();
	    size--;
	    last.setNext(null);
	    n.setNext(null);
	    n.setPrev(null);
	    return true;
	}
        n.getPrev().setNext(n.getNext());
	n.getNext().setPrev(n.getPrev());
	return true;
    }

    public T remove(int index){
	if(index >= size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	    T i = first.getVal();
	    first = first.getNext();
	    size--;
	    return i;
	}
	if(index == size()-1){
	    T i = last.getVal();
	    last = last.getPrev();
	    size--;
	    return i;
	}
	
	
	Node n = getNode(index);
        T i = n.getVal();
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

    private boolean inList(T val){
	int i = 0;
	Node n = first;
	while(i < size()){
	    if(n.getVal().equals(val)){
		return true;
	    }
	    i++;
	    n = n.getNext();
	}
	return false;
    }

    private Node getNode(T val){
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

    public int max(){
	if(size() < 1){
	    return -1;
	}
	T maxT = first.getVal();
	Node current = first;
	int index = 0;
	int maxIndex = 0;
	while(index < size()){
	    T n = current.getVal();
	    if(n.compareTo(maxT) > 0){
		maxIndex = index;
	    }
	    current = current.getNext();
	    index++;
	}
	return maxIndex;
    }

    public int min(){
	if(size() < 1){
	    return -1;
	}
	T minT = first.getVal();
	Node current = first;
	int index = 0;
	int minIndex = 0;
	while(index < size()){
	    T n = current.getVal();
	    if(n.compareTo(minT) < 0){
		minIndex = index;
	    }
	    current = current.getNext();
	    index++;
	}
	return minIndex;
    }

    public void extend(MyLinkedListImproved<T> other){
	last.setNext(other.getFirst());
	last = other.getLast();
	size = size() + other.size();
	other.clear();
    }

    public String toString(){
	if(size() < 1) return "[]";
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

    

    public Iterator<T> iterator(){
	return new ListIterator(first);
    }

    private class ListIterator implements Iterator<T>{
	private Node current;
	
	public ListIterator(Node s){
	    current = s;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}

	public boolean hasNext(){
	    return !current.getNext().equals(null);
	}
	public T next(){
	    if(hasNext()){
		current = current.getNext();
	    } else{
		System.exit(0);
	    }
	    return current.getPrev().getVal();
	}
    }

    private class Node{
	private Node next,prev;
	private T data;
	private Node(T i){
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

	private T getVal(){
	    return data;
	}

	private void setVal(T i){
	    data = i;
	}

	public String toString(){
	    return "" + data;
	}
    }

    public static void main(String[] args){
	MyLinkedListImproved<String> M1 = new MyLinkedListImproved<>();
	MyLinkedListImproved<Integer> M2 = new MyLinkedListImproved<>();
	M1.add("Hello");
	M1.add("Daijoubu?");
	M1.add(1, "greeeat");
	M2.add(0, 10);
	M2.add(2);
	M2.add(-1);
	M2.add(3, -11);
	System.out.println(M1.getLast());
	System.out.println(M1.getFirst());
	System.out.println(M2.getLast());
	System.out.println(M2.getFirst());
	System.out.println(M1.get(2));
	M1.add("Psych");
	System.out.println(M1.get(3));
	System.out.println(M1.toString());
	System.out.println(M2.toString());
	M1.remove("Hello");
	M2.remove(3);
	System.out.println(M1.indexOf("Psych"));
	System.out.println(M2.indexOf(2));
	System.out.println(M1.toString());
	System.out.println(M2.toString());
    }
}
