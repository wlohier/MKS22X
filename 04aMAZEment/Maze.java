import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.lang.*;

public class Maze{
    
    private char[][] maze;
    private boolean animate;
   

    public Maze(String filename) throws FileNotFoundException{
	animate = false;
	File f = new File(filename);
	Scanner in = new Scanner(f);
	ArrayList<String> lines = new ArrayList<String>();
        while(in.hasNext()){
	    String line = in.nextLine();
	    lines.add(line);
	}
	maze = new char[lines.size()][lines.get(0).length()];
        for(int i = 0; i < lines.size(); i++){
	    for(int j = 0; j < lines.get(i).length(); j++){
		maze[i][j] = lines.get(i).charAt(j);
	    }
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
	int ER = 0;
	int EC = 0;
	for(int i=0; i < maze.length; i++){
	    for(int j=0; j < maze[0].length; j++){
		if(maze[i][j] == 'S'){
		    SR = i;
		    SC = j;
		    maze[i][j] = '@';
		}
		if(maze[i][j] == 'E'){
		    ER = i;
		    EC = j;
		}
	    }
	}
        solve(SR, SC, 0);
	return solveCount(ER, EC);
    }

    public boolean valid(int r, int c){
	try{
	    if(maze[r][c] != '#' && maze[r][c] != '@' && maze[r][c] != '.'){
		return true;
	    }
	    return false;
	}
	catch(IndexOutOfBoundsException e){
	    return false;
	}
    }

    private int solve(int r, int c, int count){
	if(animate){
            clearTerminal();
            System.out.println(this);
            wait(30);
        }
	
	if(maze[r][c] == 'E'){
	    return count;
	}
	
	maze[r][c] = '@';
	int[][] params = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	for(int i=0; i<params.length; i++){
	    if(valid(r+params[i][0], c+params[i][1])){
		if(solve(r+params[i][0], c+params[i][1], count+1) != -1){
		   return count;
		}
	    }
	}
	maze[r][c] = '.';
	return -1;
    }

    private int solveCount(int ER, int EC){
	int ans = 0;
	for(int i=0; i < maze.length; i++){
	    for(int j=0; j<maze[0].length; j++){
		if(maze[i][j] == '@'){
		    ans += 1;
		}
	    }
	}
        int[][] params = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	for(int k = 0; k<params.length;k++){
	    if(maze[ER + params[k][0]][EC + params[k][1]] == '@'){
		return ans;
	    }
	}
	return -1;
    }

    public String toString(){
	String ans = "";
	for(int i = 0; i < maze.length; i++){
	    for(int j = 0; j < maze[0].length; j++){
		ans += maze[i][j];
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[] args){
	try{
	Maze M1 = new Maze("Maze1.txt");
	Maze M2 = new Maze("Maze2.txt");
	Maze M3 = new Maze("Maze3.txt");
	Maze M4 = new Maze("Maze4.txt");
	//System.out.println(M1.solve());
        //System.out.println(M2.solve());
	//M3.solve();
	//System.out.println(M3.solve());
	//M4.solve();
	System.out.println(M4.solve());

	//System.out.println(M1.solve());
	//System.out.println(M2.solve());
	//System.out.println(M3.solve());
	}catch(FileNotFoundException e){
	    System.exit(0);
	    System.out.println("Maze not found");
	}
    }
}
