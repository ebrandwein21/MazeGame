package hw4.maze.build;

import java.util.ArrayList;

public class Row{
	
	private ArrayList<Cell> cells;

 public Row(ArrayList<Cell> cells)
 
 {
	 this.cells = cells;
 }
 
 public Cell getCell(int index) {
     return cells.get(index);
 }
 
 public ArrayList<Cell> getCells() {
		return cells;
	}
	
public void setCells(ArrayList<Cell> cells) {
	this.cells = cells;
}



	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}
	
	
}