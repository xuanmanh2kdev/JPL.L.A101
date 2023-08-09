package fa.training.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Magazine;

public class MagazineService {

	private Scanner sc = new Scanner(System.in);
	private static List<Magazine> magazines = new ArrayList<>();
	private Magazine magazine;
	private String author;
	private int volume;
	private int edition;
	boolean status;
	private int publicationYear;
	private String publisher;
	private Date publicationDate;

	public static List<Magazine> getAllMagazine() {
		return magazines;
	}

	public void addNewMagazine() {
		magazine = new Magazine();

		System.out.println("---Enter magazine information---");

		do {
			try {
				status = false;
				System.out.print("Enter publication year: ");
				publicationYear = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				status = true;
			}
		} while (status);
		magazine.setPublicationYear(publicationYear);

		System.out.print("Enter publisher: ");
		publisher = sc.nextLine();
		magazine.setPublisher(publisher);

		do {
			try {
				status = false;
				System.out.print("Enter publication date: ");
				publicationDate = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
			} catch (Exception e) {
				status = true;
			}
		} while (status);
		magazine.setPublicationDate(publicationDate);

		System.out.print("Enter author: ");
		author = sc.nextLine();
		magazine.setAuthor(author);

		do {
			try {
				status = false;
				System.out.print("Enter volume: ");
				volume = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				status = true;
			}
		} while (status);
		magazine.setVolume(volume);

		do {
			try {
				status = false;
				System.out.print("Enter edition: ");
				edition = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				status = true;
			}
		} while (status);
		magazine.setEdition(edition);

		magazines.add(magazine);

	}

	public List<Magazine> top10MagazineByVolume() {
		List<Magazine> top10VolumeMagazines = new ArrayList<>();
		int count = 0;

		Collections.sort(magazines, new VolumeComparator());

		for (Magazine magazine : magazines) {
			top10VolumeMagazines.add(magazine);
			count++;

			if (count == 10) {
				break;
			}
		}

		return top10VolumeMagazines;
	}

	class VolumeComparator implements Comparator<Magazine> {

		@Override
		public int compare(Magazine s1, Magazine s2) {
			if (s1.getVolume() == s2.getVolume()) {
				return 0;
			} else if (s1.getVolume() > s2.getVolume()) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
