import java.util.*;
import java.io.*;

public class Maze{
    
    private char[][] maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException{
	animate = false;
	File f = new File(filename);
	Scanner in = new Scanner(f);
	int width = 0;
        if(in.hasNext()){
	    width = in.nextLine().length();
	}
	int height = 0;
	while(in.hasNext()){
	    height++;
	}
	maze = new char[width][height];
	int ind = 0;
	while(in.hasNext()){
	    String line = in.nextLine();
	    for(int i = 0; i < line.length(); i++){
		maze[i][ind] = line.charAt(i);
	    }
	    ind++;
	}

	int numS = 0;
	int numE = 0;
	for(int w = 0; w < maze.length; w++){
	    for(int h = 0; h < maze[0].length; h++){
		if(maze[w][h] == 'E') numE++;
		if(maze[w][h] == 'S') numS++;
	    }
	}
	if(numS != 1 || numE != 1){
	    throw new IllegalStateException();
	}
    }

        private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){
        animate = b;
    }


    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }

    public int solve(){
	int SR = 0;
	int SC = 0;
	for(int i=0; i < board.length; i++){
	    for(int j=0; j < board[0].length; j++){
		if(board[r][c] == 'S'){
		    SR = i;
		    SC = j;
		    board[r][c] = 0;
		}
	    }
	}
	return solve(SR, SC, 0);
    }

    public boolean valid(int r, int c){
	try{
	    int halpME = board[r][e];
	}
    }

    private int solve(int r, int c, int count){
	if(board[r][c] == 'E'){
	    return count;
	}
	board[r][c] = '@';
	int[][] params = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	for(int i=0; i<params.length; i++){
	    
	}
    }

    public String toString(){
	String ans = "";
	for(int i = 0; i < maze.length; i++){
	    for(int j = 0; j < maze.length; j++){
		ans += maze[i][j];
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[] args){
	try{
	Maze M1 = new Maze("Maze1.txt");
	System.out.println(M1);
	}catch(FileNotFoundException e){
	    System.exit(0);
	}
    }
}
