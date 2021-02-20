/**
 * Initializes the HashMap books and creates methods to get the instance of the static library, checks out books, checks in books, and displays the books.
 * @author Kyrtis Scott
 *
 */
import java.util.HashMap;
import java.util.Map;

public class Library {
	private HashMap<String, Integer> books = new HashMap<String,Integer>();
	private static Library library;
	
	/**
	 * Constructor for the library and prints out "Creating our Library. Time to begin reading.".
	 */
	private Library() {
		System.out.println("Creating our Library. Time to begin reading.");
	}
	
	/**
	 * Checks to see if the static instance of the library is already created, if not then it creates a new one.
	 * @return returns the instance of the library that was already there, or returns the created instance.
	 */
	public static Library getInstance() {
		if(library == null) {
			library = new Library();
		}
		return library;
	}
	
	/**
	 * Checks to see if the book name is held within the hashmap books, if the book count is above 0, then the book is in stock and subtracts the book stock
	 * number by 1 and says that book is then checked out.. If the book is not in stock, the book cannot be checked out. 
	 * @param bookName passes in the books name to be checked within the hashmap.
	 * @return returns true if the book is currently in stock, and false if the book is not in stock.
	 */
	public boolean checkoutBook(String bookName) {
		if(books.containsKey(bookName)) {
			int count = books.get(bookName);
			if(count >= 1) {
				books.put(bookName, count-1);
				System.out.println(bookName + " was successfully checked out");
				return true;
			}
			else {
				System.out.println("Sorry " + bookName + " is not in stock");
			}
		}
		return false;
	}
	
	/**
	 * Checks to see if the book is within the hashmap and adds it if it is not. If the book is within the hashmap, It adds another count of the book.
	 * @param bookName This is the books name to either be checked within the hashmap or added to the hashmap.
	 * @param numToAdd This is the book amount to be added to the hasmap or increased by the amount of the book that has been checked in.
	 */
	public void checkInBook(String bookName, int numToAdd) {
		if(books.containsKey(bookName)) {
			int count = books.get(bookName);
			books.put(bookName,  count + numToAdd);
		}
		else {
			books.put(bookName,  numToAdd);
		}
		System.out.println(bookName + " was added to the library.");
	}
	
	/**
	 * Iterates through the hashmap, for each book, displays the name of the book, and the number of copies.
	 */
	public void displayBooks() {
		System.out.println("Inventory:");
		for(Map.Entry<String, Integer> entry : books.entrySet()) {
			System.out.println("- " + entry.getKey() + ", copies: " + entry.getValue());
		}
	}
}
