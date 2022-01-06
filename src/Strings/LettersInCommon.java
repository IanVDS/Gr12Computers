package Strings;

public class LettersInCommon {

	public static void main(String[] args) {
		String s2[] = {"guyana", "lotion", "chilly", "doggie", "fledgy", "swanky", "crawly", "physic"};
		String s3 = "digger";
		String sharedWord="";
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

				if(sharedLtr>maxShared) {
					maxShared=sharedLtr;
					sharedWord = s2[i];
				}
			}
		}
		System.out.println(maxShared);
		System.out.println(sharedWord);
	}

}
