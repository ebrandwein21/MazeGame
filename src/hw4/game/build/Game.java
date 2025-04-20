package hw4.game.build;
import hw4.maze.build.Grid;
import hw4.maze.build.Row;

import java.util.Random;
import java.util.ArrayList;


public class Game{
	
	private Grid grid;
	private Random rand = new Random(); 
	
	//methods are tentative and may need parameters, different access levels etc 
	public void setUpGame(int size)
	{
		this.grid = createRandomGrid(size);
	}
	
	public void assertsEquals()
	{
		
	}
	
	public Grid getGrid()
	{
		return grid;
	}
	
	public void setGrid(Grid grid)
	{
		this.grid = grid;
	}
	
	
	
	public Grid createRandomGrid(int size)
	{
	    ArrayList<Row> rows = new ArrayList<>();
	
		int[][] grid = new int[size][size];
		
		
		return new Grid(rows);
	}
	
	
}


//so we have to create a 3d array that represents the gameBoard
//we should do this as random
//the exit will always be on the top left corner
//