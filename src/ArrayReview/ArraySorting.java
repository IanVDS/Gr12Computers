package ArrayReview;
/* Ian Van den Steen
 * Sept.21, 2021
 * Mr. Harwood
 */
public class ArraySorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp;
		int rndmNum[] = new int[10];
		for (int x=0;x<rndmNum.length;x++) {
			rndmNum[x] = (int)(Math.random()*100);
			System.out.print(rndmNum[x] + " ");
		}

		System.out.println();
		System.out.println("----------------------");
		System.out.println();



		for(int a=0;a<rndmNum.length;a++) {
			for (int y=0;y<rndmNum.length;y++) {
				System.out.print(rndmNum[y] + " ");
			}
			System.out.println();
			for (int j=0;j<rndmNum.length;j++) {
				
				
				if (rndmNum[a]<rndmNum[j]) {
					temp=rndmNum[a];
					rndmNum[a]=rndmNum[j];
					rndmNum[j]=temp;

				}
			}
			
		}

		for(int y=0;y<(rndmNum.length);y++) {
			System.out.print(rndmNum[y] + " ");
		}
	}

}
