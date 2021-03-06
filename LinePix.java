/**
 * Class LinePix
 * Pixels that only move in one direction
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */

public class LinePix extends DirectedPix
{
	/*
	 * Prevents line from growing in one frame
	 */
	private boolean examined;

	/**
	 * Constructs a LinePix with a random direction
	 */
	public LinePix()
	{	
		super();
		direction = ((int)(Math.random()*4));
		examined = (direction >= 2);
	}
	/**
	 * Constructs a LinePix with a specific direction and color
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public LinePix(int r, int g, int b, int direction)
	{
		super(r,g,b, direction);
		this.direction = direction;
		examined = (direction >= 2);
	}


	/**
	 * Transitions a Pix from one location to another
	 * If the Pix is white, the Pix is moved.
 	 * @param ix inital x location
	 * @param ix inital y location
	 * @param x ending x location
	 * @param y ending y location
	 */
	public void trans(Pix[][] grid, int ix, int iy, int x, int y)
	{
		// If the Pix has been looked at
		if (examined)
		{
			// Didn't try to move out of bounds
			if (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length))
			{
				// If trans location is white, move Pix
				if (grid[x][y].isWhite())
				{
					Spawner.spawnXY( grid[ix][iy].getClass(), x, y ); 
					grid[x][y].setPix(grid[ix][iy]);
					((DirectedPix)grid[x][y]).setDir(direction);
				}
			}
		}
		else
		{
			examined = true;
		}
	}
}