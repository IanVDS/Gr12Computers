package ArrayReview;
import java.lang.Math.*;
public class ArrayReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rndmNum[] = {1,2,3,4,5,6,7,8};
		int bigNum = 0;
		int smallNum = 100;
		
		
		for (int x=0;x<rndmNum.length;x++) {
			rndmNum[x] = (int)(Math.random()*100);
			System.out.println((x+1) + " | " + rndmNum[x]);
			if (rndmNum[x] > bigNum) {
				bigNum = rndmNum[x];
			}
			if (rndmNum[x] < smallNum) {
				smallNum = rndmNum[x];
			}
			
		}

		System.out.println("The biggest number is:\t" + bigNum);
		System.out.println("The smallest number is:\t" + smallNum);
		
	}

}
