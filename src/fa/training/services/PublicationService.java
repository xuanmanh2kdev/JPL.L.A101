package fa.training.services;

import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Publication;

public class PublicationService {

	private List<Publication> publications;

	public void displayBookAndMagazine() {
		int count;
		publications = new ArrayList<>();

		publications.addAll(BookService.getAllBook());
		publications.addAll(MagazineService.getAllMagazine());
		
		
		for(int i = 0; i < publications.size(); i++) {
			count = 0;
		for (int j = 0; j < publications.size(); j++) {
			if(((Integer)publications.get(i).getPublicationYear()).equals(((Integer)publications.get(j).getPublicationYear())) && publications.get(i).getPublisher().equals(publications.get(j).getPublisher())) {
				count++;
			}
		}
		
		if(count == 1) {
			publications.remove(i);
		}
		}

		for (Publication publication : publications) {
				publication.display();
		}
	}
}
