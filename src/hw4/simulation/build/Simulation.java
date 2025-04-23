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
	     
	   Scanner mazeScanner = new Scanner(System.in);

public static void main(String[] args) 
    {
	 
	game = new Game(5);
    game.setUpGame(5);
	grid = game.getGrid();// initialize a grid
			
	Row userRow = grid.getRows().get(0);
	Cell cell = userRow.getCells().get(0);
		
	Player player = new Player(userRow, cell);
		
	fillBoard(grid, player);
		
    }  
	  public Movement getPlayerMovement()
	  {
		  System.out.println("press 1 to go up");
		  System.out.println("press 2 to go down");
		  System.out.println("press 3 to go left");
		  System.out.println("press 4 to go right");
		 
		  String direction = mazeScanner.nextLine();
		  
		  //may have to return cell.getComponent 
		  
		  if(direction.equals("1"))
		  {
			  return Movement.UP;
		  }
		  if(direction.equals("2"))
		  {
			  return Movement.DOWN;
		  }
		  if(direction.equals("3"))
		  {
			  return Movement.LEFT;
		  }
		  if(direction.equals("4"))
		  {
		  	  return Movement.RIGHT;
		  }
		   return Movement.NULL;
	  }
	  
	  public static void fillBoard(Grid grid, Player player)
	  {
		  for(Row rows : grid.getRows())
		  {
			  for (Cell cells : rows.getCells())
			  {
				  System.out.print("[" + cells.getLeft() + ", " + cells.getRight() + ", " + cells.getUp() + ", " + cells.getDown() + "] ");
				  if(cells == player.getCurrentCell())
				  {
					  System.out.println("A");
				  }
				  else if(cells.getLeft() == CellComponents.EXIT && cells.getRight() == CellComponents.EXIT && cells.getUp() == CellComponents.EXIT && cells.getDown() == CellComponents.EXIT)
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
		  
	  }
}


