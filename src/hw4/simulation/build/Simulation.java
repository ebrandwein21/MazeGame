package hw4.simulation.build;

import hw4.game.build.Game;
import hw4.maze.build.Cell;
import hw4.maze.build.CellComponents;
import hw4.maze.build.Grid;
import hw4.maze.build.Row; 
import hw4.player.build.Movement;
import hw4.player.build.Player;

import java.util.ArrayList;
import java.util.Scanner;


public class Simulation
    {
	   private static Game game;
	   private static Grid grid;
	   private static Cell cell;
	   private static Player player;
	   public static Scanner mazeScanner = new Scanner(System.in);

public static void main(String[] args) 
    {
	 
	game = new Game(5);
    game.setUpGame(5);
	grid = game.getGrid();
	Movement move = getPlayerMovement(cell);
	player.setCurrentCell(grid.getRows().get(0).getCells().get(0));
	printBoard(grid, player);
	game.play(move, player);

    }  
	/**
	 * asks the user for which movement they would like 
	 * uses a scanner to check user input
	 * sets the current cell to the cell after moving 
	 * @return returns the desired movement, if no movement, returns null 
	 */
	  public static Movement getPlayerMovement(Cell cell)
	  {
		  System.out.println("press 1 to go up: ");
		  System.out.println("press 2 to go down: ");
		  System.out.println("press 3 to go left: ");
		  System.out.println("press 4 to go right: ");
		 
		  String direction = mazeScanner.nextLine();
		  
		  if(direction.equals("1"))
		  {
			  cell.getUp();
			  player.setCurrentCell(cell);
			  return Movement.UP;
		  }
		  if(direction.equals("2"))
		  {
			  cell.getDown();
			  player.setCurrentCell(cell); 
			  return Movement.DOWN;
		  }
		  if(direction.equals("3"))
		  {
			  cell.getLeft();
			  player.setCurrentCell(cell); 
			  return Movement.LEFT;
		  }
		  if(direction.equals("4"))
		  {
			  cell.getRight();
			  player.setCurrentCell(cell); 
		  	  return Movement.RIGHT;
		  }
		   return Movement.NULL;
	  }
	  
	  /**
		 * fills the board with a grid  
		 * loops through the rows in grid and cells in the rows and prints out the current cell as A, the exit cell as E and the aperture cell as S 
		 * prints null cell as n for testing and prints lines at the end of the row and cell for each loop to create indentation as a grid would
		 * @return returns the desired movement, if no movement, returns null 
		 * @param initializes a new grid 
		 * @param initializes a new player for the game test
		 */
	  
	  public static void printBoard(Grid grid, Player player)
	  {
		  for(Row rows : grid.getRows())
		  {
			  for (Cell cells : rows.getCells())
			  {				 
				  if(cells == player.getCurrentCell())
				  {
					  System.out.println("A");
				  }
				  else if(cells.getLeft() == CellComponents.EXIT || cells.getRight() == CellComponents.EXIT || cells.getUp() == CellComponents.EXIT || cells.getDown() == CellComponents.EXIT)
				  {
					  System.out.println("E");
				  }
				  else if(cells.getLeft() == CellComponents.APERTURE || cells.getRight() == CellComponents.APERTURE || cells.getUp() == CellComponents.APERTURE || cells.getDown() == CellComponents.APERTURE || cells.getLeft() == CellComponents.WALL || cells.getRight() == CellComponents.WALL || cells.getUp() == CellComponents.WALL || cells.getDown() == CellComponents.WALL )

				  {
					  System.out.println("S");
					  
				  }
				  else
				  {
					  System.out.println("N");
				  }
				  		  
			  }
			  
			  System.out.println();
			  
		  }
		      System.out.println();  
	   }
    }
