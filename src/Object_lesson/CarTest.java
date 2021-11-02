package Object_lesson;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car("Toyota", 5000);
		Car car2 = new Car("Jaguar",12);
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		car1.drive(200);
		System.out.println(car1.toString());
	}

}
