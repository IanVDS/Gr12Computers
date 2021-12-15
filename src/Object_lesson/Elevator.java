package Object_lesson;
class Elevator {
	final static String manufacturer = "Otis";
	final static int topFloor = 10;
	final static int maxOccupants = 25;
	static boolean powerOn = true;
	
	private int people=0;
	private int floor=1;
	private boolean doorsOpen = false;
	
	Elevator(int floor){
		if(floor < 0||floor >topFloor) floor=1;
		this.floor=floor;
	}
	Elevator(){}
	
	static void setPowerState(boolean power) {
		if(power!=powerOn)System.out.println("Power state has changed");
	}
	static boolean getPowerState() {
		return powerOn;
	}
	
	void up() {
		if(powerOn && people<=maxOccupants && floor<topFloor && !doorsOpen) floor++;
		else if(!powerOn)System.out.println("Power not on");
		else if(people>maxOccupants)System.out.printf("\nThere must be less than %d people",maxOccupants);
		else if(floor>topFloor)System.out.println("That floor does not exist!");
		else if(doorsOpen)System.out.println("Doors must be closed!");
	}
	
	void down() {
		if(powerOn && people<=maxOccupants && floor>1 && !doorsOpen) floor--;
		else if(!powerOn)System.out.println("Power not on");
		else if(people>maxOccupants)System.out.printf("\nThere must be less than %d people",maxOccupants);
		else if(floor<1)System.out.println("That floor does not exist!");
		else if(doorsOpen)System.out.println("Doors must be closed!");
	}
	
	void addPeople(int n) {
		if(doorsOpen && people+n<=maxOccupants && n>0)people+=n;
		else if(!doorsOpen)System.out.println("Doors are closed");
		else if(people+n>maxOccupants)System.out.println("Too many people");
		else if(n<=0)System.out.println("A positive number of people must be added");
	}
	
	void removePeople(int n) {
		if(doorsOpen && people-n>=0 && n>0)people-=n;
		else if(!doorsOpen)System.out.println("Doors are closed");
		else if(people-n<0)System.out.println("There must be more than sero people");
		else if(n<=0)System.out.println("A negative number of people must be added");
	}
	
	@Override
	public String toString() {
		String s = "Manufacturer = " + manufacturer + ", floor = " + floor + ", people = " + people + ", door = " + doorsOpen;
		s = "Building power is " + (powerOn ? "ON" : "OFF") + s;
		return s;
	}
	
	
}
