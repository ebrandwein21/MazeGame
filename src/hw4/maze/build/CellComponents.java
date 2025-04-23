package hw4.maze.build;

import java.util.Random;
/**
 * an enum that contains the possible cell components. Aperture which allows the player to move through, wall that blocks player from moving and exit to exit game 
 */
public enum CellComponents{
	
		APERTURE,
		WALL,
		EXIT;
	
	//creates new random component 
	private static final Random RANDOM = new Random();

	/**
	 * returns a random selected cell component between APerture and Wall from a list of the components using a random number generated
	 * @return randomly selected component 
	 */
    public static CellComponents randomComponent() 
    {
        CellComponents[] cellComponents = values();
        return cellComponents[RANDOM.nextInt(2)];
    }
  }
	
