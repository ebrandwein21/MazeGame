package hw4.player.build;

import hw4.maze.build.Cell;
import hw4.maze.build.Row;


public class Player
{
	Cell currentCell;
	Row currentRow;
	
	/**
	 *  constructs a new object and equates the instance of row and cell to the current cell and row the player is occupying 
	 *  @param: an instance of row and cell
	 */
	public Player(Row row, Cell cell) 
	{
		super();
		this.currentRow = row;
		this.currentCell = cell;
	}
	
	/**
	 * gets the current row occupied by the player
	 * @return returns the current row 
	 */
	public Row getCurrentRow() {
		return currentRow;
	}
	
	/**
	 * sets the row to the current instance of itself as currentRow
	 * @param row
	 */
	public void setCurrentRow(Row row)
	{
		this.currentRow = row;
	}

	/**
	 * gets the current cell occupied by the player
	 * @return returns the current cell 
	 */
	public Cell getCurrentCell() 
	{
		return currentCell;
	}
	
	/**
	 * sets the cell to the current instance of itself as currentCell
	 * @param cell
	 */
	public void setCurrentCell(Cell cell)
	{
		this.currentCell = cell;
	}

	/**
	 * @return returns a to string of the current rows and cells
	 */
	@Override
	public String toString() 
	{
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
}