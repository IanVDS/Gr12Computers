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
	Ball ball = new Ball(5.0,100.0,5.0,5.0,5.0,SIZE);
	Line line = new Line(250.0,250.0,250.0,250.0,250.0);
	private int t_speed = 10;
	int t_pause = 1000;
	int time;

	int line1X1 = 100;
	int line1Y = 100;
	int line1X2 = 175;
	
	int line2X1 = 250;
	int line2X2 = 325;
	int line2Y = 100;
	double angle=240;
	
	

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
			
			
			ball.bounceWall(ball.vx,ball.x1,ball.x1+ball.sx,0,SIZE);
			ball.bounceFloor(ball.y1+ball.sy,SIZE);
			ball.horizontalCalc();
			ball.heightCalc();
			line.rotate(angle);
			
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

			g.drawLine(line1X1, line1Y, line1X2, line1Y);
			g.drawLine(line2X1,line2Y,line2X2,line2Y);
			g.drawLine(0, SIZE, SIZE, SIZE);
			ball.paint(g2d);
			line.paint(g2d);
			


//			g2d.dispose(); //only dispose of graphics objects that you have created
		}
	}

}
