package Strings;
public class StringNumbers {

	public static void main(String[] args) {
		//Numbers
		String s= "He has sneezed for the 1234th time"; 
		
		char charS[] = s.toCharArray();
		
		for(int i=0;i<s.length();i++) {
			if(Integer.valueOf(charS[i])>=48 && Integer.valueOf(charS[i])<=57){
				int x = Integer.valueOf(charS[i]);
				int y = x+1;
				charS[i]=(char)y;			
			}
		}
		
		s = s.copyValueOf(charS);
		System.out.println(s);	
	}
}
