package Strings;
//Ian Van den Steen
public class StringProgs {
	public static void main(String[] args) {
		//increasing numbers
		String s= "He has sneezed for the 5th time"; 
		for(int i=0;i<s.length();i++) {
			if(Integer.valueOf(s.charAt(i))>=48 && Integer.valueOf(s.charAt(i))<=57){
				int x = Integer.valueOf(s.charAt(i));
				int y = x+1;
				s=s.replace((char)x, (char)y);			
			}
		}
		System.out.println(s);
		
		
		System.out.println();
		
		
		//letters in common
		String s2[] = {"guyana", "lotion", "chilly", "doggie", "fledgy", "swanky", "crawly", "physic"};
		String s3 = "digger";
		int maxShared = 0;
		for(int i=0;i<s2.length;i++){//iterates through array
			int sharedLtr=0;

			for(int j=0;j<s2[i].length();j++) {//checks a char in a word in the array

				for(int k=0;k<s3.length();k++) {//checks each char in the word
					boolean alreadyCompared=false;
					for (int h=k-1;h>=0;h--) {
						if(s3.charAt(k)==s3.charAt(h)) alreadyCompared=true;
					}
					if(!alreadyCompared && s3.charAt(k)==s2[i].charAt(j)) {
						sharedLtr++; 
					}else alreadyCompared=false;
				}

				if(sharedLtr>maxShared) maxShared=sharedLtr;
			}
		}
		System.out.println(maxShared);
		
		
		System.out.println();
		
		
		//random word
		String consenants = "bcdfghjklmnpqrstvwxz";
		String vowels = "aeiouy";
		String rndmWord = "";
		for(int i=0;i<6;i++) {
			rndmWord = rndmWord + consenants.charAt((int)(Math.random()*20));
		}
		int vwlIndx[] = {(int)Math.random()*6,(int)Math.random()*6};//index of vowel 1
		while(vwlIndx[0]==vwlIndx[1]) vwlIndx[1] = (int)(Math.random()*6);//makes sure they are not the same
		
		for(int i=0;i<2;i++) {
			rndmWord = rndmWord.replace(rndmWord.charAt(vwlIndx[i]),vowels.charAt((int)(Math.random()*6)));
		}
		System.out.println(rndmWord);
	}
}
