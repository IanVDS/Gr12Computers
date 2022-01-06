package Strings;

public class randomWord {

	public static void main(String[] args) {
		
		//variables
		String consenants = "bcdfghjklmnpqrstvwxz";
		String vowels = "aeiouy";
		String rndmWord = "";
		int vwlIndx[]=new int[(int) (Math.round(Math.random())+1)];
		
		for(int i=0;i<6;i++) {
			rndmWord = rndmWord + consenants.charAt((int)(Math.random()*20));
		}
		
		System.out.println(rndmWord);//prints original 6 consenants

		for(int i=0;i<vwlIndx.length;i++) {
			vwlIndx[i]=(int)(Math.random()*6);
		}
		
		
		if(vwlIndx.length==2) {//makes sure they are not the same
			while(vwlIndx[0]==vwlIndx[1]) vwlIndx[1] = (int)(Math.random()*6);
		}
		
		char rndmwordArray[] = rndmWord.toCharArray();
		
		
		for(int i=0;i<vwlIndx.length;i++) {
			rndmwordArray[vwlIndx[i]]=vowels.charAt((int)(Math.random()*6));
		}
		
		rndmWord = rndmWord.copyValueOf(rndmwordArray);
		
		System.out.println(vwlIndx.length);//prints number of vowels
		for(int i=0;i<vwlIndx.length;i++) System.out.println(vwlIndx[i]);//prints indexes of vowels
		System.out.println(rndmWord);
	}

}
