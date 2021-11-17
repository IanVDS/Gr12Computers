package Graphics.ArrayMaps;

public class ArrayMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<SIZE;i++) {
			map[i][0]=10;
			map[i][SIZE-1]=10;
			map[0][i]=10;
			map[SIZE-1][i]=10;
		}
		if(SIZE>8) {
			map[8][2]=99;
		}
		printBoard();
	}
	//Global variables
	private static final int SIZE = 10;
	private static int[][] map = new int[SIZE][SIZE];
	
	
	
	static void printBoard() {
		for(int row=0; row<SIZE; row++) {
			for(int col=0; col<SIZE; col++){
				System.out.printf("%3d", map[row][col]);
			}
			System.out.println();
		}
		//System.out.println("=========="); //print out dividing line of the correct length
		for (int i = 0; i < SIZE*3 +2; i++) System.out.print("=");System.out.println();		
	}
}
