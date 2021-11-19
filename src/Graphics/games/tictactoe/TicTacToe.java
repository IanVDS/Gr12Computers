package Graphics.games.tictactoe;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//Ian Van den Steen
/***********************************************
 This is the skeleton for a TicTacToe game using Swing.

 Look over this and see if you have any questions so far.

 We're going to start with just the graphics part.
 But we're also going to store the data. The data will be stored as a grid 
 or 2D array of integers. 

 For TicTacToe, it make sense to have empty = 0, and then X and O be +/- 1
 We'll see why later.
 */

public class TicTacToe {

	//CONSTANTS
	final static int GRID = 3;		//size of board & grid
	/*** you can set this to any size, but the winning only works for the top 3x3 corner ***/

	final static Color COLOURGRID = new Color(140, 140,140);	
	final static Color COLOURBACK = new Color(240, 240, 240);

	//GLOBAL VARIABLES
	int[][] board = new int[GRID][GRID];
	JFrame frame = new JFrame("TicTacToe");
	JButton restart = new JButton("Play again?");
	JButton exit = new JButton("Exit");
	DrawingPanel gridPanel = new DrawingPanel();

	int XX = 1;
	int OO = -1;
	boolean empty = true;
	int turn = 1;
	int spaceCounter = GRID*GRID;
	boolean xWin = false;
	boolean oWin = false;
	boolean tie = false;


	public static void main(String[] args) {
		new TicTacToe();
	}

	TicTacToe() {		
		createAndShowGUI();
	}

	//This will reset the board if you want to play again.
	//It will be called from the method that checks if you win. If the game is over, reset and then play again
	void initGame() {	
		for(int i=0;i<GRID;i++) {
			for(int j=0;j<GRID;j++) {
				board[i][j]=0;
			}
			xWin=false;
			oWin=false;
			tie=false;
			spaceCounter=0;
			turn=1;
		}
	}

	void createAndShowGUI() {		
		Container content = frame.getContentPane();
		content.setBackground(Color.BLUE);
		content.setLayout(new BorderLayout(2,2));						


		//make main panel

		content.add(gridPanel, BorderLayout.CENTER);

		//finish setting up the frame
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(500, 450);		
		frame.setLocationRelativeTo(null);  //must be AFTER setSize		
		frame.setVisible(true);
	}

	void printBoard() {
		for(int row=0; row<GRID; row++) {
			for(int col=0; col<GRID; col++){
				System.out.printf("%3d", board[row][col]);
			}
			System.out.println();
		}
		//System.out.println("=========="); //print out dividing line of the correct length
		for (int i = 0; i < GRID*3 +2; i++) System.out.print("=");System.out.println();		
	}

	private class DrawingPanel extends JPanel implements MouseListener{

		//instance variables
		int jpanW, jpanH;	//size of JPanel
		int boxW, boxH;	//size of each square		

		DrawingPanel() {
			this.addMouseListener(this);
			restart.addActionListener(new Action1());
			exit.addActionListener(new Action2());
			setBackground(COLOURBACK);

		}

		//** WAS called by createAndShowGUI(), now from paintComponent()
		void initGraphics() {
			jpanW = this.getSize().width;		
			jpanH = this.getSize().height;	

			//Find the size of each box in pixels.  Set boxW, boxH
			boxW = jpanW/GRID;
			boxH = jpanH/GRID;
		}

		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g); //needed for background colour to paint
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			initGraphics(); //needed if the window is resized.

			// Draw grid
			g.setColor(COLOURGRID);
			g.setFont(new Font("Arial",Font.BOLD,boxH*boxW/150));
			for(int i=1;i<GRID;i++) {
				g.drawLine(0,i*boxH,jpanW,i*boxH);//horizontal lines
				g.drawLine(i*boxW,0,i*boxW,jpanH);//vert lines
			}
			if(xWin == true) {
				frame.setTitle("X wins!");
				gridPanel.add(restart);
				gridPanel.add(exit);
				gridPanel.validate();

			}
			if(oWin == true) {
				frame.setTitle("O wins");
				gridPanel.add(restart);
				gridPanel.add(exit);
				gridPanel.validate();

			}
			if(tie==true) {
				frame.setTitle("Tie!");
				gridPanel.add(restart);
				gridPanel.add(exit);
				gridPanel.validate();

			}


