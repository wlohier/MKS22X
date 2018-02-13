public class Driver{
    public static void main(String[] args){
	QueenBoard QB = new QueenBoard(25);
	System.out.println(QB.solve());
	System.out.println(QB.toString());
	System.out.println(QB.toStringAlt());
    }
}
