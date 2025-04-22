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
			cell.getUp();
			return true;
		}
		if(m == Movement.DOWN && cell.getUp() == CellComponents.APERTURE)
		{
			cell.getDown();
			return true;
		}
		if(m == Movement.LEFT && cell.getUp() == CellComponents.APERTURE)
		{
			cell.getLeft();
			return true;
		}
		if(m == Movement.RIGHT && cell.getUp() == CellComponents.APERTURE)
		{
			cell.getRight();
			return true;
	   }
		return false;
		
		
	}
	
	public Game(int size) {
		super();
		this.size = size;
	}
	
	public Game(Grid grid) {
		super();
		this.grid = grid;
	}

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
			}
		}
		
		return new Grid(rows);
	}
	
	//Sets random cell depending on its location in the grid
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
			cell.setUp(CellComponents.randomComponent());
			cell.setDown(CellComponents.randomComponent());
			cell.setLeft(CellComponents.WALL);
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