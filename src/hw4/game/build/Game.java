package hw4.game.build;
import hw4.maze.build.Cell;
import hw4.maze.build.CellComponents;
import hw4.maze.build.Grid;
import hw4.maze.build.Row;
import hw4.player.build.Movement;
import hw4.player.build.Player;

import java.util.Random;
import java.util.ArrayList;


public class Game{
	
	private Grid grid;
	private Random rand = new Random(); 
	private int size;
	//methods are tentative and may need parameters, different access levels etc 
	
	
	public boolean play(Movement m, Player p) {
		
		return true;
    }  

	//Game constructor based on size
	public Game(int size) {
		super();
		this.size = size;
	}
	
	//Game constructor based on grid
	public Game(Grid grid) {
		super();
		this.grid = grid;
	}

	//Getters and Setters
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
	//
	
	//Creates a random grid
	public Grid createRandomGrid(int size)
	{
<<<<<<< HEAD
		if(size > 2 && size < 8) {
			ArrayList<Row> rows = new ArrayList<Row>();
			for(int i = 0; i < size; i++) {
				rows.add(i, createRandomRow(i, size));
			  
=======
	    ArrayList<Row> rows = new ArrayList<>();
	    Cell[][] grid = new Cell[size][size];
		createRandomCell(1);
		for(int i = 0; i < size; i++) {
			for(int j = 1; j < size; j++) {
				//Top Edge
				if(i == 0 && j < (size - 1)) {
					grid[i][j] = createRandomCell(5);
				}
				//Top Right Corner
				else if(i == 0 && j == (size - 1)) {
					grid [i][j] = createRandomCell(2);
				}
				//Right Edge
				else if(i < (size - 1) && j == (size - 1)){
					grid [i][j] = createRandomCell(6);
				}
				//Bottom Right Corner
				else if(i == (size - 1) && j == (size - 1)){
					grid [i][j] = createRandomCell(3);
				}
				//Bottom Edge
				else if(i == (size - 1) && j < (size - 1)){
					grid [i][j] = createRandomCell(6);
				}
				//Bottom Left Corner
				else if(i == (size - 1) && j == 0){
					grid [i][j] = createRandomCell(6);
				}
				//Left Edge
				else if(i < (size - 1) && j == 0) {
					grid [i][j] = createRandomCell(8);
				}
				else {
					grid [i][j] = createRandomCell(0);
				}
>>>>>>> a8b165c2a93b67206909ea39719e2f297e87a2e0
			}
			return new Grid(rows);
		}
<<<<<<< HEAD
		return null;
=======
		
		return new Grid(rows);
>>>>>>> a8b165c2a93b67206909ea39719e2f297e87a2e0
	}
	
	//Creates a random row
	public Row createRandomRow(int i, int size){
		ArrayList<Cell> cells = new ArrayList<>();				
				for(int j = 0; j < size; j++) {
					//Top Left Corner
					if(i == 0 && j == 0) {
						cells.add(j, createRandomCell(1));	
					}
					//Top Edge
					else if(i == 0 && j < (size - 1)) {
						cells.add(j, createRandomCell(5));
					}
					//Top Right Corner
					else if(i == 0 && j == (size - 1)) {
						cells.add(j, createRandomCell(2));
					}
					//Right Edge
					else if(i < (size - 1) && j == (size - 1)){
						cells.add(j, createRandomCell(6));
					}
					//Bottom Right Corner
					else if(i == (size - 1) && j == (size - 1)){
						cells.add(j, createRandomCell(3));
					}
					//Bottom Edge
					else if(i == (size - 1) && j < (size - 1)){
						cells.add(j, createRandomCell(7));
					}
					//Bottom Left Corner
					else if(i == (size - 1) && j == 0){
						cells.add(j, createRandomCell(4));
					}
					//Left Edge
					else if(i < (size - 1) && j == 0) {
						cells.add(j, createRandomCell(8));
					}
					else {
						cells.add(j, createRandomCell(0));
					}
					
				}
		return new Row(cells);
	}
	
	//Creates a random cell, setting it depending on its location in the grid
	public Cell createRandomCell(int location) {
		Cell cell = new Cell(null, null, null, null);
		//Middle of Grid
		if(location == 0) {
			cell.setUp(CellComponents.randomComponent());
			cell.setDown(CellComponents.randomComponent());
			cell.setLeft(CellComponents.randomComponent());
			cell.setRight(CellComponents.randomComponent());
		}
		//Top Left Corner
		else if(location == 1) {
			cell.setUp(CellComponents.WALL);
			cell.setDown(CellComponents.randomComponent());
			cell.setLeft(CellComponents.EXIT);
			cell.setRight(CellComponents.randomComponent());
		}
		//Top Right Corner
		else if(location == 2) {
			cell.setUp(CellComponents.WALL);
			cell.setDown(CellComponents.randomComponent());
			cell.setLeft(CellComponents.randomComponent());
			cell.setRight(CellComponents.WALL);
		}
		//Bottom Right Corner
		else if(location == 3) {
			cell.setUp(CellComponents.randomComponent());
			cell.setDown(CellComponents.WALL);
			cell.setLeft(CellComponents.randomComponent());
			cell.setRight(CellComponents.WALL);
		}
		//Bottom Left Corner
		else if(location == 4) {
			cell.setUp(CellComponents.randomComponent());
			cell.setDown(CellComponents.WALL);
			cell.setLeft(CellComponents.WALL);
			cell.setRight(CellComponents.randomComponent());
		}
		//Top Edge
		else if(location == 5) {
			cell.setUp(CellComponents.WALL);
			cell.setDown(CellComponents.randomComponent());
			cell.setLeft(CellComponents.randomComponent());
			cell.setRight(CellComponents.randomComponent());
		}
		//Right Edge
		else if(location == 6) {
			cell.setUp(CellComponents.randomComponent());
			cell.setDown(CellComponents.randomComponent());
			cell.setLeft(CellComponents.randomComponent());
			cell.setRight(CellComponents.WALL);
		}
		//Bottom Edge
		else if(location == 7) {
			cell.setUp(CellComponents.randomComponent());
			cell.setDown(CellComponents.WALL);
			cell.setLeft(CellComponents.randomComponent());
			cell.setRight(CellComponents.randomComponent());
		}
		//Left Edge
		else if(location == 8) {
			cell.setUp(CellComponents.randomComponent());
			cell.setDown(CellComponents.randomComponent());
			cell.setLeft(CellComponents.WALL);
			cell.setRight(CellComponents.randomComponent());
		}
		else {
			cell.setUp(CellComponents.randomComponent());
			cell.setDown(CellComponents.randomComponent());
			cell.setLeft(CellComponents.randomComponent());
			cell.setRight(CellComponents.randomComponent());
		}
		return cell;
	}

	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}
	
	
	
}


//so we have to create a 3d array that represents the gameBoard
//we should do this as random
//the exit will always be on the top left corner
//