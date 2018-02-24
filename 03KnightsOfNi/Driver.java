public class Driver{
    public static void main(String[] args){
	KnightBoard B1 = new KnightBoard(5, 5);
	B1.solve(0, 0);
	System.out.println(B1.toString());
    }
}
