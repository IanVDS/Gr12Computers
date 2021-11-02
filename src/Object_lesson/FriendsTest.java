package Object_lesson;

import java.util.ArrayList;

/*Ian Van den Steen
 * Sept. 21, 2021
 * Mr. Harwood
 */
public class FriendsTest {
	static ArrayList<Friend> contactList = new ArrayList<Friend>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Friend friend1 = new Friend ("Ben","M",12345,12345);
		
		contactList.add(friend1);
		
		contactList.add(new Friend("Nikola","S"));
		contactList.add(new Friend("Michael","C"));
		
		
		printContacts1();
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println();
		deleteContact();
		printContacts1();

	}
	static void printContacts1(){
		//if constrNum == 1
		for (int i=0;i<contactList.size();i++) {
			Friend a = contactList.get(i);
			System.out.println("First name:\t" + a.FirstName);
			System.out.println("Last name:\t" + a.LastName);
			
			if (a.PhoneNumber != 0) {
			System.out.println("Phone number:\t" + a.PhoneNumber);
			}
			
			if (a.BDay!= 0) {
				System.out.println("Birthday:\t" + a.BDay);
			}
			System.out.println();

		}
	}
	static void deleteContact() {
		for (int i=0;i<contactList.size();i++) {
			Friend a = contactList.get(i);
			if (a.FirstName.equals("Michael")) {
				contactList.remove(i);
			}
		}
	}

}
