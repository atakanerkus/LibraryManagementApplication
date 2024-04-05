package data_layer;
import java.util.Date;

public interface Borrowing { 
	void borrow(Item item, Date startBorrow, Date endBorrow); // #TODO this is being done on FileIO class (should be turned into this method
}
