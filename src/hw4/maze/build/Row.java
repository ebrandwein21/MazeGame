package hw4.maze.build;

import java.util.ArrayList;

public class Row
{
	
 private ArrayList<Cell> cells;

     /**
	 * a constructor that passes an arrayList of cells for the rows in the grid
	 * @param an arrayList of cells to initialize the rows in the grid  
	 */
     public Row(ArrayList<Cell> cells)
	 {
		 this.cells = cells;
	 }
 	/**
	 * gets the cell in the row at its current index
	 * @param the index of the cell
	 * @return returns the current index of the cell in the row
	 */
 	 public Cell getCell(int index) 
	 {
 		return cells.get(index);
	 }
 	/**
	 * gets the cells in the rows of the grid stored in an arrayList
	 * @return returns the cells in the rows of the grid
	 */
 	 public ArrayList<Cell> getCells() 
	 {
 		return cells;
	 }
 	
 	/**
	 * sets the cells in the arrayList equal to an instance of itself 
	 * @param an arrayList of the cells in the rows of the grid 
	 */
	 public void setCells(ArrayList<Cell> cells) 
	 {
		this.cells = cells;
	 }
	 
 	 /**
	 * @return returns a to string of cells in the the rows of the grid
	 */
	
	 @Override
	 public String toString() 
	 {
		 return "Row [cells=" + cells + "]";
	 }
}