package Graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Math;

public class Drawing2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Drawing2();
	}
	int panW = 500, panH = 500;

	Drawing2(){
		JFrame window = new JFrame("Cape Cod");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawingPanel panel = new DrawingPanel();
		window.add(panel);

		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);	}
	class DrawingPanel extends JPanel{


		DrawingPanel(){
			//this controls the size ***
			this.setPreferredSize(new Dimension(panW,panH));
			this.setBackground(Color.BLUE);
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.YELLOW);
			Graphics2D g2 = (Graphics2D) g;
		
			for(int i=-250;i<250;i++) {
				int x2 = 0;
				double y2=drawCubic(i,x2);
				

				g.drawLine(drawCubic(i-1,x2)*-1+350,(i-1)+350,(int) (y2+350)*-1,(i+350));
			}
			
			g.fillRect(0, 150, panW, 90);
//			g.fillRect(0, 150, 30, 175);
			Color grassGreen= new Color(0,204,0); 
			g.setColor(grassGreen);
			g.fillRect(0,0, panW ,175);
			g.fillRect(0, 0, 230, 225);
			g.fillRect(0, 0, 80, 350);

			for(int i=-250;i<250;i++) {
				int x2 = 0;
				double y2=drawCubic(i,x2);
				

				g.drawLine(drawCubic(i-1,x2)*-1/2+250,(i-1)+300,(int) (y2+250)*-1/2,(i+300));
			}
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			//base of the house
			Color brown = new Color(102,51,0);
			g.setColor(brown);
			g.fillRect(50,125,125,75);
			
			//door
			g.setColor(Color.BLACK);
			g.drawRect(60, 135, 35, 64);
			g2.setStroke(new BasicStroke(5));
			g2.drawOval(88,170,1,1);
			//window
			Color windowColor = new Color(204,255,204,150);
			g.setColor(windowColor);
			g.fillRect(125, 135, 40, 35);
			
			//roof
			Color yellow = new Color(255,204,0);
			g.setColor(yellow);
			Polygon roof = new Polygon();
			roof.addPoint(30,125);
			roof.addPoint(113, 85);
			roof.addPoint(195, 125);
			
			g.fillPolygon(roof);
			
			//surf boards
			g2.fillOval(350, 175, 20, 70);
			Color pink = new Color(255,0,102);
			g2.setColor(pink);
			g2.fillOval(380, 175, 20, 70);
			Color lime = new Color(0,255,0);
			g2.setColor(lime);
			g2.fillOval(410, 175, 20, 70);
			
			Color babyBlue = new Color(102,153,155);
			g.setColor(babyBlue);
			g.fillRect(300, 70, 155, 60);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Comic Sans MS",Font.BOLD,30));
			g.drawString("Cape Cod",310,110);
			
		}
	}

	int drawCubic(int i,int x) {
		x =(i*i*i + 80*i*i + 10*i)/1000;
		return x;
	}
	double drawSin(int i, double x) {
		x = Math.sin(i);
		x*=30;
		return  x;
	}
}
