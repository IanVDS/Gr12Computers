package Object_lesson;

class Car {
	//instance variables
	final String make;
	private int odometer;
	
	//constructors
	Car(String make){
		this.make = make;
	}
	
	private Car(){
		make = "unknown";
	}
	
	Car(String make, int odo){
		this.make = make;
		odometer = odo;
	}
	
	//instance methods (no static)
	//apply to each object individually
	
	void drive(int distance) {
		this.odometer += Math.abs(distance);
	}
	
	int getOdometer() {return odometer;}
	void setOdometer (int n) {
		
	}
	
	@Override
	public String toString(){
		//return one line of text
		String s = "Make = " + make + "\tOdometer = " + odometer;
		return s;
	}
	
	
}

