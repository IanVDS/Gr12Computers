package Graphics;
/* Ian Van den Steen
 * Oct. 4, 2021
 * Mr. Harwood
 */
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class GridLayout1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridLayout1();
	}
	
	JFrame window;
	GridLayout1(){
		window = new JFrame("Flow Layout");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setLayout(new GridLayout(3,5));
	
		for(int i=0;i<10;i++) {
			panel.add(new JButton("Hello"));
		}
		window.add(panel);	
		
		
		//the last thing you do (normally)
		window.setVisible(true);
	}

}
