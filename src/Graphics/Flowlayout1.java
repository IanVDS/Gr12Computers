package Graphics;
/* Ian Van den Steen
 * Oct. 4, 2021
 * Mr. Harwood
 */
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

public class Flowlayout1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Flowlayout1();
	}
	
	JFrame window;
	Flowlayout1(){
		window = new JFrame("Flow Layout");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setLayout(new FlowLayout());
	
		for(int i=0;i<10;i++) {
			panel.add(new JButton("Hello"));
		}
		window.add(panel);	
		
		
		//the last thing you do (normally)
		window.setVisible(true);
	}

}
