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
	return 1;
    }
}
