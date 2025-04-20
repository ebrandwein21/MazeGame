package hw4.maze.build;

import java.util.ArrayList;

public class Row{
	
	private ArrayList<Cell> cells;

 public Row(ArrayList<Cell> cells)
 
 {
	 this.cells = cells;
 }
 
 public ArrayList<Cell> getCells() {
		return cells;
	}
	
	public void setBook(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
}