package data_layer;

public interface Searchable {
	
	public boolean searchTitle(String title);
	public boolean searchTitleAndItemType(String title, String itemType);
	
}
