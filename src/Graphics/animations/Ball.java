package Graphics.animations;
import java.awt.Graphics;
public class Ball {
	public double x1,x2,y1,y2,vx,vy;
	
	public Ball(double x1,double x2,double y1,double y2,double vx,double vy) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		
		vy = -vx*vx;
		
		
		
		
	}
}
