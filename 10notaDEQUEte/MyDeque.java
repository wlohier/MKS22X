public class MyDeque<E>{
    private E[] data;
    public MyDeque(){
	data = new E[10];
    }
    public MyDeque(int init){
	data = new E[init];
    }
}
