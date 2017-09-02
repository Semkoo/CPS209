import javax.swing.* ;

import java.awt.Color;
import java.awt.Graphics ;
import java.awt.Graphics2D ;
import java.awt.event.MouseEvent ;
import java.awt.event.MouseAdapter ;
import java.awt.event.MouseMotionListener ;
import java.util.LinkedList;
/**
 * Screen is where all its all method are calculated as-well as drawn it contains LinkedList with all other instance varaibles
 * @author Semir
 *
 */
public class Screen extends JPanel 
{
	//Instance variable 
	private LinkedList<Vehicle> vehicle; //Initializing a LinkedList with Vehicle as an object where all the method will be called later
	private Vehicle selected; //This allows to select the object when mouse motion is used 
	
	private int positionX, positionY, width, height;//Initializing all the varaible which will be used later in the constructor
	private int xTemp, yTemp;//Temporally variables
	private int count; //Initializing count
	
	private Car car; //Creating car object
	private Truck truck; //Creating truck object
	/**
	 * Constructor of screen
	 */
	public Screen()
	{
		vehicle = new LinkedList<Vehicle>(); //Finishing up the initializing
		/**
		 * Using MouseAdapter from the Java's API to allow to catch user's input such a mouse when it's been pressed 
		 */
		class MyListener extends MouseAdapter
		{
			public void mousePressed(MouseEvent event)
			{
				drawVehicle(event);//Draw out the vehicles when the mouse points have been clicked by the user's input
				for(Vehicle select : vehicle) 
				{
					if(select.contains(event.getX(), event.getY()))
					{
						selected = select; //If the object contains mouse points set selected = select
					}
				}
			}
			public void mouseReleased(MouseEvent event)
			{
				selected.setXY(event.getX(), event.getY());//Move the selcted object to the point when the mouse button has been released
			}
		}
		addMouseListener(new MyListener()); //Add the mouse listener 
		/**
		 * Using MouseMostionListener from the Java's API will allow us to move the object with the Frame 
		 */
		class MyMouseListener implements MouseMotionListener
		{
			public void mouseDragged(MouseEvent event) {
				if(selected != null){
					xTemp = event.getX(); //Update xTemp when the mouse has been draged in x-cordinates
					yTemp = event.getY(); //Update xTemp when the mouse has been draged in y-cordinates
						selected.setXY(xTemp, yTemp); //Update the setXY method from Vehicle class
						repaint(); //Update the frame
				}
			}
			//Does not require 
			public void mouseMoved(MouseEvent event) {}
		}
		//MouseMotionListener listener = new MyMouseListener() ;
		addMouseMotionListener(new MyMouseListener()/*or listener*/); //Add the motion into the class 
		
	}
	/**
	 * Draws out the object and added to vehicle array list 
	 * @param event the mouse event
	 */
	public void drawVehicle(MouseEvent event)
	{
		positionX = event.getX(); //Update the position by acquiring the points from user when clicked
		positionY = event.getY();//Update the position by acquiring the points from user when clicked
		width = 65; //Set the width to 50
		height = 35; //Set the height to 50
		if(vehicle.size()==0) //If the linked-list is empty add the truck object as the first 
		{
			 truck = new Truck(positionX, positionY, width, height);
			 vehicle.add(truck);
			 repaint();
		}
		else if(vehicle.size() <=5) //Add car object up to 5
		{
			 car = new Car(positionX,positionY, width, height);
			 vehicle.add(car);
			 repaint();
			 
		}
	}
	/**	
	 * Clears the Linked-list by removing all of its objects
	 */
	public void clean()
	{
		vehicle.clear();
		repaint();
	}
	
	/**
	 * Changes the coordinates of truck by moving right 
	 * @param newX will change by incrementing
	 */
	public void moveRight(int newX)
	{
		if(vehicle.size() > 1){
			vehicle.get(0).setX(newX);
			repaint();
		}
	}
	/**
	 * Changes the coordinates of truck by moving left
	 * @param newX will change by decrementing
	 */
	public void moveLeft(int newX)
	{
		if(vehicle.size() > 1){
			vehicle.get(0).setX(newX);
			repaint();
		}
	}
	/**
	 * Changes the coordinates of truck by moving up
	 * @param newY will change by decrementing
	 */
	public void moveUp(int newY)
	{
		if(vehicle.size() > 1){
			vehicle.get(0).setY(newY);
			repaint();
		}
	}
	/**
	 * Changes the coordinates of truck by moving down
	 * @param newY will change by incrementing 
	 */
	public void moveDown(int newY)
	{
		if(vehicle.size() > 1){
			vehicle.get(0).setY(newY);
			repaint();
		}
	}	
	/**
	 * Change the coordinates of truck by moving the object into random positon when random method is called
	 * @param newX will change the positon coroodinates by applying the random generation from Frame class
	 * @param newY will change the positon coroodinates by applying the random generation from Frame class
	 */
	public void moveRandom(int newX, int newY)
	{
		if(vehicle.size() > 1){
			vehicle.get(0).setXY(newX, newY);
			repaint();
		}
	}
	/**
	 * Add first is temporarily not working
	 */
	public void addFirst()
	{
		
	}	
	public void addLast()
	{
		
	}
	/**
	 * Remove the first object of the list
	 */
	public void removeFirst()
	{
		if(vehicle.size() > 1){
			vehicle.remove(1);
			repaint();
		}
	}
	/**
	 * Remove the last object of the list
	 */
	public void removeLast()
	{
		if(vehicle.size() > 1){
		vehicle.removeLast();
		repaint();
		}
	}
	
	/**
	 * Retrieve count of how many car objects have been printed
	 * @return count
	 */
	public int getCount()
	{
		if(vehicle.iterator() != null)
		{
			count++;
		}
		return count;
	}
	
	/**
	 * Draws out the objects
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g ;
		for (Vehicle object : vehicle) 
		{
			
			if(object.equals(selected))
				g2.setColor(Color.red);
			else
				g2.setColor(Color.black);
			
			object.draw(g2);				 
		}

	    }
}
