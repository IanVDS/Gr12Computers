package Graphics.animations;
import java.awt.Graphics;
public class Ball {
	public double x1,sx,y1,sy,vx,vy;


	public Ball(double x1,double y1,double sx,double sy,double vx, int rS) {
		this.x1=x1;
		this.sy=sy;
		this.y1=y1;
		this.sx=sx;
		this.vx = vx;
		double vy=0;
		this.vy = vy;

	}


	public void paint(Graphics g) {
		g.fillOval((int)x1, (int)y1, (int)sx, (int)sy);
	}

	public void bounceWall(double vx, double bx1, double bx2,int lS, int rS) {
		if(bx1 < 0 || bx2 > rS) {
			this.vx = -vx;
		}
	}
	public void bounceFloor(double vy,double by2,int bS) {
		if(by2 > bS) {
			this.vy = -vy;
		}
	}
	public void horizontalCalc() {
		x1 = x1+vx;
	}
	public void heightCalc() {
		vy = 0.1*((vx))*((vx));
		y1+=vy;
	}


}
