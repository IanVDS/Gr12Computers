package Graphics;
/* Ian Van den Steen
 * Sept.22, 2021
 * Mr. Harwood
 */
import java.awt.Color;

import javax.swing.*;

public class FirstGraphics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FirstGraphics();
	}
	
	JFrame window;
	FirstGraphics(){
		window = new JFrame("I love graphics");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		window.add(panel);
		panel.add(new JLabel("welcome"));
		JButton btn1 = new JButton("Okay");
		panel.add(btn1);
		
		//the last thing you do (normally)
		window.setVisible(true);
	}

}
