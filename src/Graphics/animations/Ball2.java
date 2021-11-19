package Graphics.animations;

//Ian Van den Steen
//Is used for GraphicsTest.java

import java.awt.Color;
import java.awt.Graphics;
public class Ball2 {
	
	public double x1,y1,vx,vy;
	public int rS,sxy;
	public Ball2(double x1,double y1,int sxy,double vx,double vy, int rS) {
		this.x1=x1;
		this.y1=y1;
		this.vx = vx;
		this.vy = vx;
		this.rS = rS;
		this.sxy=sxy;
	}


		public void paint(Graphics g) {//draws the ball
			g.setColor(Color.BLACK);
			g.fillOval((int) x1,(int)y1,sxy,sxy);
		}
		public void hitWall(double bx1,double bx2) {//hits the left wall, gets brought back to the right side
			if( bx2 > rS) {
				x1=0;
			}
			if((bx1<0)) {
				x1=rS-sxy;
			}
		}
		
		public void move() {//calculates which way the ball is moving
			x1 = x1+(vx);
			
		}
		
	}
