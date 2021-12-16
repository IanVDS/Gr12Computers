package Object_lesson;
//Ian Van den Steen
public class ElevatorTest {

	public static void main(String[] args) {
		Elevator south = new Elevator();
		Elevator east = new Elevator(5);
		south.openDoors();
		south.addPeople(10);
		south.closeDoors();
		south.goToFloor(4);
		south.openDoors();
		south.removePeople(3);
		south.closeDoors();
		south.goToFloor(Elevator.topFloor);
		south.removePeople(south.people);
		east.openDoors();
		east.addPeople(8);
		east.closeDoors();
		east.goToFloor(8);
		east.openDoors();
		east.addPeople(30);
		east.closeDoors();
		east.goToFloor(40);
		east.goToFloor(-7);
		east.goToFloor(2);
		south.goToFloor(2);
		east.openDoors();
		Elevator.setPowerState(false);
		south.up();
		east.closeDoors();
		Elevator.setPowerState(true);
		Elevator.setPowerState(true);
		south.goToFloor(1);
		for(int i=0;i<Elevator.topFloor;i++) {
			south.up();
			south.openDoors();
			south.closeDoors();
		}

		
		
		
		
		
		
		
	}

}
