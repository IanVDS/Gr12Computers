package package1;

public class Global {
	static int x = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -10;
		x++;
		//printme(x, 99);
		printx();
		//if it's static:
		Global.x = 77;
		
		//if it's not static use this:
		//this.x = 77;
	}
	
	static void printme(int x, int z) {
		System.out.println(x);
		System.out.println(z);
	}
	
	static void printx() {
		System.out.println(x);
	}
}
