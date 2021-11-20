package Graphics;

import java.awt.Color;
import java.awt.Graphics;

/** 
 * 
 *
 */
public class Line {
	public double x1, x2, y1, y2;
Color color = Color.black;
	public Line (double x1, double y1, double x2, double y2){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;

	}
	public Line(int x1,int x2,int y) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y;
		this.y2=y;
	}


	//draw the line
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
	}

	

	public void lift() {//lifts platform
		if(y1>50) {
			y1-=1;
			y2-=1;
		}
	}
	public void lower(int size) {//lowers platform
		if(y1<=size-5) {
			y1+=3.75;
			y2+=3.75;
		}
	}
}