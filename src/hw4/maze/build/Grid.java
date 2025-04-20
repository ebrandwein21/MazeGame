package hw4.maze.build;
import java.util.ArrayList;
import java.util.Random;


public class Grid{

	private ArrayList<Row> rows;

	public Grid(ArrayList<Row> rows)
	{
		this.rows = rows;
	}
	
	public ArrayList<Row> getRows() {
		return rows;
	}
	
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}
}
