package Object_lesson;
//Ian Van den Steen
class Elevator {
	final static String manufacturer = "Otis";
	final static int topFloor = 10;
	final static int maxOccupants = 25;
	static boolean powerOn = true;
	
	public int people=0;
	public int floor=1;
	private boolean doorsOpen = false;
	
	Elevator(int floor){
		if(floor < 0||floor >topFloor) floor=1;
		this.floor=floor;
		
	}
	Elevator(){}
	
	static void setPowerState(boolean power) {
		if(power!=powerOn)System.out.println("Power state has changed");
		powerOn = power;
		if(powerOn && powerOn==power)System.out.println("Power already on");
		if(!powerOn && powerOn==power)System.out.println("Power already off");
		
	}
	
	static boolean getPowerState() {
		return powerOn;
	}
	
	void up() {
		if(powerOn && people<=maxOccupants && floor<topFloor && !doorsOpen) {
			floor++;
			System.out.println("The elevator is at floor " + floor);
		}
		if(!powerOn)System.out.println("Power not on");
		if(people>maxOccupants)System.out.printf("There must be less than %d people\n",maxOccupants);
		if(floor>topFloor)System.out.println("That floor does not exist!");
		if(doorsOpen)System.out.println("Doors must be closed!");
	}
	
	void goToFloor(int n) {
		if(powerOn && people<=maxOccupants && n<topFloor  && n>=1 && !doorsOpen) {
			floor=n;
			System.out.println("You are on floor "+floor);
		}
		if(!powerOn)System.out.println("Power not on");
		if(people>maxOccupants)System.out.printf("There must be less than %d people\n",maxOccupants);
		if(n>topFloor || n<1)System.out.println("That floor does not exist!");
		if(doorsOpen)System.out.println("Doors must be closed!");
	}
	
	void down() {
		if(powerOn && people<=maxOccupants && floor>1 && !doorsOpen) {
			floor--;
			System.out.printf("\nElevator is on floor %d",floor);
		}
		if(!powerOn)System.out.println("Power not on");
		if(people>maxOccupants)System.out.printf("There must be less than %d people\n",maxOccupants);
		if(floor<1)System.out.println("That floor does not exist!");
		if(doorsOpen)System.out.println("Doors must be closed!");
	}
	
	void printFloor() {
		System.out.println(floor);
	}
	
	//methods for switching power and doors
	void openDoors() {
		if(doorsOpen) System.out.println("Doors are already open");
		if(!doorsOpen && powerOn) {
			doorsOpen=true;
			System.out.println("Doors are open");
		}
		if(!powerOn)System.out.println("Power not on");
	}
	
	void closeDoors() {
		if(!doorsOpen)System.out.println("Doors are already closed");
		if(doorsOpen && powerOn) {
			doorsOpen=false;
			System.out.println("Doors are closed");
		}
		if(!powerOn)System.out.println("Power not on");
	}
	
	void switchDoors() {
		if(powerOn)doorsOpen= !doorsOpen;
		if(!powerOn)System.out.println("Power not on");
	}
	
	void switchPower() {
		powerOn=!powerOn;
	}
	
	
	//methods for adding and removing people
	void addPeople(int n) {
		if(doorsOpen && people+n<=maxOccupants && n>0) {
			people+=n;
			System.out.printf("There are %d people\n",people);
		}
		if(!doorsOpen)System.out.println("Doors are closed");
		if(people+n>maxOccupants)System.out.println("Too many people");
		if(n<=0)System.out.println("A positive number of people must be added");
	}
	
	void removePeople(int n) {
		if(doorsOpen && people-n>=0 && n>0) {
			people-=n;
			System.out.printf("There are %d people\n",people);
		}
		if(!doorsOpen)System.out.println("Doors are closed");
		if(people-n<0)System.out.println("There must be more than zero people");
		if(n<=0)System.out.println("A negative number of people must be added");
	}
	
	@Override
	public String toString() {
		String s = "Manufacturer = " + manufacturer + ", floor = " + floor + ", people = " + people + ", door = " + doorsOpen;
		s = "Building power is " + (powerOn ? "ON" : "OFF") + s;
		return s;
	}
	
	
}
