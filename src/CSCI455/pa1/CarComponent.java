package CSCI455.pa1;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
   
   Note: this version modified from textbook version.  It is instrumented
   so as you run the program it indicates in the console window every time 
   paintComponent gets called.
*/
public class CarComponent extends JComponent
{  

   // added instance variable for instrumentation
   private int callCount;
   
   // added constructor for instrumentation 
   // Note: for old version without instance variables an empty default 
   // constructor didn't need to be defined explicitly (see:
   // https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
   // for rules about this)
   public CarComponent() {
      callCount = 0;
   }
   
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      
           
      // the following two lines are for instrumentation
      callCount++;
      System.out.println("Called paintComponent(" + callCount + ")");


      Car car1 = new Car(0, 0);
      
      int x = getWidth() - 60;
      int y = getHeight() - 30;

      Car car2 = new Car(x, y);

      car1.draw(g2);
      car2.draw(g2);      
   }
}
