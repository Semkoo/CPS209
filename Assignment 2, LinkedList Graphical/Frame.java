import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * This class contain the Main method and as-well as the frame 
 * @author Semir
 *
 */
public class Frame extends JFrame
{
	//Instance variable 
	public static final int WIDTH = 500; //Final cant be changed
	public static final int HEIGHT= 500; //Final cant be changed
	private static Screen screen; //Static allows us to use the object with other classes in this file
	private static Random random; //^- Same as above
	
	private static int randomX; //Initilazing radomX varaible to be later called in the methods
	private static int randomY; //Initilazing radomY varaible to be later called in the method 
	public Frame()
	{
		setTitle("A2");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Construct random generator 
		random= new Random();
		// Construct menu      
	    JMenuBar menuBar = new JMenuBar(); 
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		menuBar.add(createEditMenu());
		menuBar.add(createListMenu());
		
		//Screen object initilzed and added to frame
		screen = new Screen();
		add(screen, BorderLayout.CENTER);
		setVisible(true);
		
	}
	//Main method
	public static void main(String[] args)
	{
		Frame frame = new Frame();//Finishing up the object
	}
		 
	   /**
	      Creates the File menu.
	      @return the menu
	   */
	   public static JMenu createFileMenu()
	   {
	      JMenu menu = new JMenu("File");
	      JMenuItem newItem = new JMenuItem("New");
	      ActionListener newListener = new NewItemListener();
	      newItem.addActionListener(newListener);
	      menu.add(newItem);
	   
	      JMenuItem exitItem = new JMenuItem("Exit"); 
	      ActionListener listener = new ExitItemListener();
	      exitItem.addActionListener(listener);
	      menu.add(exitItem);
	      return menu;
	   }	
	   
	   /**
	    * Creating NewItemListener by implementing Java's API ActionLister where it will perform whatever it is in the function
	    */
	   static class  NewItemListener implements ActionListener
		   {
		      public void actionPerformed(ActionEvent event)
		      {
		    	  screen.clean(); 
		      }
		   } 
	   /**
	    * Creating ExitItemListener by implementing Java's API ActionLister where it will perform whatever it is in the function
	    */
	   static class  ExitItemListener implements ActionListener
		   {
		      public void actionPerformed(ActionEvent event)
		      {
		         System.exit(0);
		      }
		   }
	   
	   /**
	    * Creating a new menu called "Edit" as well with its sub-menu "Move"
	    * @return menu
	    */
	   public static JMenu createEditMenu()
	   {
	      JMenu menu = new JMenu("Edit");
	      menu.add(createMoveMenu());
	   
	      JMenuItem RandomItem = new JMenuItem("Randomize"); 
	      ActionListener listener = new RandomItemListener();
	      RandomItem.addActionListener(listener);
	      menu.add(RandomItem);
	      return menu;
	   }
	   /**
	    * Creating RandomItemListener by implementing Java's API ActionLister where it will perform whatever it is in the function
	    */
	   static class  RandomItemListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent event)
	      {
	    	  randomX= random.nextInt(WIDTH-50);
	    	  randomY= random.nextInt(HEIGHT-50);
	    	  screen.moveRandom(randomX, randomY);
	      }
	   } 
	   /**
	    * Creating a sub-menu of move with increments of values
	    * @return menu
	    */
	   //Create a sub-menu as-well Move menu
	   public static JMenu createMoveMenu()
	   {
		   JMenu menu = new JMenu("Move");
		   menu.add(createMoveRItem("Move Right", 10));
		   menu.add(createMoveLItem("Move Left", -10));
		   menu.add(createMoveUItem("Move Up", -10));
		   menu.add(createMoveDItem("Move Down", +10));
		   return menu;
	   }
	   /**
	    * Creating a a sub-menu of Move and naming it Move right down up left for all the following JMenuItem
	    * @param name
	    * @param increment
	    * @return item
	    */
	   public static JMenuItem createMoveRItem(String name, final int increment)
	   {
		   /**
		    * Creating rightItemListener by implementing Java's API ActionLister where it will perform whatever it is in the function
		    */
		   class rightItemListener implements ActionListener
		   {
			public void actionPerformed(ActionEvent arg0) {
				screen.moveRight(increment);
			}
			   
		   }
		   JMenuItem item = new JMenuItem(name);
		   ActionListener listener = new rightItemListener();
		   item.addActionListener(listener);
		   return item;
		   
	   }
	   //Move Left Menu
	   public static JMenuItem createMoveLItem(String name, final int increment)
	   {
		   class rightItemListener implements ActionListener
		   {
			public void actionPerformed(ActionEvent arg0) {
				screen.moveLeft(increment);
			}
		   }
		   JMenuItem item = new JMenuItem(name);
		   ActionListener listener = new rightItemListener();
		   item.addActionListener(listener);
		   return item; 
	   }
	   //Move Up Menu
	   public static JMenuItem createMoveUItem(String name, final int increment)
	   {
		   class rightItemListener implements ActionListener
		   {
			public void actionPerformed(ActionEvent arg0) {
				screen.moveUp(increment);
			}
		   }
		   JMenuItem item = new JMenuItem(name);
		   ActionListener listener = new rightItemListener();
		   item.addActionListener(listener);
		   return item; 
	   }
	   //Move Down Menu
	   public static JMenuItem createMoveDItem(String name, final int increment)
	   {
		   class rightItemListener implements ActionListener
		   {
			public void actionPerformed(ActionEvent arg0) {
				screen.moveDown(increment);
			}
		   }
		   JMenuItem item = new JMenuItem(name);
		   ActionListener listener = new rightItemListener();
		   item.addActionListener(listener);
		   return item; 
	   }
	   
	   /**
	    * Creating  a list menu 
	    * @return menu
	    */
	   public static JMenu createListMenu()
	   {
		      JMenu menu = new JMenu("List");
		      JMenuItem addFirst = new JMenuItem("Add First");
		      menu.add(addFirst);
		   
		      JMenuItem addLast = new JMenuItem("Add Last");
		      menu.add(addLast);
		      
		      JMenuItem rmFirst = new JMenuItem("Remove First");
		      ActionListener rmFirstListener = new RemoveFItemListener();
		      rmFirst.addActionListener(rmFirstListener);
		      menu.add(rmFirst);
		      
		      JMenuItem rmLast = new JMenuItem("Remove Last");
		      ActionListener rmLastListner= new RemoveLItemListener();
		      rmLast.addActionListener(rmLastListner);
		      menu.add(rmLast);
		      
		      return menu;
	   }
	   /**
	    * Creating RemoveFItemListener by implementing Java's API ActionLister where it will perform whatever it is in the function
	    */
	   static class  RemoveFItemListener implements ActionListener
	   {
		public void actionPerformed(ActionEvent arg0) {
			screen.removeFirst();
		}
	   }
	   /**
	    * Creating RemoveLItemListener by implementing Java's API ActionLister where it will perform whatever it is in the function
	    */
	   static class  RemoveLItemListener implements ActionListener
	   {
		public void actionPerformed(ActionEvent arg0) {
			screen.removeLast();
		}
	   }
	   

}
