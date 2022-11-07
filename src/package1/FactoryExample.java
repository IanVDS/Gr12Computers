package package1;

class FactoryExample{
	public static void main(String[] args) {
		BookFactory2 bookFactory = new BookFactory2();
		
		//get an object of hardcover
		Book book1 = bookFactory.getType("softcover");
		book1.getRate();
		book1.calculateBill(10);
		
		Book book2 = bookFactory.getType("Softcover");
		book2.getRate();
		book2.calculateBill(10);
		Book book3 = bookFactory.getType("eBook");
		book3.getRate();
		book3.calculateBill(10);//hello
	}
}
abstract class Book {//superclass
	static int rate;
	void getRate() {
		
	}

	public void calculateBill(int units) {
		System.out.println(units*rate + " dollars");
	}


}class HardCover extends Book{//subclass

	@Override
	void getRate() {
		rate=20;
	}

}class SoftCover extends Book{//subclass

	@Override
	void getRate() {
		rate=10;
	}

}class eBook extends Book{//subclass

	@Override
	void getRate() {
		rate = 5;
	}

} class BookFactory2{
	public Book getType(String bookType){
	      if(bookType == null){
	         return null;
	      }		
	      if(bookType.equalsIgnoreCase("EBOOK")){
	         return new eBook();
	         
	      } else if(bookType.equalsIgnoreCase("SOFTCOVER")){
	         return new SoftCover();
	         
	      } else if(bookType.equalsIgnoreCase("HARDCOVER")){
	         return new HardCover();
	         
	      }
	      
	      return null;
	   }
}

