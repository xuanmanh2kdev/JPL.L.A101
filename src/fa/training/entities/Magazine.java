package fa.training.entities;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Magazine extends Publication {

	private String author;
	private int volume;
	private int edition;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public Magazine() {
		super();
	}

	public Magazine(String author, int volume, int edition) {
		super();
		this.author = author;
		this.volume = volume;
		this.edition = edition;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Magazine [author=" + author + ", volume=" + volume + ", edition=" + edition + ", publication year="
				+ getPublicationYear() + ", publisher=" + getPublisher() + ", publication date=" + getPublicationDate()
				+ "]";
	}

	@Override
	public void display() {
		System.out.println("Magazine:");
		System.out.println("Author: " + author);
		System.out.println("Volume: " + volume);
		System.out.println("Edition: " + edition);
		System.out.println("Publication year: " + getPublicationYear());
		System.out.println("Publisher: " + getPublisher());
		System.out.println("Publication date: " + formatter.format(getPublicationDate()));
		System.out.println("===============================================");
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Magazine)) {
			return false;
		}
		Magazine magazine = (Magazine) o;
		return (volume == magazine.volume && edition != magazine.edition) || (volume != magazine.volume);
	}

	@Override
	public int hashCode() {
		return Objects.hash(volume, edition);
	}

}
