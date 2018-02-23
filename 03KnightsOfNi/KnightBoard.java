public class KnightBoard{
    private int[][] board;
    private int[][] positions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
				 {2, 1}, {2, -1}, {-1, 2}, {-1, -2}};
    public KnightBoard(int rows, int cols){
	if(rows < 0 || cols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[rows][cols];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; board++){
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve(int startRow, int startCol){
    }

    public boolean solveHelp(int startRow, int startCol, int num){
	int thisRow = startRow + positions[i][0];
	int thisCol = startCol + positions[i][1
	if(num > board.length * board[0].length){
	    return true;
	}
	for(int i = 0; i < positions.length; i++){
	    if(board[thisRow][thisCol] == 0){
		board[thisRow][thisCol] = num;
		solveHelp(thisRow, thisCol, num+1);
	    }
	}
					      
					      
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(c = 0; c < board[0].length; c++){
		if(board[r][c] == 0){
		    ans += "_ ";
		}
		else if(board.length *board[0].length >= 10 && board[r][c] < 10){
		    ans += " " + board[r][c] + " ";
		}
		else{
		    ans += 
		}
	    }
	}
    }
}
