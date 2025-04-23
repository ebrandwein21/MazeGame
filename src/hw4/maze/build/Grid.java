package hw4.maze.build;
import java.util.ArrayList;


public class Grid{

	private ArrayList<Row> rows;

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
	 * @return returns a to string of rows in the the grid
	 */
	
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
}
