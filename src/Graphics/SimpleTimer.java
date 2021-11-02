package Graphics;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class SimpleTimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new SimpleTimer();
			}
		});
	} 
	JLabel label = new JLabel("Time: ");
	Timer timer1 = new Timer(1000, new TimerAL());
	
	SimpleTimer(){
		JFrame window = new JFrame("Timer Example");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(200,200);
		JPanel panel = new JPanel();
		panel.add(label);
		window.add(panel);
		window.setVisible(true);
		timer1.start();
	}

	public class TimerAL implements ActionListener{
		int seconds = 0;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds++;
			label.setText("Time: " + seconds );
			
		}

	
	}
}
