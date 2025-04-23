package hw4.game.build;
import hw4.maze.build.Cell;
import hw4.maze.build.CellComponents;
import hw4.maze.build.Grid;
import hw4.maze.build.Row;
import hw4.player.build.Movement;
import hw4.player.build.Player;
import hw4.simulation.build.Simulation;

import java.util.Random;
import java.util.ArrayList;


public class Game{
	
	private Grid grid;
	private Random rand = new Random(); 
	private int size;
	private Simulation simulation;
	//methods are tentative and may need parameters, different access levels etc 
	
	
	public boolean play(Movement m, Player p) {
		
		//checks if player or movement is null
		if(p == null || m == null)
		{
			return false;
		}
		
		//gets the current row and cell
		Cell cell = p.getCurrentCell();
		
		System.out.println(cell + "==" + "hello");
				
		//checks if cell is a wall
	    
		if(m == Movement.UP && cell.getUp() == CellComponents.WALL || m == Movement.DOWN && cell.getDown() == CellComponents.WALL || m == Movement.RIGHT && cell.getRight() == CellComponents.WALL || m == Movement.LEFT && cell.getLeft() == CellComponents.WALL)
		{
	        
			return false;
		}
		if(m == Movement.UP && cell.getUp() == CellComponents.EXIT || m == Movement.DOWN && cell.getDown() == CellComponents.EXIT || m == Movement.RIGHT && cell.getRight() == CellComponents.EXIT || m == Movement.LEFT && cell.getLeft() == CellComponents.EXIT )
		{
			return true;
		}	
		if(m == Movement.UP && cell.getUp() == CellComponents.APERTURE)
		{
			p.setCurrentCell(cell.getUpCell()); //not correct, trying to figure out how to move player
			return true;
		}
		if(m == Movement.DOWN && cell.getDown() == CellComponents.APERTURE)
		{
			p.setCurrentCell(cell.getDownCell()); //not correct, trying to figure out how to move player
			return true;
		}
		if(m == Movement.LEFT && cell.getLeft() == CellComponents.APERTURE)
		{
			p.setCurrentCell(cell.getLeftCell()); //not correct, trying to figure out how to move player
			return true;
		}
		if(m == Movement.RIGHT && cell.getRight() == CellComponents.APERTURE)
		{
			p.setCurrentCell(cell.getRightCell()); //not correct, trying to figure out how to move player
			return true;
	   }
		return false;
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
		if(size > 2 && size < 8) {
			ArrayList<Row> rows = new ArrayList<Row>();
			for(int i = 0; i < size; i++) {
				
				rows.add(i, createRandomRow(i, size));
			}
			Grid grid = new Grid(rows);
			
			//Set cell neighbors
			setCellNeighbors(grid, size);
			return grid;
		}
		return null;
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
		Cell cell = new Cell();
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
		System.out.println(cell + "==" + location);
		return cell;
	}
	
	public void setCellNeighbors(Grid grid, int size) {
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				Cell current = grid.getCell(i, j);
				Cell up = null;
				Cell down = null;
				Cell right = null;
				Cell left = null;
				
				if(i > 0) {
					up = grid.getCell(i - 1, j);
				}
				if(i < (size - 1)) {
					down = grid.getCell(i + 1, j);
				}
				if(j > 0) {
					left = grid.getCell(i, j - 1);
				}
				if(j < (size - 1)) {
					right = grid.getCell(i, j + 1);
				}
				
				current.setNeighbors(up, down, left, right);
				shareBorders(current, up, down, right, left);
			}
		}
	}
	
	public void shareBorders(Cell current, Cell up, Cell down, Cell right, Cell left) {
				if(up != null) {
					current.setUp(up.getDown());
				}
				if(left != null) {
					current.setLeft(left.getRight());
				}
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