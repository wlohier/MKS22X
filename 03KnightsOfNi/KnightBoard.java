public class KnightBoard{
    private int[][] board;
    private int[][] positions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
				 {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    
    public KnightBoard(int rows, int cols){
	if(rows < 0 || cols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[rows][cols];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		board[i][j] = 0;
	    }
	}
    }


    public void checkBoard(){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		if(board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
    }
    
    public boolean solve(int startRow, int startCol){
	checkBoard();
	return solveHelp(startRow, startCol, 1);
    }

    public boolean solveHelp(int startRow, int startCol, int num){
	board[startRow][startCol] = num;
	if(num == board.length * board[0].length){
	    return true;
	}
	for(int i = 0; i < positions.length; i++){
	    int thisRow = startRow + positions[i][0];
	    int thisCol = startCol + positions[i][1];
	    //System.out.println(Text.go(1, 1));
	    //System.out.println(this);
	    //Text.wait(50); //adjust this delay
	    if(thisRow < board.length && thisRow >= 0 &&
	       thisCol < board[0].length && thisCol >= 0 &&
	       board[thisRow][thisCol] == 0){
		if(solveHelp(thisRow, thisCol, num+1)){
		    return true;
		}
	    }
	} board[startRow][startCol] = 0;
	return false;
    }

    public int countSolutions(int startRow, int startCol)

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		if(board[r][c] == 0){
		    ans += "  ";
		}
	        else if(board.length * board[0].length >= 10){
		    if(board[r][c] > 9){
			ans += board[r][c] + " ";
		    }else{
			ans += " " + board[r][c] + " ";
		    }
		}
		else{
		    ans += board[r][c] + " ";
		}
	    }ans+= "\n";
	} return ans;
    }
}
