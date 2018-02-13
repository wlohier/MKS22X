public class KnightBoard{
    private int[][] board;
    public KnightBoard(int rows, int cols){
	if(rows < 1 || cols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[rows][cols];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; board++){
		board[i][j] = 0;
	    }
	}
    }
}
