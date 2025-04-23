package hw4.maze.build;

public class Cell{
	
	//methods are tentative and may need parameters, different access levels etc 
	
	private CellComponents up;
	private CellComponents down;
	private CellComponents left;
	private CellComponents right;
	private Cell upCell;
	private Cell downCell;
	private Cell leftCell;
	private Cell rightCell;

	/**
	 * Constructor that initializes Cellcomponent directions left, right, up and down and then makes them equal to the current instance of themselves
	 * @param: the left cellComponent
	 * @param the right cellComponent
	 * @param the up cellComponent
	 * @param the down cellComponent
	 */
	public Cell(CellComponents left, CellComponents right,CellComponents up, CellComponents down )
	{
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;	
	}
	
	/**
	 * empty constructor that declares left, right, up and down to null, used for the get random component method
	 */
	public Cell()
	{
		this.left = null;
		this.right = null; 
		this.up = null;
		this.down = null;
	}
	
	/**
	 * Constructor that initializes directions left, right, up and down and then makes them equal to the current instance of themselves of type cell rather than type cellComponent so that the current cell can be set
	 * @param: the left cell
	 * @param the right cell
	 * @param the up cell
	 * @param the down cell
	 */
	public Cell(Cell upCell, Cell downCell, Cell leftCell, Cell rightCell)
	{
		this.upCell = upCell;
		this.downCell = downCell;
		this.leftCell = leftCell; 
		this.rightCell = rightCell; 
	}
	
	/**
	 * method that initializes directions left, right, up and down and then makes them equal to the current instance of themselves of type cell rather than type cellComponent so that the cell neighbors can be set
	 * @param: the left cell neighbor
	 * @param the right cell neighbor
	 * @param the up cell neighbor
	 * @param the down cell neighbor 
	 */
	public void setNeighbors(Cell up, Cell down, Cell left, Cell right) {
	        this.upCell = up;
	        this.downCell = down;
	        this.leftCell = left;
	        this.rightCell = right;
	}
	/**
	 * Constructor that gets the left cellComponent and returns it so it can be set
	 * @return: left
	 */
     public CellComponents getLeft()
	{
		return left;
	}
    /**
	 * sets the left CellComponent and checks if it is null before setting it as an instance of itself
	 * if null, left CellComponent is set as wall 
	 * param: left
	 */
	public void setLeft(CellComponents left)
	{
		if(left != null)
		{
			this.left = left;
		}
		else
		{
			this.left = CellComponents.WALL;
		}
	}
	
	/**
	 * gets the right cellComponent and returns it so it can be set
	 * @return: right
	 */
	public CellComponents getRight()
	{
		return right;
	}
	
	/**
	 * sets the right CellComponent and checks if it is null before setting it as an instance of itself
	 * if null, right CellComponent is set as wall 
	 * param: right
	 */
	public void setRight(CellComponents right)
	{
		if(right != null)
		{
			this.right = right;
		}
		else
		{
			this.right = CellComponents.WALL;
		}
	}

	/**
	 *  gets the up cellComponent and returns it so it can be set
	 * @return: up
	 */
	public CellComponents getUp()
	{
		return up;
	}
	
	/**
	 * sets the up CellComponent and checks if it is null before setting it as an instance of itself
	 * if null, up CellComponent is set as wall 
	 * param: up
	 */
	public void setUp(CellComponents up)
	{
		if(up != null)
		{
			this.up = up;
		}	
		else
		{
			this.up = CellComponents.WALL;
		}
	}
	
	/**
	 *  gets the down cellComponent and returns it so it can be set
	 * @return: down
	 */
	public CellComponents getDown()
	{
		return down;
	}
	
	/**
	 * sets the down CellComponent and checks if it is null before setting it as an instance of itself
	 * if null, down CellComponent is set as wall 
	 * param: down
	 */
    public void setDown(CellComponents down)
	{
		if(down != null)
		{
			this.down = down;
		}	
		else
		{
			this.down = CellComponents.WALL;
		}
	}
	
	/**
	 *  gets the up cell and returns it so it can be set
	 * @return: upCell
	 */
	public Cell getUpCell()
	{
		return upCell;
	}
	
	/**
	 *  sets the Cell version of the up cell to an instance of itself
	 * param: upCell
	 */
	public void setUpCell(Cell upCell)
	{
		this.upCell = upCell;
	}
	
	/**
	 *  gets the down cell and returns it so it can be set
	 * @return: downCell
	 */
	public Cell getDownCell()
	{
		return downCell;
	}
	/**
	 *  sets the cell version of the down cell to an instance of itself
	 * param: downCell
	 */
	public void setDownCell(Cell downCell)
	{
		this.downCell = downCell;
	}
	
	/**
	 *  gets the left cell and returns it so it can be set
	 * @return: leftCell
	 */
	public Cell getLeftCell()
	{
		return leftCell;
	}
	/**
	 *  sets the Cell version of the left cell to an instance of itself
	 * param: leftCell
	 */
	public void setLeftCell(Cell leftCell)
	{
		this.leftCell = leftCell;
	}
	
	/**
	 *  gets the right cell and returns it so it can be set
	 * @return: rightCell
	 */
	public Cell getRightCell()
	{
		return rightCell;
	}
	
	/**
	 *  sets the Cell version of the right cell to an instance of itself
	 * param: rightCell
	 */
	public void setRightCell(Cell rightCell)
	{
		this.rightCell = rightCell;
	}
	/**
	 * @return returns a to string of the cell components by direction 
	 */
	
	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
}