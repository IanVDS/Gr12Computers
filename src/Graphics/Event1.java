package Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Event1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Event1();
	}
	
	JFrame window;
	JPanel panel;
	Event1(){
		window = new JFrame("Event demo");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		JButton button = new JButton("Yes");
		JButton btnClose = new JButton("Exit");
		button.addActionListener(new MyAl());
		
		panel.add(button);
		panel.add(btnClose);
		window.add(panel);
		
		window.setVisible(true);
	}
	//implements means "use the interface"
	class MyAl implements ActionListener{
		int numsClicks = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			numsClicks++;
			window.setTitle(numsClicks + " clicks");
			Color color1 = new Color((64*numsClicks+64)%256,(64*numsClicks+128)%256,(64*numsClicks+198)%256);
			panel.setBackground(color1);
		}
		
		
		
	}
}
