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
	if(numS > 1 || numE > 1){
	    throw new IllegalStateException();
	}
    }
}
