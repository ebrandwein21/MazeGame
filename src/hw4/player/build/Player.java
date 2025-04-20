package hw4.player.build;

import hw4.maze.build.Cell;
import hw4.maze.build.Row;

public class Player{
	Row row;
	Cell cell;
	
	public Player(Row row, Cell cell) {
		super();
		this.row = row;
		this.cell = cell;
	}
	
	public Row getCurrentRow() {
		return row;
	}


	public Cell getCurrentCell() {
		return cell;
	}

	
}