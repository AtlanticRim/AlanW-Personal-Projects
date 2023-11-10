
public class TestBook {
	public static void main(String[] args) {
		Book book1 = new Book("Introduction to Java Programming and Data Structures", "Y. Daniel Liang", "Pearson", "202004417");
		Book book2 = new Book("Ready Player One", "Ernest Cline", "Crown", "9780307887436");
		Book blankBook = new Book();
		System.out.println("Book 1 is: " + book1.toString());
		System.out.println("Book 2 is: " + book2.toString());
		System.out.println("This book is blank: " + blankBook.toString());
	}
}	
	
class Book{
	String author;
	String title;
	String ISBN;
	String publisher;
	
	Book(){
		author = "";
		title = "";
		ISBN = "";
		publisher = "";
	}
	
	Book(String inputTitle, String inputAuthor, String inputPublisher, String inputISBN){
		author = inputAuthor;
		title = inputTitle;
		ISBN = inputISBN;
		publisher = inputPublisher;
	}
	
	String getAuthor() {
		return author;
	}
	
	void setAuthor(String newAuthor) {
		author = newAuthor;
	}
	
	String getTitle() {
		return title; 
	}
	
	void setTitle(String newTitle) {
		title = newTitle;
	}
	
	String getISBN() {
		return ISBN;
	}
	
	void setISBN(String newISBN) {
		ISBN = newISBN;
	}
	
	String getPublisher() {
		return publisher;
	}
	
	void setPublisher(String newPublisher) {
		publisher = newPublisher;
	}
	
	public String toString() {
		getTitle();
		getAuthor();
		getPublisher();
		getISBN();
		return title + ", " + author + ", " + publisher + ", " + ISBN;
	}
}
