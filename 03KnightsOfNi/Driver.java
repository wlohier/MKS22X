public class Driver{
    public static void main(String[] args){
	KnightBoard B1 = new KnightBoard(5, 6);
	System.out.println(B1.countSolutions(4, 5));
	System.out.println(B1.toString());
    }
}
