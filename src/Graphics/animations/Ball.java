package Graphics.animations;
//Ian Van den Steen

import java.awt.Color;
import java.awt.Graphics;
public class Ball {
	public double x1,sx,y1,sy,vx,vy,ix,iy;
	public double yCurrent = 100;
	public int wallsBounced=0,size;
	public boolean runBool=false;


	public Ball(double x1,double y1,double sx,double sy,double vx, int size) {
		this.x1=x1;
		this.sy=sy;//height
		this.y1=y1;
		this.sx=sx;//width
		this.vx = vx;
		double vy=0;
		this.vy = vy;
		this.size = size;//window size
		ix=this.x1;//starting point for y
		iy=this.y1;//starting point for y



	}
	

	
	public void paint(Graphics g) {//draws the ball

		Color color1 = new Color(64*(wallsBounced+1)%256,128*(1+wallsBounced)%256,32*(wallsBounced+1)%256);
		g.setColor(color1);


		g.fillOval((int)x1, (int)y1, (int)(sx), (int)(sy));
	}

	public void bounceWall() {//hits the left wall
		if(x1 < 0 || x1+sx > size) {
			this.vx = -vx;
			wallsBounced=1;

		}
	}
	public void bounceFloor() {//hits the floor
		if(y1+sy > size&&x1>75) {
			wallsBounced=2;
			yCurrent = size-5;
		}

	}
	public void elevLift() {//reaches the elevator
		if(x1<=75&&wallsBounced==2) {
			wallsBounced=3;
			x1=75;
		}
	}
	public void restart() {//restarts the loop
		if(y1<=45&&wallsBounced==3) {
			yCurrent=100.0;
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
			y1 = yCurrent+(x1-size)*(x1-size)*0.05;//falls
		}else if(wallsBounced==2) {
			y1 = yCurrent-Math.abs((200/(size-x1))*30*Math.cos(x1*5))-3;//bounces
		}else if(wallsBounced==3) {
			y1-=1;//is raised
			vx=0;
		}
	}
	


}
