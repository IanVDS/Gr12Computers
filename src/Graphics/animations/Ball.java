package Graphics.animations;
//Ian Van den Steen

import java.awt.Graphics;
public class Ball {
	public double x1,sx,y1,sy,vx,vy;
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
		


	}


	public void paint(Graphics g) {
		g.fillOval((int)x1, (int)y1, (int)(sx), (int)(sy));
	}

	public void bounceWall(double vx, double bx1, double bx2,int lS, int rS) {
		if(bx1 < 0 || bx2 > rS) {
			this.vx = -vx;
			wallsBounced=1;
		}
	}
	public void bounceFloor(double by2,int bS) {
		if(by2 > bS) {
			wallsBounced=2;
			yCurrent = bS;
		}

	}
	public void elevLift(double x1) {
		if(x1==75&&wallsBounced==2) {
			wallsBounced=3;
		}
	}
	public void restart(double y1) {
		if(y1<=45&&wallsBounced==3) {
			yCurrent=y1;
			wallsBounced=0;
			vx=1;
		}
	}
	
	public void horizontalCalc() {
		x1 = x1+vx;
	}
	public void heightCalc() {
		if(wallsBounced==0) {
			y1 = yCurrent-Math.abs((100/x1)*30*Math.cos(x1*5));
		}else if(wallsBounced==1) {
			y1 = yCurrent+(x1-rS)*(x1-rS)*0.05;
		}else if(wallsBounced==2) {
			y1 = yCurrent-Math.abs((150/(rS-x1))*30*Math.cos(x1*5))-3;
		}else if(wallsBounced==3) {
			y1-=1;
			vx=0;
		}
	}


}
