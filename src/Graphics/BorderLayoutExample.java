package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BorderLayoutExample();
	}
	BorderLayoutExample(){
		JFrame window = new JFrame("BorderLayoutExample");
		window.setSize(900,700);
		window.setLocationRelativeTo(null);
		
		JPanel panelW = new JPanel();
		panelW.setBackground(Color.ORANGE);
		panelW.add(new JLabel("West Panel"));
		window.add(panelW,BorderLayout.WEST);
		
		JPanel panelN = new JPanel();
		panelN.setBackground(Color.BLUE);
		panelN.add(new JLabel("North Panel"));
		window.add(panelN,BorderLayout.NORTH);
		
		JPanel panelE = new JPanel();
		panelE.setBackground(Color.RED);
		panelE.setLayout(new GridLayout(3,2,2,2));
		for(int i=0;i<6;i++) {
			panelE.add(new JButton(""+i));
		}
		window.add(panelE,BorderLayout.EAST);
		
		JPanel panelS = new JPanel();
		panelS.add(new JLabel("South Panel"));
		panelS.setBackground(Color.GREEN);
		window.add(panelS,BorderLayout.SOUTH);
		
		JPanel panelC = new JPanel();
		panelC.add(new JLabel("Center Panel"));
		panelC.setBackground(Color.YELLOW);
		window.add(panelC,BorderLayout.CENTER);


		
		window.setVisible(true);
		
		
	}
}
