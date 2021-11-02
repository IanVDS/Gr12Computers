
public class Printf_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%.5f %n",1.0/7.0);
		
		String name = "Bessy";
		String color = "brown";
		int weight = 1200;
		System.out.printf("The cow's name is %s, she is %s and weighs %dkg%n",name,color,weight);
		
		int xx=123;
		System.out.println("| 12345678 |");
		System.out.println("| ======== |");
		System.out.printf("| %8d |%n",xx);
		System.out.printf("| %08d |%n",xx);
		System.out.printf("| %+8d |%n",xx);
		System.out.printf("| %-8d |%n",xx);
		System.out.printf("| %8.1f |%n",(double)xx);
	}

}
