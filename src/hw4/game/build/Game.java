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

	
	/**
	 * creates a boolean that returns false if the player or movement is null
	 * sets cell to the current cell the player is occupying
	 * checks if the cell should move to the cell in the direction it is trying to go to 
	 * @param m
	 * @param p
	 * @return if the cell is null, false is returned 
	 * @return if the cell is not null and hits a wall, set the cell 
	 * @return if the cell is not null and hits exit, set the cell 
	 * @return if the cell is not null and hits an apperture cell, set the cell 
	 * */
	public boolean play(Movement m, Player p) 
	{
		
		if(p == null || m == null)
		{
			return false;
		}
		//Row userRow = grid.getRows().get(0);
		//Cell cell = userRow.getCells().get(0);

		Cell cell = p.getCurrentCell();
	
		if(cell == null)
		{
			return false;
		}
		if((m == Movement.UP && cell.getUp() == CellComponents.WALL) || (m == Movement.DOWN && cell.getDown() == CellComponents.WALL) || (m == Movement.RIGHT && cell.getRight() == CellComponents.WALL) || (m == Movement.LEFT && cell.getLeft() == CellComponents.WALL))
		{
			p.setCurrentCell(cell); 
			return true;
		}
		if((m == Movement.UP && cell.getUp() == CellComponents.EXIT) || (m == Movement.DOWN && cell.getDown() == CellComponents.EXIT) || (m == Movement.RIGHT && cell.getRight() == CellComponents.EXIT) || (m == Movement.LEFT && cell.getLeft() == CellComponents.EXIT))
		{   
			p.setCurrentCell(cell); 
			return true;
		}	
		if((m == Movement.UP && cell.getUp() == CellComponents.APERTURE))
		{
			p.setCurrentCell(cell.getUpCell()); 
			return true;
		}
		if((m == Movement.DOWN && cell.getDown() == CellComponents.APERTURE))
		{
			p.setCurrentCell(cell.getDownCell()); 
			return true;
		}
		if((m == Movement.LEFT && cell.getLeft() == CellComponents.APERTURE))
		{
			p.setCurrentCell(cell.getLeftCell()); 
			return true;
		}
		if((m == Movement.RIGHT && cell.getRight() == CellComponents.APERTURE))
		{
			p.setCurrentCell(cell.getRightCell()); 
			return true;
	   }
		return false;
    }  

	/**
	 * Creates a game constructor based on the size of the grid by calling the parent object and implementing the size of the grid equal to the current instance of itself
	 * @param the size of the grid 
	 */
	public Game(int size) 
	{
		super();
		this.size = size;
	}
	
	/**
	 * Creates a game constructor based on the grid by callinf the parent object and implementing grid equal to the current instance of itself
	 * @param grid
	 */
	public Game(Grid grid) 
	{
		super();
		this.grid = grid;
	}
	
	/**
	 * sets up the game by setting the current instance of grid to a random grid of ambiguous size 
	 * @param the size of the grid
	 */
	public void setUpGame(int size)
	{
		this.grid = createRandomGrid(size); 
	}
	
	/**
	 * gets the grid so that it can be used to play the game 
	 * @return returns a grid
	 */
	public Grid getGrid()
	{
		return grid;
	}
	
	/**
	 * sets the grid so that it can be used in testing the game
	 * @param an instance of the grid
	 */
	public void setGrid(Grid grid)
	{
		this.grid = grid;
	}
	//
	
	/**
	 * This method creates a new grid of size size and is full of cells. Each cell in the grid has random components 
	 * based on its location and are consistent with those around it. The grid has to be a size between 3x3 and 7x7.
	 * @param size is the desired size of the grid (Between 3x3 and 7x7).
	 * @return This method returns a new grid if it meets the size requirement and if not, returns null.
	 */
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
	
	/**
	 * This method creates a Row with randomized cells depending on their location in the grid.
	 * @param i is the current row.
	 * @param size is the length of the row.
	 * @return This method returns a newly created Row of length size, in the i row, with randomized components.
	 */
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
	
	/**
	 * This method creates a random cell, setting it depending on its location in the grid 
	 * (e.g if a cell is in the top right corner, its left component will be an EXIT,
	 * its top component will be a WALL, and the other two will be random).
	 * @param location is an integer indicating the cell's position in the grid:
	 * 	<ul>
	 * 		<li>1 - Top Left Corner</li>
	 * 		<li>2 - Top Right Corner</li>
	 * 		<li>3 - Bottom Right Corner</li>
	 * 		<li>4 - Bottom Left Corner</li>
	 * 		<li>5 - Top Edge</li>
	 * 		<li>6 - Right Edge</li>
	 * 		<li>7 - Bottom Edge</li>
	 * 		<li>8 - Left Edge</li>
	 * 		<li>Anything else will be set as a middle of the grid component</li>
	 * 	</ul>
	 * @return This method returns the newly created cell with all of its components.
	 */
	public Cell createRandomCell(int location) {
		Cell cell = new Cell();
		//Top Left Corner
		if(location == 1) {
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
		//Middle of Grid
		else {
			cell.setUp(CellComponents.randomComponent());
			cell.setDown(CellComponents.randomComponent());
			cell.setLeft(CellComponents.randomComponent());
			cell.setRight(CellComponents.randomComponent());
		}
		System.out.println(cell + "==" + location);
		return cell;
	}
	
	/**
	 * This method makes sure the grid is well connected and consistent. It checks which direction each cell shares borders
	 * in and sets those bordering cells as its neighbors. If a cell doesn't border another on a side, its neighbor in that
	 * direction will be set to null. The cell components on these shared borders will also be synchronized, creating a 
	 * consistent grid.
	 * @param grid is the grid in which neighbors should be set
	 * @param size is the length of the rows/columns
	 */
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
				shareBorders(current, up, left);
			}
		}
	}
	

	/**
	 * This method synchronizes the components on two of the borders of the current cell to make sure they are consistent.
	 * It does this by checking if the cells above or to the left of the current exist. If they do, it sets 
	 * current's components to that of its neighbor. 
	 * @param current is the current cell 
	 * @param up is the cell directly above the current cell
	 * @param left is the cell directly to the left of the current cell
	 */
	public void shareBorders(Cell current, Cell up, Cell left) {
		if(up != null) {
			current.setUp(up.getDown());
			}
		if(left != null) {
			current.setLeft(left.getRight());
			}
	}
    
	/**
	 *@return  a to string that writes a grid
	 */
	@Override
	public String toString() 
	{
		return "Game [grid=" + grid + "]";
	}

}
