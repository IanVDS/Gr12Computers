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
import Object_lesson.Friend;

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
	static final double origin = 250.0;
	DrawingPanel mainPanel = new DrawingPanel();

	//Timer Stuff
	Timer timer;
	
	//objects
	static ArrayList<Ball> ballList = new ArrayList<Ball>();
	static ArrayList<Line> lineList = new ArrayList<Line>();
	
	Ball ball = new Ball(75.0,45.0,10.0,10.0,5.0,SIZE);
	Ball ball2 = new Ball(75.0,45.0,10.0,10.0,5.0,SIZE);
	Ball ball3 = new Ball(75.0,45.0,10.0,10.0,5.0,SIZE);
	Line line = new Line(50.0,55.0,100.0,55.0,250.0);
	Line line2 = new Line(50.0,55.0,100.0,55.0,250.0);
	Line line3 = new Line(50.0,55.0,100.0,55.0,250.0);

	Line line4 = new Line(250,325,105);
	Line line5 = new Line(350,425,105);
	Line line6 = new Line(100,175,105);

	
	private int t_speed = 10;
	
	boolean ball2Start = false;
	boolean ball3Start = false;
	int t_pause = 1000;
	int time;
	
	

	LoadingIcon() {

		//all window stuff
		JFrame window = new JFrame("Timers");
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
		for(int i=0;i<3;i++) {
			ballList.add(new Ball(75.0,45.0,10.0,10.0,5.0,SIZE));
			lineList.add(new Line(50.0,55.0,100.0,55.0,250.0));
		}

	}
	
	private class TimerAL implements ActionListener{
             
		@Override
		public void actionPerformed(ActionEvent e) {
			time++;
			
			
			ballCycle(ballList.get(0));
			for(int i=1;i<3;i++) {
				Ball b = ballList.get(i);
				if(b.wallsBounced==1) ballCycle(b);
				
			}//needs to add line mvmt
			
			
			if(ball.wallsBounced==3) {
				line.lift();
				ball3Start=true;
			}else if(ball.wallsBounced<3) {
				line.lower(SIZE);
			}
			
			
			if(ball2.wallsBounced==3) {
				line2.lift();
				
			}else if(ball2.wallsBounced<3) {
				line2.lower(SIZE);
			}
			
			
			if(ball3.wallsBounced==3) {
				line3.lift();
				
			}else if(ball3.wallsBounced<3) {
				line3.lower(SIZE);
			}
			
			
			if(ball2Start==true) ballCycle(ball2);
			if(ball3Start==true) ballCycle(ball3);
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
			
			line4.paint(g);
			line5.paint(g);
			line6.paint(g);
			
			g.setColor(Color.RED);
			line.paint(g);
			g.setColor(Color.BLACK);
			line2.paint(g);
			line3.paint(g);
			g.drawLine(0, SIZE, SIZE, SIZE);
			ball.paint(g2d);

			if(ball2Start) ball2.paint(g);
			if(ball3Start) ball3.paint(g);
			


		}
		
	}
	public void ballCycle(Ball b) {
		b.bounceWall();
		b.bounceFloor();
		b.horizontalCalc();
		b.heightCalc();
		b.elevLift();
		b.restart();
	}

}
