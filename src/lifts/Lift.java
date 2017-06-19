/*
 * Lift.java
 *
 */

package lifts;
import java.awt.*;
import javax.swing.*;
import java.awt.Font.*;

/**
 *
 * @author Hyd
 */
	public class Lift {
		private int floor;
		private final int WIDTH = 50;
		private final int HEIGHT = 70;
		private final int CHANGE = 70;
		private int positionX, positionY;
   
   /** Creates a new instance of Lift */
		public Lift(int posX, int posY) {
			
			floor = 1;
			positionX = posX;
			positionY = posY;
		}
   
		public int getFloor() {
			
			return floor;
		}
   
		public void paint(Graphics g) {
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(positionX, positionY, WIDTH, HEIGHT);
			Font aFont = new Font("Serif", Font.BOLD, 14);
			g.setFont(aFont);
			g.drawString(("" + floor), positionX - 15, positionY + 10);
		}
   
		public void moveUp() {
			
			positionY = positionY - CHANGE;
			floor++;
		}
   
		public void moveDown() {
			positionY = positionY + CHANGE;
			floor--;
		}
	}
