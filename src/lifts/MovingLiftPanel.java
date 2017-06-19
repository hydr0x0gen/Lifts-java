/*
 * LiftsController.java
 *
 */

package lifts;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Hyd
 */
	public class MovingLiftPanel extends JPanel {
   
		private Lift aLift;
   
		/** Creates a new instance of LiftsController */
		public MovingLiftPanel(int posX, int posY) {
      
			aLift = new Lift(posX, posY);
		}
   
		public int getLiftFloor() {
      
			return aLift.getFloor();
		}
   
		public void paintComponent(Graphics g) {
      
			super.paintComponent(g);
			aLift.paint(g);
		}
   
		public int moveLift(int floorCall) {
      
			int currentFloor = aLift.getFloor();
			if(currentFloor < floorCall) {
				for(int i = 0; i < floorCall - currentFloor; i++) {
            
					aLift.moveUp();
					repaint();
					delay();
				}
			}
			else {
				for(int i = 0; i < currentFloor - floorCall; i++) {
					
					aLift.moveDown();
					repaint();
					delay();
				}
			}
			return aLift.getFloor();
		}
   
		public void delay() {
			try {
				Thread.sleep(100);
			}
			catch(Exception e) {
				System.exit(0);
			}
		}
   
	}
