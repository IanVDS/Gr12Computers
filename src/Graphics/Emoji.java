package Graphics;
//Ian Van den Steen

import java.awt.Graphics;
import java.awt.Color;
public class Emoji {
	public double x1,y1,vx,vy;
	public double yCurrent = 100.0;
	public int wallsBounced=0,rS;

	public Emoji(double x1,double y1,double vx,double vy, int rS) {
		this.x1=x1;
		this.y1=y1;
		this.vx = vx;
		this.vy = vx;
		this.rS = rS;


	}


	public void paint(Graphics g) {//draws the ball
		g.setColor(Color.YELLOW);
		g.fillOval((int) x1,(int)y1,30,30);
		g.setColor(Color.BLACK);
		g.drawOval((int)x1,(int)y1,30,30);
		g.fillOval((int)x1+8,(int)y1+11,(int)3,(int)3);//left eye
		g.drawLine((int)x1+6,(int)y1+11,(int)x1+8,(int) (y1+9));
		g.drawLine((int)x1+8,(int)y1+9,(int)x1+13,(int)y1+11);
		g.fillOval((int)x1+21,(int)y1+9,3,5);//right eye
		g.drawLine((int)x1+18,(int)y1+7,(int)x1+22,(int)y1+5);
		g.drawLine((int)x1+22,(int)y1+5,(int)x1+25,(int)y1+6);
		g.drawLine((int)x1+8,(int)y1+17,(int)x1+24,(int)y1+17);
	}

	public void bounceWall(double bx1, double bx2) {//hits the left wall
		if(bx1 < 0 || bx2 > rS) {
			vx = -vx;
			
			
		}
	}
	public void bounceFloor(double by2) {//hits the floor
		if((by2+30) > rS || by2<=0) {
			
			vy = -vy;
			
		}

	}
	
	
	public void move() {//calculates which way the ball is moving
		x1 = x1+vx;
		y1 = y1+vy;
	}


}
