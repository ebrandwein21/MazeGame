package hw4.maze.build;

public class CellComponents{

    public CellComponents Apperture;
    public CellComponents Exit;
    public CellComponents Wall;
    
    
    public CellComponents getApperture() {
		return Apperture;
 	}
	
	public void setSize(CellComponents Apperture) {
		this.Apperture = Apperture;
	}
	
	 
    public CellComponents getExit() {
		return Exit;
 	}
	
	public void setExit(CellComponents Exit) {
		this.Exit = Exit;
	}
	
	 
    public CellComponents getWall() {
		return Wall;
 	}
	
	public void setWall(CellComponents Wall) {
		this.Wall = Wall;
	}
	
}