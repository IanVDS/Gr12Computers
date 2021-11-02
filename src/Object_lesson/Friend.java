package Object_lesson;

import java.util.ArrayList;

/*Ian Van den Steen
 *Sept. 21, 2021
 *Mr. Harwood
 */
class Friend {
	String FirstName = "";
	String LastName = "";
	int PhoneNumber;
	int BDay;





	//constructor
	Friend(String FS, String LS, int PN, int BD){
		FirstName = FS;
		LastName = LS;
		PhoneNumber = PN;
		BDay = BD;

	}
	Friend(String FS){
		FirstName = FS;
	}
	Friend(String FS, String LS){
		FirstName = FS;
		LastName = LS;
	}
	Friend(String FS, String LS, int PN){
		FirstName = FS;
		LastName = LS;
		PhoneNumber = PN;
	}



	@Override
	public String toString(){
		String s = FirstName + " " + LastName + "\n" + PhoneNumber + "\n" + BDay;
		return s;
	}

	
}