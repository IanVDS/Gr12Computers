package Graphics.animations;
//Ian Van den Steen

import java.awt.Color;
import java.awt.Graphics;
public class Ball {
	public double x1,sx,y1,sy,vx,vy,ix,iy;
	public double yCurrent = 100.0;
	public int wallsBounced=0,rS;


	public Ball(double x1,double y1,double sx,double sy,double vx, int rS) {
		this.x1=x1;
		this.sy=sy;
		this.y1=y1;
		this.sx=sx;
		this.vx = vx;
		double vy=0;
		this.vy = vy;
		this.rS = rS;
		ix=x1;
		iy=y1;



	}


	public void paint(Graphics g) {//draws the ball

		Color color1 = new Color(64*(wallsBounced+1)%256,128*(1+wallsBounced)%256,32*(wallsBounced+1)%256);
		g.setColor(color1);


		g.fillOval((int)x1, (int)y1, (int)(sx), (int)(sy));
	}

	public void bounceWall(double vx, double bx1, double bx2) {//hits the left wall
		if(bx1 < 0 || bx2 > rS) {
			this.vx = -vx;
			wallsBounced=1;

		}
	}
	public void bounceFloor(double by2) {//hits the floor
		if(by2 > rS) {
			wallsBounced=2;
			yCurrent = rS;
		}

	}
	public void elevLift(double x1) {//reaches the elevator
		if(x1<=75&&wallsBounced==2) {
			wallsBounced=3;
			x1=75;

		}
	}
	public void restart(double y1) {//restarts the loop
		if(y1<=45&&wallsBounced==3) {
			yCurrent=100;
			x1=ix;
			y1=iy;
			wallsBounced=0;
			vx=5.0;

		}
	}

	public void horizontalCalc() {//calculates which way the ball is moving
		x1 = x1+vx;
	}
	public void heightCalc() {//calculates height based on the last wall/checkpoint the ball has hit
		if(wallsBounced==0) {
			y1 = yCurrent-Math.abs((200/x1)*30*Math.cos(x1*5));//bounces

		}else if(wallsBounced==1) {
			y1 = yCurrent+(x1-rS)*(x1-rS)*0.05;//falls
		}else if(wallsBounced==2) {
			y1 = yCurrent-Math.abs((200/(rS-x1))*30*Math.cos(x1*5))-3;//bounces
		}else if(wallsBounced==3) {
			y1-=1;//is raised
			vx=0;
		}
	}


}
