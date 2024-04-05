package presentation_layer;

import business_layer.*;

public class LibraryManagementSystem {
	public static void main(String[] args) {
	LibraryManagement library = new LibraryManagement();
	library.display();
	library.searchByTitle();
	library.searchByTitleAndType();
	
	}
}
