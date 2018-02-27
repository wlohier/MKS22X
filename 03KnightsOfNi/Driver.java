public class Driver{
    public static void main(String[] args){
	KnightBoard B1 = new KnightBoard(5, 6);
	B1.solve(2, 2);
	System.out.println(B1.toString());
    }
}
