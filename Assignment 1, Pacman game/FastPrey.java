import java.awt.Color;
import java.awt.Graphics2D;



public class FastPrey extends Creature
{	
	/**
	 * Takes all the information in the creature
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public FastPrey(int x,int y, int w, int h)
	{
		super(x,y,w,h, 1, 1, 3, Color.green);
	}
	/**
	 * Takes all the information from move method from the super class Creature
	 */
	public void move()
	{
		super.move();
	}
	/**
	 * Takes all the information from draw method from the super class Creature
	 */
	public void draw(Graphics2D g2)
	{
		super.draw(g2);
	}
}
