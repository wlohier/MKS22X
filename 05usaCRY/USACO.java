import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.lang.*;

public class USACO{
    
    public static int bronze(String filename){
	try{
	    int[] RCEN = new int[4];
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    ArrayList<String> lines = new ArrayList<String>();
	    while(in.hasNext()){
		String line = in.nextLine();
		lines.add(line);
	    }
	    for(int i = 0; i<4; i++){
		RCEN[i] = java.lang.Integer.parseInt(lines.get(0).split(" ")[i]);
	    }
	    lines.remove(0);
	    int[][] board = new int[RCEN[0]][RCEN[1]];
	    for(int r = 0; r<board.length; r++){
		for(int c = 0; c<board[0].length; c++){
		    board[r][c] = java.lang.Integer.parseInt(lines.get(0).split(" ")[c]);
		}
		lines.remove(0);
	    }
	    for(int s=0; s<lines.size();s++){
		int[] RCD = new int[3];
		for(int RCDind = 0; RCDind < 3; RCDind++){
		    RCD[RCDind] = java.lang.Integer.parseInt(lines.get(s).split(" ")[RCDind]);
		}
		RCD[0]-=1;
		RCD[1]-=1;
		int max = board[RCD[0]][RCD[1]];
		for(int bi = 0; bi < 3; bi++){
		    for(int bc = 0; bc < 3; bc++){
			if(board[RCD[0] + bi][RCD[1] + bc] >= max){
			    max = board[RCD[0] + bi][RCD[1] + bc];
			}
		    }
		}
		while(RCD[2] > 0){
		    for(int bi = 0; bi < 3; bi++){
			for(int bc = 0; bc < 3; bc++){
			    if(board[RCD[0] + bi][RCD[1] + bc] == max){
				board[RCD[0] + bi][RCD[1] + bc]--;
			    }
			}
		    }
		    max--;
		    RCD[2]--;
		}
	    }
	    int agg = 0;
	    for(int i=0; i<board.length; i++){
		for(int j=0; j<board[0].length; j++){
		    board[i][j] = RCEN[2] - board[i][j];
		    if(board[i][j] < 0){
			board[i][j] = 0;
		    }
		    agg += board[i][j];
		}
	    }
	    return 72*72*agg;
	}
	catch(FileNotFoundException e){
	    System.exit(0);
	    System.out.println("file not found");
	}
	return -1;
    }

    public static int silver(String filename){
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    ArrayList<String> lines = new ArrayList<String>();
	    while(in.hasNext()){
		String line = in.nextLine();
		lines.add(line);
	    }
	    int end = lines.size() - 1;
	    String[] lineSplit = lines.get(0).split(" ");
	    String[] EndlineSplit = lines.get(end).split(" ");
	    int N = java.lang.Integer.parseInt(lineSplit[0]);
	    int M = java.lang.Integer.parseInt(lineSplit[1]);
	    int T = java.lang.Integer.parseInt(lineSplit[2]);
	    int R1 = java.lang.Integer.parseInt(EndlineSplit[0]);
	    int C1 = java.lang.Integer.parseInt(EndlineSplit[1]);
	    int R2 = java.lang.Integer.parseInt(EndlineSplit[2]);
	    int C2  = java.lang.Integer.parseInt(EndlineSplit[3]);
	    lines.remove(0);
	    lines.remove(end - 1);
	    char[][] board = new char[N][M];
	    int[][] current = new int[N][M];
	    int[][] past = new int[N][M];
	    for(int i = 0; i < board.length; i++){
		for(int j = 0; j < board[0].length; j++){
		    board[i][j] = lines.get(i).charAt(j);
		    current[i][j] = 0;
		    past[i][j] = 0;
		}
	    }
	    past[R1 - 1][C1 - 1] = 1;
	    for(int time = 1; time <= T; time++){
		if(time % 2 == 1){
		    swap(board, current, past);
		}
		else{
		    swap(board, past, current);
		}
	    }
	    if(T%2 == 1){
		return current[R2 - 1][C2 - 1];
	    }
	    return past[R2 - 1][C2 - 1];
	}
	catch(FileNotFoundException e){
	    System.exit(0);
	    System.out.println("file not found");
	}
	return -1;
    }

    public static void swap(char[][] board, int[][] current, int[][] past){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		int sum = 0;
		if(board[i][j] != '*'){
		    if(i > 0){
		        sum += past [i-1][j];
		    }
		    if(i < board.length - 1){
		        sum += past[i+1][j];
		    }
		    if(j > 0){
		        sum += past[i][j-1];
		    }
		    if(j < board[0].length - 1){
		        sum += past[i][j+1];
		    }
		}
		current[i][j] = sum;
	    }
	}
    }

    public static void main(String[] args){
	System.out.println(USACO.bronze("test.txt"));
    }
}
