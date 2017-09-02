import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
/**
 * This is a Predator class that inheritance all of the methods and shapes from the super class Creature
 * In class it contains the a move method that allows the object to change its direction
 * @author Semir
 *
 */
public class Predator extends Creature
{
	/**
	 * Takes all the information in the creature
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public Predator(int x, int y, int w, int h)
	{ 
		super(x,y,w,h, 1, 1, 2, Color.yellow);//direction,direction,speed,color to be yellow
	}
	/**
	 * Takes all the information from move method from the super class Creature
	 */
	public void move() 
	{	
		super.move();
	}	
	/**
	 * Changes the move direction by GameComponent and action class method when clicked with a mouse it goes through to see which direction the predator is going 
	 */
	public void turnRight()
	{
		if(super.getMovementDirection() == 1)
			super.setMovementDirection(-2);
		else if(super.getMovementDirection() == -2)
			super.setMovementDirection(-1);
		else if(super.getMovementDirection() == -1)
			super.setMovementDirection(2);
		else if(super.getMovementDirection() == 2)
			super.setMovementDirection(1);
	}
	/**
	 * Changes the move direction by GameComponent and action class method when clicked with a mouse it goes through to see which direction the predator is going 
	 */
	public void turnLeft()
	{
		if(super.getMovementDirection() == 1)
			super.setMovementDirection(2);
		else if(super.getMovementDirection() == 2)
			super.setMovementDirection(-1);
		else if(super.getMovementDirection() == -1)
			super.setMovementDirection(-2);
		else if(super.getMovementDirection() == -2)
			super.setMovementDirection(1);
	}
	/**
	 * Takes all the information from draw method from the super class Creature
	 */
	public void draw(Graphics2D g2) 
	{
		super.draw(g2);
	
 	}
}
