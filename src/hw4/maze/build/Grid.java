package hw4.maze.build;
import java.util.ArrayList;


public class Grid{

	private ArrayList<Row> rows;

	public Grid(ArrayList<Row> rows)
	{
		this.rows = rows;
	}
	
	public Cell getCell(int row, int col) {
        return rows.get(row).getCell(col);
    }
	
	public ArrayList<Row> getRows() {
		return rows;
	}
	
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
}
