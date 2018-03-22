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
	    for(int r = 0; r<RCEN[0]; r++){
		for(int c = 0; c<RCEN[1]; c++){
		    board[r][c] = java.lang.Integer.parseInt(lines.get(0).split(" ")[c]);
		    lines.remove(0);
		}
	    }
	    for(int s=0; s<lines.size();s++){
		int[] RCD = new int[3];
		for(int RCDind = 0; RCDind < 3; RCDind++){
		    RCD[RCDind] = java.lang.Integer.parseInt(lines.get(0).split(" ")[RCDind]);
		}
		lines.remove(0);
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
			agg += board[i][j];
		    }
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
	    int N = lines.get(0).charAt(0) - 48;
	    int M = lines.get(0).charAt(2) - 48;
	    int T = lines.get(0).charAt(4) - 48;
	    int R1 = lines.get(end).charAt(0) - 48;
	    int C1 = lines.get(end).charAt(2) - 48;
	    int R2 = lines.get(end).charAt(4) - 48;
	    int C2  = lines.get(end).charAt(6) - 48;
	    lines.remove(0);
	    lines.remove(end);
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
	    board[R1][C1] = 1;
	    for(int time = T; time < 0; time--){
		if(time % 2 == 0){
		    swap(board, current, past);
		}
		else{
		    swap(board, past, current);
		}
	    }
	    if(T%2 == 0){
		return current[R2][C2];
	    }
	    return past[R2][C2];
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
		if(board[i][j] != '*'){
		    if(i > 0){
			current[i][j] += past [i-1][j];
		    }
		    if(i < board.length - 1){
			current[i][j] += past[i+1][j];
		    }
		    if(j > 0){
			current[i][j] += past[i][j-1];
		    }
		    if(j < board[0].length - 1){
			current[i][j] += past[i][j+1];
		    }
		}
	    }
	}
    }
}
