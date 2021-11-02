package Graphics.animations;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Graphics.Line;

public class LoadingIcon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new LoadingIcon();
			}
		});
	}

	//Window stuff
	static final int SIZE = 500;
	DrawingPanel mainPanel = new DrawingPanel();

	//Timer Stuff
	Timer timer;
	private int t_speed = 5;
	int t_pause = 1000;
	int time;

	Line line = new Line (100.0,100.0,300.0,300.0);
	double angle = 0.0;

	LoadingIcon() {

		//all window stuff
		JFrame window = new JFrame("Timers");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(SIZE,SIZE);

		/***********************************************************
		 * This is how you get the monitor screen resolution size  *
		 * and make your program take up the whole screen.         *
		 ***********************************************************/
		// Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
		// window.setSize(fullScreen);

		window.setLocationRelativeTo(null);

		window.add(mainPanel);
		window.setVisible(true);

		//all timer stuff (start after window is shown)
		timer = new Timer(t_speed, new TimerAL());
		timer.setInitialDelay(t_pause);
		timer.start();
		timer.setInitialDelay(0); //if we don't do this, then restarting the timer is delayed

	}
	
	private class TimerAL implements ActionListener{

		/* Don't put a lot of code here. Instead call methods to do stuff */             
		@Override
		public void actionPerformed(ActionEvent e) {
			time++;
			angle = angle + Math.toRadians(0.005); 
			line.rotate(angle);
			mainPanel.repaint();
		}
	}


	private class DrawingPanel extends JPanel {

		//constructor
		DrawingPanel() {
			//put background colour here
			this.setBackground(Color.WHITE);
		}

		/***************************/
		/*  Draw all objects here  */
		/***************************/
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //clears the screen and repaints it

			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			//g.drawLine(line.x1,line.y1,line.x2, line.y2);
			line.paint(g);


			g2d.dispose(); //only dispose of graphics objects that you have created
		}
	}

}
