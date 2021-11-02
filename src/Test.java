
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [ ] [ ] array = new int [3][5];
		int k=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				k = k + 1;
				array[i][j] = k;
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 1; i < 2; i++) {
			for (int j = 4; j > 0; j--) {
				System.out.print(array[i][j]);
			}
			System.out.println();
			}

	

	}
	
}