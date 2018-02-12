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

    public boolean addKween(int r, int c){
	if(board[r][c] == 0){
	    board[r][c] = -1;
	    for(int row = r + 1; row < board.length; row++){
		if(r + 1 < board.length){
		    board[row][c]++;
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
	    return true;
	}return false;
    }

    public boolean removeKween(int r, int c){
	if(board[r][c] == -1){
	    board[r][c] = 0;
	    for(int row = r + 1; row < board.length; row++){
		if(r + 1 < board.length){
		    board[row][c]--;
	       	}
	    }
	    int diagUp = 1;
	    int diagDown = 1;
	    while(r + diagUp < board.length && c - diagUp >= 0){
		board[r + diagUp][c - diagUp]--;
		diagUp++;
	    }
	    while(r + diagDown < board.length && c + diagDown < board.length){
		board[r + diagDown][c + diagDown]--;
		diagDown++;
	    }
	    return true;
	} return false;
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		if(board[r][c] == -1){
		    ans += "Q ";
		}
		else{
		    ans += "_ ";
		}
	    } ans += "\n";
	}
	return ans;
    }

     public String toStringAlt(){
	String ans = "";
	for(int c = 0; c < board.length; c++){
	    for(int r = 0; r < board[0].length; r++){
		if(board[r][c] == -1){
		    ans += "Q ";
		}
		else{
		    ans += board[r][c] + " ";
		}
	    } ans += "\n";
	}
	return ans;
    }
}