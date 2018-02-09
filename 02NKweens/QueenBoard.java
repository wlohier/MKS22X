public class QueenBoard{
    private int[][] board;
    
    public QueenBoard(int size){
	board = new int[size][size];
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		board[i][j] = 0;
	    }
	}
    }

    private boolean addQueen(int r, int c){
	board[r][c] = -1;
	for(inr row = r + 1; row < board.length; row++){
	    if(r + 1 < board.length){
		board[row][c]++
	    }
        }
        int diagUp = 1;
	int diagDown = 1;
	while(r + diagUp < board.length && c - diagUp >= 0){
	    board[r + diagUp][c - diagUp]++;
	    diagUp++;
	}
	while(r + diagDown < board.length && c + diagDown < board.length){
	    board[r + diagDown][c + diagDown]++;
	    diagDown++;
	}
    }
}
