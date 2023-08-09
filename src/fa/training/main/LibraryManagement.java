package fa.training.main;

import java.util.Scanner;

import fa.training.services.BookService;
import fa.training.services.MagazineService;
import fa.training.services.PublicationService;

public class LibraryManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PublicationService publicationService = new PublicationService();
		BookService bookService = new BookService();
		MagazineService magazineService = new MagazineService();
		String publisher;
		String isbn;
		String author;
		int choice;
		int choice6;
		do {
			System.out.println("======LIBRARY MANAGEMENT SYSTEM======");
			System.out.println("1. Add a book");
			System.out.println("2. Add a magazines");
			System.out.println("3. Display books and magazines");
			System.out.println("4. Add author to book");
			System.out.println("5. Display top 10 of magazines by volume");
			System.out.println("6. Search book by (isbn, author, publisher)");
			System.out.println("7. Exit");
			System.out.println("Please choose function you'd like to do:");

			choice = sc.nextInt();
			sc = new Scanner(System.in);

			switch (choice) {
			case 1:
				bookService.addNewBook();
				break;
			case 2:
				magazineService.addNewMagazine();
				break;
			case 3:
				System.out.println("Book and magazine has same publication year and publisher is: ");
				publicationService.displayBookAndMagazine();
				break;
			case 4:
				sc = new Scanner(System.in);
				System.out.print("Enter book isbn to add author in: ");
				isbn = sc.nextLine();

				System.out.print("Enter author to add: ");
				author = sc.nextLine();
				bookService.addAuthor(isbn, author);
				break;
			case 5:
				System.out.println("Top 10 magazine by volume is: ");
				System.out.println(magazineService.top10MagazineByVolume().toString());
				break;
			case 6:
				System.out.println(
						"Enter 1 to search book by isbn, 2 to search by author and 3 to search by publisher: ");
				choice6 = sc.nextInt();
				sc = new Scanner(System.in);
				switch (choice6) {
				case 1:
					System.out.print("Enter isbn to find book: ");
					isbn = sc.nextLine();
					System.out.println(bookService.searchByIsbn(isbn).toString());
					break;
				case 2:
					System.out.print("Enter author to find book: ");
					author = sc.nextLine();
					System.out.println(bookService.searchByAuthor(author).toString());
					break;
				case 3:
					System.out.print("Enter publisher to find book: ");
					publisher = sc.nextLine();
					System.out.println(bookService.searchBypublisher(publisher).toString());
					break;
				default:
					break;
				}
				break;
			default:
				choice = 7;
				break;
			}
		} while (choice != 7);
	}

}
