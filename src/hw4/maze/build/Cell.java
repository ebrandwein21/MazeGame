package hw4.maze.build;

public class Cell{
	
	//methods are tentative and may need parameters, different access levels etc 
	
	private CellComponents up;
	private CellComponents down;
	private CellComponents left;
	private CellComponents right;
	
	public Cell(CellComponents left, CellComponents right,CellComponents up, CellComponents down )
	{
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
		
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
			left = CellComponents.WALL;
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
			right = CellComponents.WALL;
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
			up = CellComponents.WALL;
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
			down = CellComponents.WALL;
		}
	}
	
	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
	
	
}