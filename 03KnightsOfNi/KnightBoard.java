public class KnightBoard{
    private int[][] places = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                              {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    private int[][] board;
    public KnightBoard(int rows, int cols){
	if(rows < 0 || cols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[rows][cols];
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		if(board[r][c] == 0){
		    ans += "_ ";
		}
		else if(board.length *board[0].length >= 10 && board[r][c] < 10){
		    ans += " " + board[r][c] + " ";
		}
		else{
		    ans += board[r][c] + " ";
		}
	    }
	} return ans;
    }
}
