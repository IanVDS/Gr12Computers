package Graphics.ArrayMaps;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Starting class for MapContinent program

public class MapContinent
{
	public static void main(String[] args) {
		new MapContinent();
	}

	//constants	
	final static int GRID = 64; //size of grid/board
	final static int SQSIZE = 15; // size of each square in pixels
	final static int NUM_LAND = (GRID * GRID /2); //number of land tiles
	//terrain
	final static int EMPTY = 0;		//constant for empty tile. This is the terrain that needs to be a specific value (since arrays are initialized to zero)
	final static int LAND = 1;		//contant for land tile
	final static int LAKE = 33;		//this is just any number used for LAKE and OCEAN
	final static int OCEAN = 89;
	//colours: you can change these
	final static Color COLOURBACK = new Color(242,242,242);	
	final static Color COLOUREMPTY = new Color(222,222,222);
	final static Color COLOURLAND = new Color(100,200,100);
	final static Color COLOURLAKE = new Color(100,100,255);
	final static Color COLOUROCEAN = new Color(10,10,130);

	//global variables
	int[][] board = new int[GRID][GRID];


	int contNum = (int)(Math.random()*4)+1;
	int landTiles = 0;
	MapContinent() {	//constructor
		initGame();
		createAndShowGUI();
	}

	void initGame() {		
		//clear board
		for (int i=0;i<GRID;i++) {
			for (int j=0;j<GRID;j++) {
				board[i][j]=EMPTY;
			}
		}

//						makeRandomMap();
		makeContinents();
	}


	void makeContinents() {
		for(int i=0;i<contNum;i++) {
			double x=Math.random()*GRID;
			double y=Math.random()*GRID;
			board[(int)x][(int)y]=LAND;
			landTiles++;
		}
		contGrow();
	}
	
	void contGrow() {
		while(landTiles<=NUM_LAND) {
			for(int i=0;i<GRID;i++) {
				for(int j=0;j<GRID;j++) {

					double chanceLand = Math.random();
					if(board[i][j]==EMPTY&&landTiles<=NUM_LAND) {
						if(landAdj(i,j)==0&&chanceLand<0.001) {
							board[i][j]=LAND;
							landTiles++;
						}
						if(landAdj(i,j)==1&&chanceLand<0.3) {
							board[i][j]=LAND;
							landTiles++;
						}
						if(landAdj(i,j)==2&&chanceLand<0.4) {
							board[i][j]=LAND;
							landTiles++;
						}
						if(landAdj(i,j)==3&&chanceLand<0.5) {
							board[i][j]=LAND;
							landTiles++;
						}
						if(landAdj(i,j)==4&&chanceLand<0.9) {
							board[i][j]=LAND;
							landTiles++;
						}
						
						if(landTiles>=NUM_LAND) break;

					}
					if(landTiles>=NUM_LAND) break;		
				}
			}
		}
	}
	
	int landAdj(int x, int y) {//counts adjacent land tiles
		int landCount = 0;
			if(x+1<GRID) {
				if(board[x+1][y]==LAND)landCount++;
			}
			if(x-1>=0) {
				if(board[x-1][y]==LAND)landCount++;
			}
			if(y+1<GRID) {
				if(board[x][y+1]==LAND)landCount++;
			}
			if(y-1>=0) {
				if(board[x][y-1]==LAND)landCount++;
			}
		return landCount;
	}

	void makeRandomMap() {
		for(int i=0;i<GRID;i++) {
			for(int j=0;j<GRID;j++) {

				board[i][j]=(int)(Math.random()*2)%2;

				if(board[i][j]==1) {
					landTiles++;
				}

				if(landTiles==NUM_LAND) break;
			}
		}
	}

	void findLakes(int x, int y) {
		if(x==0||y==0||x==GRID-1||y==GRID-1) {//finds oceans when lake touches edge of board
			findOceans(x,y);
		}
		if(x>=0&&y>=0&&x<GRID&&y<GRID) {//for lakes in the middle of the map
			if (board[x][y] == EMPTY) board[x][y] = LAKE;
			if(y+1<=GRID-1) {
				if(board[x][y+1]==EMPTY) {
					findLakes(x,y+1);
				}
			}
			if(y-1>=0) {
				if(board[x][y-1]==EMPTY) {
					findLakes(x,y-1);
				}
			}
			if(x+1<=GRID-1) {
				if(board[x+1][y]==EMPTY) {
					findLakes(x+1,y);
				}
			}
			if(x-1>=0) {
				if(board[x-1][y]==EMPTY) {
					findLakes(x-1,y);

				}
			}
		}
	}
	
