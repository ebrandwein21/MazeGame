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
	
	
	public Cell(CellComponents left, CellComponents right,CellComponents up, CellComponents down )
	{
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
		
	}
	
	public Cell()
	{
		this.left = null;
		this.right = null; 
		this.up = null;
		this.down = null;
	}
	
	
	public Cell(Cell upCell, Cell downCell, Cell leftCell, Cell rightCell)
	{
		this.upCell = upCell;
		this.downCell = downCell;
		this.leftCell = leftCell; 
		this.rightCell = rightCell; 
	}
	
	public void assertsEquals()
	{
		
	}
	
	public CellComponents getLeft()
	{
		return left;
	}
 
		
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
	
	public CellComponents getRight()
	{
		return right;
	}
	
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

	
	
	public CellComponents getUp()
	{
		return up;
	}
	
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
	
	public CellComponents getDown()
	{
		return down;
	}

	
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
	
	public Cell getUpCell()
	{
		return upCell;
	}
	
	public void setUpCell(Cell upCell)
	{
		this.upCell = upCell;
	}
	
	public Cell getDownCell()
	{
		return downCell;
	}
	
	public void setDownCell(Cell downCell)
	{
		this.downCell = downCell;
	}
	
	public Cell getLeftCell()
	{
		return leftCell;
	}
	
	public void setLeftCell(Cell leftCell)
	{
		this.leftCell = leftCell;
	}
	
	public Cell getRightCell()
	{
		return rightCell;
	}
	
	public void setRightCell(Cell rightCell)
	{
		this.rightCell = rightCell;
	}
	
	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
	
	
}