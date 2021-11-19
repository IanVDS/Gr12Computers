package Graphics.animations;

//Ian Van den Steen
//requires Ball2.java

import java.awt.BorderLayout;
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


public class GraphicsTest implements KeyListener{

	public static void main(String[] args) { 
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GraphicsTest(); 
			}
		});
	}

	/****************
	 *  Variables   *
	 ****************/
	//windows and panels
	JFrame window = new JFrame("Graphics Test");
	DrawingPanel panel1 = new DrawingPanel();
	JPanel panel2 = new JPanel();
	static final int SIZE = 500;
	
	Ball2 ball = new Ball2(150.0,250.0,30,1.0,1.0,SIZE);

	//buttons
	JButton btn1 = new JButton("Pause");
	JButton btn2 = new JButton("Reverse");



	//Timer stuff
	Timer timer;
	private int t_speed = 5; //speed of timer repeats (ms)
	int t_pause = 1000;  //initial delay (ms)
	int time;       //just to display elapsed time


	/*****************************************
	 *   Set up the window (JFrame)           *
	 *   and initialize whatever you need to  *
	 *****************************************/
	GraphicsTest() {

		//all window stuff

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/***********************************************************
		 * This is how you get the monitor screen resolution size  *
		 * and make your program take up the whole screen.         *
		 ***********************************************************/


		window.setLocationRelativeTo(null);
		//TODO
		window.addKeyListener(this);
		window.add(panel1,BorderLayout.NORTH);
		panel2.setBackground(Color.BLUE);

		btn1.addActionListener(new Action1());
		btn2.addActionListener(new Action2());

		panel2.add(btn1);
		panel2.add(btn2);
		window.add(panel2,BorderLayout.SOUTH);

		window.pack();
		window.setVisible(true);

		//all timer stuff (start after window is shown)
		timer = new Timer(t_speed, new TimerAL());
		timer.setInitialDelay(t_pause);
		timer.start();
		timer.setInitialDelay(0); 

	}

	/********************************************/
	/*  Inner class for Timer's ActionListener  */
	/********************************************/
	private class TimerAL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {//moves the ball
			time++;
			ball.hitWall(ball.x1,ball.x1+ball.sxy);
			ball.move();

			panel1.repaint();
		}
	}


	private class DrawingPanel extends JPanel {

		//constructor
		DrawingPanel() {
			this.setBackground(Color.WHITE);
			this.setPreferredSize(new Dimension(SIZE,SIZE));
		}

		/***************************/
		/*  Draw all objects here  */
		/***************************/
		@Override
		public void paintComponent(Graphics g) {//paints everything
			super.paintComponent(g); //clears the screen and repaints it

			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			ball.paint(g2d);

			g2d.dispose();
		}
	}

	/****************************/
	/* All event listeners here */
	/****************************/

	class Action1 implements ActionListener{//pause and resume
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Pause")){
				timer.stop();
				btn1.setText("Resume");
			}else if(e.getActionCommand().equals("Resume")) {
				timer.restart();
				btn1.setText("Pause");
			}


		}
	}
	class Action2 implements ActionListener{//reverse ball.vx
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn2) {
				ball.vx = -ball.vx;
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased (KeyEvent e) {}
	@Override
	public void keyTyped    (KeyEvent e) {}

}


