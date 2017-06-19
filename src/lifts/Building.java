/*
 * Building.java
 *
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package lifts;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
/**
 *
 * @author Hyd
 */

	public class Building extends JFrame {
		public MovingLiftPanel mlp1, mlp2;
		private JPanel westPanel, eastPanel, centerPanel;
		private JPanel[] midPanels;
		private JButton[] callBut;
		private JLabel[] floorLabels;
		private int floorCalling;
		private LiftControlPanel lcp1, lcp2;
   
		public Building() {
      
			setSize(300, 740);
			setLocation(200, 100);
			setTitle("Lifts");
			setLayout(new GridLayout(1, 3));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
			mlp1 = new MovingLiftPanel(20, (getSize().height - 110));
			mlp2 = new MovingLiftPanel(20, (getSize().height - 110));
      
			westPanel = new JPanel();
			westPanel.setBorder(new EtchedBorder());
			westPanel.setLayout(new GridLayout(1, 1));
      
			eastPanel = new JPanel();
			eastPanel.setBorder(new EtchedBorder());
			eastPanel.setLayout(new GridLayout(1, 1));
      
			centerPanel = new JPanel(new GridLayout(10,1));
			centerPanel.setBorder(new EtchedBorder());
			centerPanel.setBackground(Color.LIGHT_GRAY);
			westPanel.add(mlp1);
			eastPanel.add(mlp2);
			add(westPanel);
			add(centerPanel);
			add(eastPanel);
      
			midPanels = new JPanel[10];
			callBut = new JButton[10];
			floorLabels = new JLabel[10];
			
			for(int i = 0; i < 10; i++) {
		   
				midPanels[i] = new JPanel();
				midPanels[i].setBorder(new EtchedBorder());
				callBut[i] = new JButton("Call lift");
				floorLabels[i] = new JLabel("Floor " + (10-i));
				midPanels[i].add(floorLabels[i]);
				midPanels[i].add(callBut[i]);
				centerPanel.add(midPanels[i]);
         
				callBut[i].addActionListener(new LiftButtonListener());
			}
      
			lcp1 = new LiftControlPanel("Lift 1", 200, 840, mlp1);
			lcp1.setVisible(true);
      
			lcp2 = new LiftControlPanel("Lift 2", 350, 840, mlp2);
			lcp2.setVisible(true);
			}
   
		private void callLift() {
      
			if((Math.abs(floorCalling - mlp1.getLiftFloor())) <= (Math.abs(floorCalling - mlp2.getLiftFloor()))) {
				mlp1.moveLift(floorCalling);
			}
			else {
				mlp2.moveLift(floorCalling);
			}
		}
   
		private class LiftButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent a)
			{
				Object buttonPressed = a.getSource();
				for(int i = 0; i < 10; i++) {
   				
					if(buttonPressed.equals(callBut[i])) {
						floorCalling = (10 - i);
						callLift();
					}
				}
			}//end of method actionPerformed
		}//end of inner class LiftButtonListener
	}
