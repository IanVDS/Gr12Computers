package Graphics;

import java.awt.Graphics;

/** 
 * 
 * @author tv30254
 *
 */
public class Line {
	public double x1, x2, y1, y2,origin;

	public final double cx,cy; //coordinates of the centre of the line

	public Line (double x1, double y1, double x2, double y2,double origin){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.origin = origin;

		cx = (x1 + x2)/2.0;
		cy = (y1 + y2)/2.0;

	}

	//hello
	/**
	 * Purpose: Paint the line on the graphics context<br> 
	 * Called from: TimerRotate.DrawingPanel.paintComponent()<br>
	 * Calls: none<br>
	 * @param g graphics context passed from subclassed JPanel
	 */
	public void paint(Graphics g) {
		g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
	}

	/**
	 * Purpose: rotate the line about its centre<br>
	 * Called from: ActionListener for Timer in class TimerRotate<br>
	 * Calls: rotatePoint() for each endpoint<br>
	 * @param angle%(Math.PI*2) the angle%(Math.PI*2) in radians to rotate the line
	 */
	public void rotate(double angle) {
		PointD tempPoint = rotatePoint(angle, x1,y1,cx,cy);
		x1 = tempPoint.x;
		y1 = tempPoint.y;

		tempPoint = rotatePoint(angle, x2,y2,cx,cy);
		x2 = tempPoint.x;
		y2 = tempPoint.y;
	}
	public void rotate2(double angle) {
		PointD tempPoint = rotatePoint(angle, x1,y1,x2,y2);
		x1 = tempPoint.x;
		y1 = tempPoint.y;
	}
	public void rotate3(double angle) {
		PointD tempPoint = rotatePoint2(angle, x1,y1,x2,y2,origin);
		x1 = tempPoint.x;
		y1 = tempPoint.y;
		x2 = tempPoint.x2;
		y2 = tempPoint.y2;
	}
	public void rotate4(double angle) {
		PointD tempPoint = rotatePoint(angle, x1,y1,cx,cy);
		x1 = tempPoint.x;
		y1 = tempPoint.y;

		tempPoint = rotatePoint3(angle, x2,y2,cx,cy);
		x2 = tempPoint.x;
		y2 = tempPoint.y;
	}
	public void lift() {
		y1-=1;
		y2-=1;
	}
	public void lower() {
		y1+=1;
		y2+=1;
	}

	/* 
	 * The results (new point) are sent back as a PointD object (ie. a Point with doubles) */
	/**
	 * Purpose: to rotate any point by an angle%(Math.PI*2) (radians) about a centre point.
	 * 			The rotation is in the same direction as angle%(Math.PI*2)s in math (anticlockwise).
	 * Called from: this.rotate()
	 * Calls: none (but creates PointD object to return)
	 * @param angle%(Math.PI*2) in radians
	 * @param x x value of initial point
	 * @param y y value of initial point
	 * @param centrex, centrey rotate initial point about this point
	 *
	 *
	 * @return PointD object containing new point in double precision
	 */
	PointD rotatePoint(double angle, double x, double y, double centrex, double centrey) {
		double newx = (x-centrex) * (Math.cos(angle)%(Math.PI*2)) + (y-centrey) * (Math.sin(angle)%(Math.PI*2));
		double newy = -(x-centrex) * (Math.sin(angle)%(Math.PI*2)) + (y-centrey) * (Math.cos(angle)%(Math.PI*2));
		PointD pd = new PointD(); 
		pd.x = newx+centrex;
		pd.y = newy+centrey;
		return pd;
	}
	PointD rotatePoint2(double angle, double x, double y, double x2,double y2, double origin) {
		double newx = (x-origin) * (Math.cos(angle)%(Math.PI*2)) + (y-origin) * (Math.sin(angle)%(Math.PI*2));
		double newy = -(x-origin) * (Math.sin(angle)%(Math.PI*2)) + (y-origin) * (Math.cos(angle)%(Math.PI*2));
		double newx2 = (x-origin) * (Math.cos(angle)%(Math.PI*2)) + (y-origin) * (Math.sin(angle)%(Math.PI*2));
		double newy2 = -(x-origin) * (Math.sin(angle)%(Math.PI*2)) + (y-origin) * (Math.cos(angle)%(Math.PI*2));
		PointD pd = new PointD(); 
		pd.x = newx+origin;
		pd.y = newy+origin;
		pd.x2 = newx2+origin;
		pd.y2 = newy2+origin;
		return pd;
	}
	PointD rotatePoint3(double angle, double x, double y, double centrex, double centrey) {
		double newx = ((x-centrex) * (Math.cos(angle)%(Math.PI*2)) + (y-centrey) * (Math.sin(angle)%(Math.PI*2)));
		double newy = (-(x-centrex) * (Math.sin(angle)%(Math.PI*2)) + (y-centrey) * (Math.cos(angle)%(Math.PI*2)));
		PointD pd = new PointD(); 
		pd.x = newx+centrex;
		pd.y = newy+centrey;
		return pd;
	}
	
	
	


	/** This is a small class that enables the user to have a point with x,y fields that are double
	 *  instead of "int" that java.awt.Point forces you to have.
	 */
	private class PointD {
		public double y2;
		public double x2;
		double x, y;
	}
}