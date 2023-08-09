package fa.training.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Book;

public class BookService {
	private Scanner sc = new Scanner(System.in);
	private static List<Book> books = new ArrayList<>();;
	private Book book;
	private String isbn;
	private String author;
	private String publicationPlace;
	private String input;
	private int publicationYear;
	private String publisher;
	private Date publicationDate;

	private boolean status;

	public static List<Book> getAllBook() {
		return books;
	}

	public void addNewBook() {
		book = new Book();
		System.out.println("---Enter book information---");

		do {
			try {
				status = false;
				System.out.print("Enter publication year: ");
				publicationYear = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				status = true;
			}
		} while (status);
		book.setPublicationYear(publicationYear);

		System.out.print("Enter publisher: ");
		publisher = sc.nextLine();
		book.setPublisher(publisher);

		do {
			try {
				status = false;
				System.out.print("Enter publication date: ");
				publicationDate = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
			} catch (Exception e) {
				status = true;
			}
		} while (status);
		book.setPublicationDate(publicationDate);

		System.out.print("Enter isbn: ");
		isbn = sc.nextLine();
		book.setIsbn(isbn);

		do {
			System.out.print("Enter author: ");
			author = sc.nextLine();
			book.setAuthor(author);
			sc = new Scanner(System.in);
			System.out.print("Enter 'n' to stop enter author: ");
			input = sc.nextLine();
		} while (!input.equals("n"));

		System.out.print("Enter publication place: ");
		publicationPlace = sc.nextLine();
		book.setPublicationPlace(publicationPlace);

		books.add(book);
	}

	public void addAuthor(String isbn, String author) {
		for (Book book : books) {
			for (String authorr : book.getAuthor()) {
				if (book.getIsbn().equals(isbn)) {
					book.setAuthor(author);
				}
			}
		}
	}

	public List<Book> searchByIsbn(String isbn) {
		List<Book> searchIsbn = new ArrayList<>();
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				searchIsbn.add(book);
			}
		}

		searchIsbn.sort(
				Comparator.comparing(o -> ((Book) o).getIsbn()).thenComparing(o -> ((Book) o).getPublicationPlace()));

		return searchIsbn;
	}

	public List<Book> searchByAuthor(String author) {
		List<Book> searchAuthor = new ArrayList<>();
		for (Book book : books) {
			for (String authorr : book.getAuthor()) {
				if (authorr.contains(author)) {
					searchAuthor.add(book);
				}
			}
		}

		searchAuthor.sort(
				Comparator.comparing(o -> ((Book) o).getIsbn()).thenComparing(o -> ((Book) o).getPublicationPlace()));

		return searchAuthor;
	}

	public List<Book> searchBypublisher(String publisher) {
		List<Book> searchPublisher = new ArrayList<>();

		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				searchPublisher.add(book);
			}
		}

		searchPublisher.sort(
				Comparator.comparing(o -> ((Book) o).getIsbn()).thenComparing(o -> ((Book) o).getPublicationPlace()));

		return searchPublisher;
	}

}
