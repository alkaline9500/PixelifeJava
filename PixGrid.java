import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * PixGrid Class
 * Hold Pix objects and handles movement
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class PixGrid
{
	private BufferedImage canvas;
	private Pix[][] grid;

	/**
	 * Constructs a PixGrid with size 640x480
	 */
	public PixGrid()
	{
		// Defaults to 640x480
		grid = new Pix[640][480];
	}

	/**
	 * Constructs a PixGrid with size and 10 Pix objects
	 * @param xsize width
	 * @param ysize height
	 */
	public PixGrid(int xsize, int ysize)
	{
		grid = new Pix[xsize][ysize];
		generate_blank_world();
	}

	/**
	 * Constructs a PixGrid with size and n Pix objects
	 * @param xsize width
	 * @param ysize height
	 * @param n number of Pix objects to add
	 */
	public PixGrid(int xsize, int ysize, int n)
	{
		grid = new Pix[xsize][ysize];
		generate_blank_world();
	}

	/**
	 * Fills grid with white Pix of a certain type
	 */
	public void generate_blank_world()
	{
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				grid[i][j] = new Pix(255,255,255);
			}
		}
	}

// <<<<<<< HEAD
// 	/**
// 	 * Creates a number of random-location Pix of a certain type
// 	 * @param number number of Pix objects to create
// 	 */
// 	public void generate_world(int number)
// 	{
// 		for(int i = 0; i < number; i ++)
// 		{
// 			grid[(int)(Math.random() * grid.length)][(int)(Math.random() * grid[0].length)] = new PulsePix();
// 		}

// 	}

// =======
// >>>>>>> e1f460e674cfa724fd2c081b6fa5e59ab85077cf
	/**
	 * Returns the grid
	 * @return grid
	 */
	public Pix[][] getGrid()
	{
		return grid;
	}

// <<<<<<< HEAD
// 	/**
// 	 * Transitions a Pix from one location to another
// 	 * If the Pix is white, the Pix is moved. Otherwise, one Pix interacts with the other
//  	 * @param ix inital x location
// 	 * @param ix inital y location
// 	 * @param x ending x location
// 	 * @param y ending y location
// 	 */
// 	public void trans(int ix, int iy, int x, int y)
// 	{
// 		// Didn't try to move out of bounds
// 		if (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length))
// 		{
// 			if (grid[x][y].isWhite())
// 			{
// 				// If trans location is white, move Pix
// 				movePixel(ix, iy, x, y);
// 			}
// 			else
// 			{
// 				// Otherwise interact with given location
// 				grid[ix][iy].interact(grid[x][y]);
// 			}


// 		}
// 	}

// =======
// >>>>>>> e1f460e674cfa724fd2c081b6fa5e59ab85077cf
	/**
	 * Loops through all non-white Pix and transitions them in a random direction (N S E W)
	 */
	public void update()
	{
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				if( !grid[i][j].isWhite() )
				{
// <<<<<<< HEAD
// 					int direction = (int)(Math.random() * 4);
// 					switch(direction)
// 					{
// 						case 0:
// 							trans(i,j,i+1,j);
// 							break;
// 						case 1:
// 							trans(i,j,i,j+1);
// 							break;
// 						case 2:
// 							trans(i,j,i-1,j);
// 							break;
// 						case 3:
// 							trans(i,j,i,j-1);
// 							break;
// 						default:
// 							break;
// 					}
// =======
					grid[i][j].update(grid, i , j );
// >>>>>>> e1f460e674cfa724fd2c081b6fa5e59ab85077cf
				}
			}
		}
	}

	/**
	 * Returns a String representation of a PixGrid
	 * @return PixGrid String representation
	 */
	public String toString()
	{
		String new_string = "";
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				new_string += "(" + grid[i][j] + ") ";			
			}
			new_string += "\n";
		}
		return new_string;
	}
}