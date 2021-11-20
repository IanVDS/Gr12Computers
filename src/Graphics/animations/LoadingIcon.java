package Graphics.animations;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Graphics.Line;

//Ian Van den Steen
public class LoadingIcon {

	public static void main(String[] args) {
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
	private int t_speed = 10;//sets the speed of the timer
	int t_pause = 1000;
	
	//objects
	static ArrayList<Ball> ballList = new ArrayList<Ball>();
	static ArrayList<Line> lineList = new ArrayList<Line>();
	int listSize = 5; //controls the number of balls and lifts there are
	
	Line line1,line2,line3;
	int bouncePoint = 100;
	

	LoadingIcon() {

		//all window stuff
		JFrame window = new JFrame("Loading Icon");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);

		window.add(mainPanel);
		window.pack();
		window.setVisible(true);

		//all timer stuff
		timer = new Timer(t_speed, new TimerAL());
		timer.setInitialDelay(t_pause);
		timer.start();
		timer.setInitialDelay(0);
		
		//initiating objects
		for(int i=0;i<listSize;i++) {
			ballList.add(new Ball(75.0,45.0,10.0,10.0,5.0,SIZE));
			lineList.add(new Line(50.0,55.0,100,55.0));	
		}
		line1 =  new Line(165,240,bouncePoint+(int)ballList.get(0).sy);
		line2 = new Line(265,340,bouncePoint+(int)ballList.get(0).sy);
		line3 = new Line(365,440,bouncePoint+(int)ballList.get(0).sy);
		
	}
	
	private class TimerAL implements ActionListener{
             
		@Override
		public void actionPerformed(ActionEvent e) {//starts the loop for each ball and lift
			
			ballList.get(0).runBool=true;
			for(int i=0;i<listSize;i++) {
				Ball b = ballList.get(i);
				if(b.runBool) ballCycle(ballList.get(i));
				if(ballList.get(i).wallsBounced==3&&ballList.get(i).runBool) {
					lineList.get(i).lift();
				}else if(ballList.get(i).wallsBounced<3&&ballList.get(i).runBool) {
					lineList.get(i).lower(SIZE);
				}
				if(b.wallsBounced==1&&i<listSize-1) ballList.get(i+1).runBool=true;
				
			}
			mainPanel.repaint();
		}
	}


	private class DrawingPanel extends JPanel {

		//constructor
		DrawingPanel() {
			this.setBackground(Color.WHITE);
			this.setPreferredSize(new Dimension(SIZE,SIZE));
			
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //clears the screen and repaints it

			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			//paints non moving lines
			line1.paint(g);
			line2.paint(g);
			line3.paint(g);
			
			//paints moving parts
			for(int i=0;i<listSize;i++) {
				lineList.get(i).paint(g);
				ballList.get(i).paint(g);
				
			}
			


		}
		
	}
	public void ballCycle(Ball b) {//method for ball loop
		b.bounceWall();
		b.bounceFloor();
		b.horizontalCalc();
		b.heightCalc();
		b.elevLift();
		b.restart();
	}

}
