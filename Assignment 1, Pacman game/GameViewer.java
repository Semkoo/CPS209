import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
/**
 * The GameViewer is the main class.
 * @author Semir
 *
 */
public class GameViewer
{
	//Creating the Width and Height to be static so we easily retrive it from other classes.
	public static final int WIDTH = 800;
	public static final int HEIGHT= 600;
	//As well as the JFrame
	public static JFrame frame;
	
	public static void main(String args[])
	{
		
		frame = new JFrame();
		
		//Creating an object to be applied in the frame.
		GameComponent comp = new GameComponent();
		frame.setFocusable(true);//Make the keyboard function work[beta-testing]
		frame.add(comp, BorderLayout.CENTER);
		frame.setTitle("| Pacman | @SEMIR");
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
	}
	/**
	 * Retrieve the current frame's width.
	 * @return
	 */
	public static int getFrameWidth()
	{
		return frame.getWidth();
	}
	/**
	 * Retrieve the current frame's height.
	 * @return
	 */
	public static int getFrameHeight()
	{
		return frame.getHeight();
	}
	
}