	void findOceans(int x, int y) {//checks for oceans and changes lakes to oceans
		if(board[x][y]==LAKE) {
			board[x][y]=OCEAN;
		}
		if(x+1<GRID) {
			if(board[x+1][y]==LAKE||board[x+1][y]==EMPTY) {
				board[x+1][y]=OCEAN;
				findOceans(x+1,y);
			}
		}
		if(x-1>=0) {
			if(board[x-1][y]==LAKE||board[x-1][y]==EMPTY) {
				board[x-1][y]=OCEAN;
				findOceans(x-1,y);
			}
		}
		if(y+1<GRID) {
			if(board[x][y+1]==LAKE||board[x][y+1]==EMPTY) {
				board[x][y+1]=OCEAN;
				findOceans(x,y+1);
			}
		}
		if(y-1>=0) {
			if(board[x][y-1]==LAKE||board[x][y-1]==EMPTY) {
				board[x][y-1]=OCEAN;
				findOceans(x,y-1);
			}
		}
	}



	void createAndShowGUI() {
		JFrame frame = new JFrame("Map Continent");
		DrawingPanel panel = new DrawingPanel();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Container content = frame.getContentPane();	
		content.add(panel, BorderLayout.CENTER);		
		frame.setResizable(true);		
		frame.pack();
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);

		panel.initGraphics();

	}

	class DrawingPanel extends JPanel	//inner class
	{		
		int jpanW, jpanH;
		int blockX, blockY;		

		public DrawingPanel() {
			setBackground(COLOURBACK);
			this.setPreferredSize(new Dimension(GRID*SQSIZE,GRID*SQSIZE));
			MyMouseListener ml = new MyMouseListener();
			addMouseListener(ml);			
		}

		void initGraphics() {
			jpanW = this.getSize().width;		
			jpanH = this.getSize().height;	
			blockX = (int)((jpanW/GRID)+0.5);
			blockY = (int)((jpanH/GRID)+0.5);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

//			Draw white grid
			g.setColor(Color.WHITE);
			for (int i=0;i<GRID;i++) {
				g.drawLine(blockX*i,0,blockX*i,jpanH);
				g.drawLine(0,blockY*i,jpanW,blockY*i);
			}

			for (int i=0;i<GRID;i++) {
				for (int j=0;j<GRID;j++) {
					colourRect(i,j,g);						
				}
			}			
		}

		void colourRect(int i, int j, Graphics g) {

			int terrain = board[i][j];

			if (terrain == EMPTY) {
				g.setColor(COLOUREMPTY);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}
			if (terrain == LAND) {
				g.setColor(COLOURLAND);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}			
			if (terrain == LAKE) {
				g.setColor(COLOURLAKE);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}
			if (terrain == OCEAN) {
				g.setColor(COLOUROCEAN);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}			
		}

		class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				//calculate which square you clicked on
				int i = (int)  x/blockX;
				int j = (int) y/blockY;	// blockY/y

				//allow the right mouse button to toggle/cycle the terrain
				if (e.getButton() != MouseEvent.BUTTON1) {
//					switch (board[i][j]) {
//					case LAND:
//						board[i][j] = EMPTY;
//						break;
//					default:
//						board[i][j] = LAND;
//					}
					contNum = (int)(Math.random()*4)+1;
					landTiles=0;
					initGame();
					makeContinents();
					repaint();
					return;
				}

				if(board[i][j]==EMPTY)findLakes(i,j);								
				repaint();
			}
		} //end of MyMouseListener class
		
		
		class MyKeyListener implements KeyListener{
			public void keyPressed(KeyEvent e) {	
					if(e.getKeyCode()==KeyEvent.VK_SPACE) {
						contNum = (int)(Math.random()*4)+1;
						landTiles=0;
						initGame();
						makeContinents();
						repaint();
						return;
					}
				}

			public void keyTyped(KeyEvent e) {}

			public void keyReleased(KeyEvent e) {}
			}
	} //end of DrawingPanel class

}