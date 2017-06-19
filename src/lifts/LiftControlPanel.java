/*
 * LiftControl.java
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package lifts;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Hyd
 */
public class LiftControlPanel extends JFrame {
   
	private JPanel ctrlPnl;
	private JButton[] floorButton;
	private int goToFloor;
	private MovingLiftPanel mlpForLcp;
	/** Creates a new instance of LiftControl */
	public LiftControlPanel(String title, int x, int y, MovingLiftPanel mlp) {
      
		setSize(150, 170);
		setLocation(x, y);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
		ctrlPnl = new JPanel(new GridLayout(5, 2));
		add(ctrlPnl);
      
		floorButton = new JButton[10];
		for(int i = 0; i < 10; i++) {
			floorButton[i] = new JButton ((i+1)+"");
			ctrlPnl.add(floorButton[i]);
         
			floorButton[i].addActionListener(new LiftButtonListener());
		}
		mlpForLcp = mlp;
   }
   
   private class LiftButtonListener implements ActionListener {
	   public void actionPerformed(ActionEvent a) {
		   Object buttonPressed = a.getSource();
		   for(int i = 0; i < 10; i++) {
			   if(buttonPressed.equals(floorButton[i])) {
				   goToFloor = (i+1);
				   mlpForLcp.moveLift(goToFloor);
            }
         }
      }//end of method actionPerformed
   }//end of inner class LiftButtonListener
   
}
