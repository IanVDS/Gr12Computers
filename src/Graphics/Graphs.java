package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Graphs {

	/* show how to draw using swing
	 * 
	 */

	public static void main(String[] args) {
		new Graphs();

	}
	
	int panW = 500, panH = 500;
	double xmin=-3,xmax=8,ymin=-5,ymax=7;
	//how much and or y increases over each pixel
	double xStep = (xmin-xmax)/panW;
	double yStep = (ymin-ymax)/panH;
	int px,py;
	
	Graphs(){
		//setUp JFrame
		JFrame window = new JFrame("Drawing on JPanel");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawingPanel panel = new DrawingPanel();
		window.add(panel);

		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	class DrawingPanel extends JPanel{


		DrawingPanel(){
			//this controls the size ***
			this.setPreferredSize(new Dimension(panW,panH));
			this.setBackground(Color.BLUE);
		}
		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);
			g.setColor(Color.GREEN);
			px = (int) (panW*(0-xmin)/(xmax-xmin));
			py = panH-(int) (panH*(0-ymin)/(ymax-ymin));
			g.drawLine(0,py,panW,py);
			g.drawLine(px,0,px,panH);
			
			
			
			for(double x=xmin;x<xmax;x+=xStep) {
				double y = Math.tan(x);
				plotPt(x,y,g);
				y = x*x;
			}
			
			}
		}
	public void plotPt(double x,double y,Graphics g) {
		
		
		px = (int) (panW * (x-xmin) / (xmax-xmin));
		py = panH-py;
		g.drawLine(px, py, px, py);
	}


	
}


