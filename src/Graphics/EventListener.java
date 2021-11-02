package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EventListener();
	}
	
	JFrame window = new JFrame();
	JPanel panel = new JPanel();
	
	JLabel sentence = new JLabel("");
	String wordOne;
	JTextField word1;
	
	
	EventListener(){
		window = new JFrame("Sentence");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(200,200);
		window.setResizable(true);
		window.setLocationRelativeTo(null);
		
		word1 = new JTextField(15);
		word1.addActionListener(new Listener());
		
		panel.add(word1);
		panel.add(sentence);
		window.add(panel);
		
		
		window.setVisible(true);
		
	}
	
	class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			wordOne = e.getActionCommand();
			sentence.setText(sentence.getText()+ " "+wordOne);
			word1.setText("");
		}
		
	}
	
	
}
