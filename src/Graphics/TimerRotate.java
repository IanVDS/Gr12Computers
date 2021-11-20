package Graphics;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * This program demonstrates how to rotate a Line2 ...
 * timers ...
 * @author tv30254
 * @date May 20, 2018
 * @version 1.1
 */

public class TimerRotate implements KeyListener{

	/**
	 * main method that runs GUI in  Event-Dispatching thread for thread safety.
	 * <br> It makes a TimerRotate object. That's all. 
	 * 
	 */
	public static void main(String[] args) { 
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TimerRotate(); 
			}
		});
	}

	/****************
	 *  Variables   *
	 ****************/
	//Window stuff
	/** constant for size of JFrame */
	static final int SIZE = 500;
	/** drawing panel object that does all graphics */
	DrawingPanel mainPanel = new DrawingPanel();

	//Timer stuff
	Timer timer;
	private int t_speed = 5; //speed of timer repeats (ms)
	int t_pause = 1000;  //initial delay (ms)
	int time;       //just to display elapsed time. This should be compared with System.currentTimeMillis()

	//Other objects and variables
	Line2 Line2 = new Line2(100.0, 100.0, 300.0, 300.0,250.0); 
	Line2 Line22 = new Line2(100.0, 100.0, 300.0, 300.0,250.0); 
	Line2 Line23 = new Line2(100.0, 100.0, 300.0, 300.0,250.0); 
	Emoji emoji = new Emoji(150.0,250.0,1.0,1.0,SIZE);

	double angle = 0.0;


	/*****************************************
	 *   Set up the window (JFrame)           *
	 *   and initialize whatever you need to  *
	 *****************************************/
	TimerRotate() {

		//all window stuff
		JFrame window = new JFrame("Timers");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/***********************************************************
		 * This is how you get the monitor screen resolution size  *
		 * and make your program take up the whole screen.         *
		 ***********************************************************/
		// Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
		// window.setSize(fullScreen);

		window.setLocationRelativeTo(null);

		window.addKeyListener(this);
		window.add(mainPanel);
		window.pack();
		window.setVisible(true);

		//all timer stuff (start after window is shown)
		timer = new Timer(t_speed, new TimerAL());
		timer.setInitialDelay(t_pause);
		timer.start();
		timer.setInitialDelay(0); //if we don't do this, then restarting the timer is delayed

	}

	/********************************************/
	/*  Inner class for Timer's ActionListener  */
	/********************************************/
	private class TimerAL implements ActionListener{

		/* Don't put a lot of code here. Instead call methods to do stuff */             
		@Override
		public void actionPerformed(ActionEvent e) {
			time++;
			angle += (Math.toRadians(0.005))%(Math.PI*2); 
//			Line2.rotate2(angle);
//			Line22.rotate4(angle);
//			Line23.rotate3(angle);
			emoji.bounceFloor(emoji.y1);
			emoji.bounceWall(emoji.x1,emoji.x1+30);
			//TODO
			emoji.move();
			mainPanel.repaint();
		}
	}


	private class DrawingPanel extends JPanel {

		//constructor
		DrawingPanel() {
			//put background colour here
			this.setBackground(Color.WHITE);
			this.setPreferredSize(new Dimension(SIZE,SIZE));
		}

		/***************************/
		/*  Draw all objects here  */
		/***************************/
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //clears the screen and repaints it

			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

//			g.drawLine2((int)Line2.x1,(int)Line2.y1,(int)Line2.x2,(int) Line2.y2);
//			Line2.paint(g);
//			Line22.paint(g);
			emoji.paint(g2d);
//			g.drawString("TIME1=" + time*t_speed, 50,50);

			g2d.dispose(); //only dispose of graphics objects that you have created
		}
	}

	/****************************/
	/* All event listeners here */
	/****************************/

	@Override
	public void keyPressed(KeyEvent e) {
		//Press any key to pause timer
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.restart();
		}
	}

	@Override
	public void keyReleased (KeyEvent e) {}
	@Override
	public void keyTyped    (KeyEvent e) {}

}


