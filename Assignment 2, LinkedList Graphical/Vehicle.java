import java.awt.geom.Ellipse2D ;
import java.awt.Color ;
import java.awt.Rectangle ;
import java.awt.Graphics2D ;
/**
 * Superclass of various vehicles, like car and truck
 * @author Semir
 *
 */
public class Vehicle 
{
	//Instance variable 
	private int x, y;//Top left corner of bounding box
	private int width; //The width of the bounding box
	private int height;//The height of the bounding box
	private Rectangle boundingBox; //The boudning box
	
	/**
	 * Constructs the Vehicle by setting the instance variables
	 * @param x position of left edge of bounding box
	 * @param y	position of top edge of bounding box
	 * @param w	the width of the bounding box
	 * @param h	the height of the bounding box
	 */
	public Vehicle(int x, int y, int w, int h)
	{
		this.x=x;
		this.y=y;
		width = w;
		height = h;
		boundingBox = new Rectangle(x,y,width,height);
		//System.out.println("Cordinates pressed: "+ x +","+ y);
	}

	/**
	 * Checks if the x,y position is inside the bounding box
	 * @param x the x-coordinate to test
	 * @param y the y-coordinate to test
	 * @return true if(x,y) is inside the bounding box, else false
	 */
	public boolean contains(int x, int y)
	{
		return (boundingBox.contains(x,y));
	}
	/**
	 * Draws a default shape for the vehicle
	 * @param g2 the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		Ellipse2D.Double oval = new Ellipse2D.Double(x, y, width, height) ;
		g2.setColor(Color.yellow) ;
		g2.fill(oval) ;
		g2.setColor(Color.BLUE);
		g2.draw(boundingBox);
	}
	
	/**
	 * Sets the new x,y coordinates
	 * @param newX
	 * @param newY
	 */
	public void setXY(int newX, int newY)
	{
		x=newX; 
		y=newY;
		boundingBox = new Rectangle(x,y,width,height);
	}
	/**
	 * Sets the new x coordinates		
	 * @param newX
	 */
	public void setX(int newX)
	{
		x += newX;
		boundingBox = new Rectangle(x,y,width,height);
	}
	/**
	 * Retrieve the coordinate of x 
	 * @return x
	 */
	public int getX()
	{
		return x;
	}
	/**
	 * Sets the new y coordinates
	 * @param newY
	 */
	public void setY(int newY)
	{
		y+=newY;
		boundingBox = new Rectangle(x,y,width,height);
	}
	/**
	 * Retrieve the coordinate of y
	 * @return y
	 */
	public int getY()
	{
		return y;
	}
	/**
	 * Retrieve the coordinate of width
	 * @return width
	 */
	public int getWidth()
	{
		return width;
	}
	/**
	 * Retrieve the coordinate of height
	 * @return height
	 */
	public int getHeight()
	{
		return height;
	}
}
