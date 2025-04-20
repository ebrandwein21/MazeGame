package hw4.maze.build;

import java.util.Random;

public enum CellComponents{
	
		APERTURE,
		WALL,
		EXIT;
	
	private static final Random RANDOM = new Random();

    public static CellComponents randomComponent()  {
        CellComponents[] cellComponents = values();
        return cellComponents[RANDOM.nextInt(2)];
    }
   
	}
	
