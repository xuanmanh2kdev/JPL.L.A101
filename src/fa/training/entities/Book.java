package fa.training.entities;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Book extends Publication {

	private String isbn;
	private Set<String> author = new HashSet<>();
	private String publicationPlace;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public Book() {
		super();
	}

	public Book(String isbn, Set<String> author, String publicationPlace) {
		super();
		this.isbn = isbn;
		this.author = new HashSet<>();
		this.publicationPlace = publicationPlace;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<String> getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author.add(author);
	}

	public String getPublicationPlace() {
		return publicationPlace;
	}

	public void setPublicationPlace(String publicationPlace) {
		this.publicationPlace = publicationPlace;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", publicationPlace=" + publicationPlace
				+ ", publication year=" + getPublicationYear() + ", publisher=" + getPublisher() + ", publication date="
				+ getPublicationDate() + "]";
	}

	@Override
	public void display() {
		System.out.println("Book:");
		System.out.println("ISBN: " + isbn);
		System.out.println("Authors: " + author);
		System.out.println("Publication year: " + getPublicationYear());
		System.out.println("Publisher: " + getPublisher());
		System.out.println("Publication date: " + formatter.format(getPublicationDate()));
		System.out.println("Publication place: " + publicationPlace);
		System.out.println("===============================================");
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Book)) {
			return false;
		}
		Book book = (Book) o;
		return isbn == book.isbn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

}
