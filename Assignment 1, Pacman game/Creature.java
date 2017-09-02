import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.geom.Ellipse2D;
/**
 * This Creature.java file is the superclass of its subclass: Predator.java, Prey.java, FastPrey.java.
 * This class implements MoveableShape.java where it inherits all it's methods
 * In this class it contains all of its position,width,height, etc;
 * @author Semir
 * 
 */
//Creature class and implements all of its methods from MoveableShape
public class Creature implements MoveableShape 
{
		//Instance Variables
	    private int xLeft, yTop ; //It's Position top left corner of the shape.
	    private int width ; //the width/size of the shape.
	    private int height ; //the height/size of the shape.
	    /**
	     * This is the frame for example which essential helps me to understand which direction for the shape to move
	     *    __ 2 __       _
	     *   |       |		 |
	     * -1|       |1		 |	This box is a frame.
	     *   |__   __|		_|
	     *      -2
	     *  1  - Will indicate the shape is moving 'Right'.
	     *  2  - Will indicate the shape is moving 'Up'. 
	     *  -1 - Will indicate the shape is moving 'Left'.
	     *  -2 - Will indicate the shape is moving 'Down'.
	     */
		private int movingDirection = 1;//Init the shape to move towards right
	    private Color color;//Allows us to change the color in the draw() method
	    private double deltaX;//Changes the position of the xLeft.
	    private double deltaY;//Changes the position of the yTop.
	    private double speed;//Changes the speed of xLeft and yTop. 
	    private boolean alive;//A boolean function to check if the shape would be alive or dead.
		  
	    private Ellipse2D.Double oval;//Create an ellipse shape and would allow us to call this variable later in the draw() method.
	    
	/**
	 * Constructor and initializing all the variables. 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param d
	 * @param e
	 * @param s
	 * @param c
	 */
	public Creature(int x, int y, int w, int h, int d, int e, int s, Color c)
	{
		//Initializing all the variables which are to be assigned from it subclass
		xLeft = x ; yTop = y ; width = w ; height = h ;
		//Creating an shape called oval from the subclass 
		oval = new Ellipse2D.Double(xLeft, yTop, width, height);
		deltaX = d; //Change of direction for X
		deltaY = e; //Change of direction for Y
		speed =s; //It's speed
		color = c; //Change of color
		
		alive = true; //Initializing the object be true/alive.
		
		updateMovement(); //Calling the method to update its movement over time.
	}
	/**
	 * @Override the method from the MoveableShape
	 */
	public boolean collide(MoveableShape other)
	{
		Creature o = (Creature) other; //Casting
		return  oval.intersects(o.xLeft,o.yTop, o.width, o.height);//Returns true or false if it does intersect with other shapes
	}
	/**
	 * Checks the boundary is the object pass the frame's width/height then reverse the direction.
	 */
	public void checkBoundary()
	{
		if(xLeft + width >= GameViewer.getFrameWidth())//Shape's size in comparison with the updated frame width.
		{
			movingDirection = -1;
			updateMovement();
		}
		else if(xLeft <= 0)//Shape's size in comparison with the updated frame width.
		{
			movingDirection = 1;
			updateMovement();
		}
		
		if(yTop <= 0)//Shape's size in comparison with the updated frame height.
		{
			movingDirection = -2;
			updateMovement();
		}
		else if(yTop + height >= GameViewer.getFrameHeight())//Shape's size in comparison with the updated frame width.
		{
			movingDirection = 2;
			updateMovement();
		}
		
	}
	/**
	 * @Override move method from the MoveableShape
	 */
	public void move() 
	{	
		checkBoundary();//Checks if does not pass the boundary of the frame.
		xLeft += deltaX*speed;
		yTop += deltaY*speed;
		oval.setFrame(xLeft, yTop, width, height);//Assigns the new object to new set of coordinates
	}
	
	/**
	 * @Override the draw method from MoveableShape.java
	 */
	public void draw(Graphics2D g2) 
    {
		//g2.draw(oval); //Testing phase.
		g2.setColor(color); //Taking the color that has been assigned.
		g2.fill(oval); //Draw and fill the shape.
	}
	/**
	 * This method assigns the boolean alive variable to false which cause the in the GameComponent to draw if it exists.
	 */
	public void delete()
	{
		alive=false;
		
	}
	/**
	 * Retrieves the current boolean statement.
	 * @return
	 */
	public boolean checkAlive()
	{
		return alive;
	}
	/**
	 * Update the movements of the object with switch loop
	 */
	public void updateMovement()
	{
		switch (movingDirection)
		{
			//moving right
			case 1:
			{
				deltaX = 1;
				deltaY = 0;
				break;
			}
			//moving up
			case 2:
			{
				deltaX = 0;
				deltaY = -1;
				break;
			}
			//moving left
			case -1:
			{
				deltaX = -1;
				deltaY = 0;
				break;
			}
			//moving down
			case -2:
			{
				deltaX = 0;
				deltaY = 1;
				break;
			}
		}
	}
	/**
	 * Set the movement of direction which is applied by the subclass
	 * @param dir
	 */
	public void setMovementDirection(int dir)
	{
		movingDirection = dir;
		updateMovement();
	}
	/**
	 * Retrieve the movement direction 
	 * @return
	 */
	public int getMovementDirection()
	{
		return movingDirection;
	}
}
