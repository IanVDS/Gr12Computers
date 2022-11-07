package package1;
//Ian Van den Steen

import java.lang.Math.*;
public class SplittingDigits {

	public static void main(String[] args) {
		int number = (int)(Math.random()*(99-10)+10);
		
		String stringOfNum = "" + number;
		String tensDigitString = "";
		String onesDigitString = "";
		
		int tensDigit = (number/10);
		int tensDivisor = (tensDigit * 10);
		int onesDigit = 0;
		
		
		//random number
		System.out.println(number);
		System.out.println();
		
		//1st method
		tensDigitString = stringOfNum.substring(0,1);
		onesDigitString = stringOfNum.substring(1);
		
		System.out.println(tensDigitString);
		System.out.println(onesDigitString);
		
		System.out.println();
		
		//2nd method
		onesDigit = number - tensDivisor;
		System.out.println(tensDigit);
		System.out.println(onesDigit);
		
		System.out.println();
		
		//third method
		int onesDigit2 = number%10;
		int tensDigit2 = (number - onesDigit2) / 10;
		
		System.out.println(tensDigit2);
		System.out.println(onesDigit2);
	}

}
