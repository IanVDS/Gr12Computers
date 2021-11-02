package Object_lesson;
import java.util.ArrayList;

public class MovieList {
	
	//Global variables
	static ArrayList<Movie> movieList = new ArrayList<Movie>();
	//static variables
	static String storename = "Jumbo video";
	//instance variables
	String title;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie m = new Movie("The Avengers", 2015, 5);
		movieList.add(m);
		System.out.println(m.title + " " + m.rating);

		Movie m2 = new Movie("Jurassic Park",1997,4);
		movieList.add(m2);
		System.out.println(m2.title + " " + m2.rating);

		movieList.add(new Movie("Endgame", 2020, 5));

		System.out.println(movieList.size());

	}




	static void printList(){
		for (int i=0;i<movieList.size();i++) {
			Movie movie = movieList.get(i);
			System.out.println(movie.title + "\t" + movie.year + " Stars: " + movie.rating);
		}
	}
	
	static void printList2(){
		for (Movie movie : movieList) {
			System.out.println(movie.title + "\t" + movie.year + " Stars: " + movie.rating);
		}
	}
	
	static class Movie {
		String title;
		//String genre;
		int year = 2020;//
		int rating;//0-5

		//constructor
		Movie(String t, int year, int rating){
			title = t;
			this.year = year;
			if (rating > 5 || rating < 0) rating = 1;

			this.rating = rating;
		}
	}
}