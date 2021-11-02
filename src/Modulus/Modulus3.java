package Modulus;
/* Ian Van den Steen
 * Sept. 23, 2021
 * Mr. Harwood
 */
public class Modulus3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<200;i++) {
			if(i%12==0) {
				System.out.printf("%5d \n",i);
			}else {
				System.out.printf("%5d",i);
			}
		}
	}

}
