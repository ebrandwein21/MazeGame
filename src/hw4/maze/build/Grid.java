


package hw4.maze.build;
import java.util.ArrayList;
public class Grid{
	private ArrayList<Row> rows;
	private int startingPosition;
	private int size;
	/**
	 * a constructor that passes an arrayList of rows for the grid
	 * @param an arrayList of rows to initialize the grid
	 */
	public Grid(ArrayList<Row> rows)
	{
		this.rows = rows;
	}
	
	/**
	 * gets the cell in the column and row in the grid
	 * @param row
	 * @param col
	 * @return returns a row of cells in the row
	 */
	public Cell getCell(int row, int col)
	{
       return rows.get(row).getCell(col);
   }
	
	public Cell setCell(int row, int col)
	{
       return rows.get(row).getCell(col);
   }
	
	
	/**
	 * gets the rows in the grid stored in an arrayList
	 * @return returns the rows in the grid 
	 */
	public ArrayList<Row> getRows()
	{
		return rows;
	}
	
	/**
	 * sets the rows in the arrayList equal to an instance of itself
	 * @param an arrayList of the rows in the grid
	 */
	public void setRows(ArrayList<Row> rows)
	{
		this.rows = rows;
	}
	
	/**
	 * gets the starting position of the grid and returns it for use
	 * @return startingPosition
	 */
	public int getStartingPosition()
	{
		return startingPosition;
	}
	
	/**
	 * sets the starting position of the grid and creates a new instance 
	 * @param size of the grid
	 */
	public void setstartingPosition(int startingPosition)
	{
		this.startingPosition = startingPosition;
	}
	
	/**
	 * gets the size of the grid and returns it for use
	 * @return size of the grid
	 */
	
	public int getSize() {
       return size;
   }
	
	/**
	 * sets the size of the grid and returns it to the current instance of the size
	 * @param size of the grid
	 */
   public void setSize(int size) {
       this.size = size;
   }
	/**
	 * @return returns a to string of rows in the the grid
	 */
	
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
}


