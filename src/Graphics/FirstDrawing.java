package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class FirstDrawing {

	/* show how to draw using swing
	 * 
	 */

	public static void main(String[] args) {
		new FirstDrawing();

	}
	
	int panW = 500, panH = 500;
	
	FirstDrawing(){
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
			for (int j=0;j<300;j++) {
				g.drawLine(j,j,j,j);
			}
			for(int i=0;i<300;i++) {
				int x = 0;
				int y=drawParabola(i,x);

				g.drawLine(drawParabola(i-1,x),panH-(i-1) , y, panH-(i-1));
			}
		}

	}

	int drawParabola(int i,int x) {
		x=(i*i)/10;
		return x;
	}
}


