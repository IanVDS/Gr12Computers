package Strings;
public class StringNumbers {

	public static void main(String[] args) {
		String s= "He has sneezed for the 5th time"; 
		for(int i=0;i<s.length();i++) {
			if(Integer.valueOf(s.charAt(i))>=48 && Integer.valueOf(s.charAt(i))<=57){
				int x = Integer.valueOf(s.charAt(i));
				int y = x+1;
				s=s.replace((char)x, (char)y);			
			}
		}
		System.out.println(s);
	}
}
