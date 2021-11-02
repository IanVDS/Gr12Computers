package Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Event2 implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Event2();
	}

	JFrame window;
	JPanel panel;
	JButton button;
	JButton button2;
	JButton button3;
	Event2(){
		window = new JFrame("Event demo");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		button = new JButton("Color changer1");
		button2 = new JButton("Color changer2");
		button3 = new JButton("Color changer 3");
		JButton btnClose = new JButton("Exit");
		btnClose.addActionListener(this);
		//		btnClose.setActionCommand("Exit");
		button.addActionListener(new Action1());
		button2.addActionListener(new Action1());
		button3.addActionListener(new Action1());
		button3.addActionListener(new Action2());
		
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		panel.add(btnClose);
		window.add(panel);

		window.setVisible(true);
	}
	//implements means "use the interface"

	int numsClicks = 0;

	class Action1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Exit")){
				window.dispose();
			}
			if (e.getSource() == button || e.getSource()==button2 || e.getSource()==button3) {
				numsClicks++;
				
				Color color1 = new Color((64*numsClicks+64)%256,(64*numsClicks+128)%256,(64*numsClicks+198)%256);
				panel.setBackground(color1);
			}
			

		}
	}
	class Action2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button3) {
				window.setTitle("I changed the title!");
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}


