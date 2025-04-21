package hw4.player.build;

import hw4.maze.build.Cell;
import hw4.maze.build.Row;

public class Player{
	Cell currentCell;
	Row currentRow;
	
	
	public Player(Row row, Cell cell) {
		super();
		this.currentRow = row;
		this.currentCell = cell;
	}
	
	public Row getCurrentRow() {
		return currentRow;
	}


	public Cell getCurrentCell() {
		return currentCell;
	}

	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}

	
	

	
}