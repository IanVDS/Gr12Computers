package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MouseProgram implements MouseListener, MouseMotionListener{

	/* show how to draw using swing
	 * 
	 */

	public static void main(String[] args) {
		new MouseProgram();

	}

	int panW = 500, panH = 500;
	Rectangle box = new Rectangle(50,50,50,50);
	int mx,my;
	DrawingPanel panel;

	MouseProgram(){
		//setUp JFrame
		JFrame window = new JFrame("Drawing on JPanel");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new DrawingPanel();

		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
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
			Color color = new Color(mx%256,my%256,mx*my%256);
			g.setColor(color);
			g.fillRect(box.x, box.y, box.width, box.height);
			g.drawLine(panW/2, panH/2, mx, my);
			g.drawLine(panW/2, panH/2, (-1)*mx, (-1)*my);
			g.drawLine(panW/2, panH/2, mx/2, my/2);
			g.drawLine(panW/2, panH/2, 250-(-1)*mx/2, 250-(-1)*my/2);
			g.drawLine(panW/2, panH/2, 250-mx/4, 250-my/4);
			g.drawLine(panW/2, panH/2, 250-3*mx/(-4), 250-3*my/(-4));
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mx = e.getX();
		my = e.getY();
		panel.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (box.contains(e.getPoint())) {
			panel.setBackground(Color.BLACK);
			box.x+=50;
			panel.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}


}