			// draw all X and Os
			for(int i=0;i<GRID;i++) {
				for (int j=0;j<GRID;j++) {
					if(board[i][j]==1) {
						g2.setStroke(new BasicStroke(boxW*boxH/1500));
						g.drawLine(boxW*j+boxW/4,boxH*i+boxH/4,boxW*(j)+3*boxW/4,boxH*(i)+3*boxH/4);
						g.drawLine(boxW*j+boxW/4, boxH*i+3*boxH/4, boxW*j+3*boxW/4, boxH*i+boxH/4);
					}else if(board[i][j]==-1) {
						g2.setStroke(new BasicStroke(boxW*boxH/1500));
						g.drawOval(boxW*j+boxW/5,boxH*i+boxH/5,3*boxW/5,3*boxH/5);

					}
				}
			}
			//Check every square in board[][] and draw an X or O there.
			//Try and resize the window while playing. Everything works. 
			g.setColor(Color.RED);
			g2.setStroke(new BasicStroke(2));




		}





		//******************* MouseListener methods *****************//
		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			int col,row;
			//calculate which square you clicked on

			col = x/boxW;
			row = y/boxH;

			// display mouse coords and grid square in title.
			frame.setTitle(x + " " + y + " " + row + " " + col);
			//how to check if click right mouse button
			if (e.getButton() == MouseEvent.BUTTON3) {
				//do something
			}

			/*** put these in methods, maybe one master method ***/


			// Check if the square is empty
			if(board[row][col]==0&&xWin==false&&oWin==false&&tie==false) {
				empty = true;
			}else {
				empty = false;
			}

			//update board
			if(empty==true) {
				if(turn%2==1) {
					board[row][col]=XX;
				}else if(turn%2==0) {
					board[row][col]=OO;
				}
			}

			//check for the winner
			for(int i=0;i<GRID;i++) {
				int counterRow = 0;
				int counterCol = 0;
				int counterDiag1 = 0;
				int counterDiag2 = 0;
				for(int j=0;j<GRID;j++) {
					counterRow += board[i][j];
					if(counterRow==GRID) {
						xWin = true;
					}else if(counterRow==-GRID) {
						oWin = true;
					}
				}
				for(int j=0;j<GRID;j++) {
					counterCol += board[j][i];
					if(counterCol==GRID) {
						xWin = true;
					}else if(counterCol==-GRID) {
						oWin = true;
					}
				}
				for(int j=0;j<GRID;j++) {
					counterDiag1 += board[j][j];
					if(counterDiag1==GRID) xWin=true;
					if(counterDiag1==-GRID) oWin=true;
				}
				for(int j=0;j<GRID;j++) {
					counterDiag2 += board[j][(GRID-1)-j];
					if(counterDiag2==GRID) xWin=true;
					if(counterDiag2==-GRID) oWin=true;
				}
			}
			//check for tie
			if(empty==true) {
				spaceCounter--;
			}

			System.out.println(spaceCounter);
			if(spaceCounter==0 && xWin==false &&oWin==false) {
				tie=true;
			}

			//change turn
			if (empty==true) {
				turn++;
			}

			this.repaint();
			printBoard();
		}	

		class Action1 implements ActionListener{//pause and resume
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<GRID;i++) {
					for(int j=0;j<GRID;j++) {
						board[i][j]=0;
					}
					xWin=false;
					oWin=false;
					tie=false;
					spaceCounter=0;
					turn=1;
				}
				gridPanel.remove(restart);
				gridPanel.remove(exit);
			}	
		}
		class Action2 implements ActionListener{//pause and resume
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}	
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}

	} //end of DrawingPanel class

}