package Graphics.animations;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Graphics.Line;

//Ian Van den Steen
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
	static final double origin = 250.0;
	DrawingPanel mainPanel = new DrawingPanel();

	//Timer Stuff
	Timer timer;
<<<<<<< HEAD
	Ball ball = new Ball(75.0,45.0,10.0,10.0,5.0,SIZE);
	Line line = new Line(250.0,250.0,250.0,250.0,250.0);
	Line line2 = new Line(50.0,50.0,100.0,50.0,250.0);
	private int t_speed = 10;
=======
	Ball ball = new Ball(75.0,45.0,5.0,5.0,5.0,SIZE);
	Ball ball2 = new Ball(75.0,45.0,5.0,5.0,5.0,SIZE);
	Ball ball3= new Ball(75.0,45.0,5.0,5.0,5.0,SIZE);
	Line line = new Line(250.0,250.0,250.0,250.0,250.0);
	Line line2 = new Line(50.0,50.0,100.0,50.0,250.0);
	
	boolean ball2Start = false;
	boolean ball3Start = false;
	private int t_speed = 20;
>>>>>>> master
	int t_pause = 1000;
	int time;
	
	Line line3 = new Line(100,175,105);
	Line line4 = new Line(250,325,105);
	Line line5 = new Line(350,425,105);
	double angle=224;
	
	

	LoadingIcon() {

		//all window stuff
		JFrame window = new JFrame("Timers");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setSize(SIZE,SIZE);
//		mainPanel.setSize(SIZE,SIZE);
		/***********************************************************
		 * This is how you get the monitor screen resolution size  *
		 * and make your program take up the whole screen.         *
		 ***********************************************************/
		// Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
		// window.setSize(fullScreen);

		window.setLocationRelativeTo(null);

		window.add(mainPanel);
		window.pack();
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
			
			
			ballCycle(ball);
			if(ball.wallsBounced==1) ball2Start=true;
			
			if(ball.wallsBounced==3) {
				line2.lift();
				ball3Start=true;
			}else if(ball.wallsBounced<3) {
				line2.lower();
			}
			
			if(ball2Start==true) ballCycle(ball2);
			if(ball3Start==true) ballCycle(ball3);
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
			
			line3.paint(g);
			line4.paint(g);
			line5.paint(g);
			g.drawLine(0, SIZE, SIZE, SIZE);
			ball.paint(g2d);
			line.paint(g2d);
			line2.paint(g2d);
			if(ball2Start) ball2.paint(g);
			if(ball3Start) ball3.paint(g);
			


//			g2d.dispose(); //only dispose of graphics objects that you have created
		}
		
	}
	public void ballCycle(Ball b) {
		b.bounceWall(b.vx,b.x1,b.x1+b.sx);
		b.bounceFloor(b.y1+b.sy);
		b.horizontalCalc();
		b.heightCalc();
		b.elevLift(b.x1);
		b.restart(b.y1);
	}

}
