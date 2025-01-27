package use_case.book_info;

import entity.CommonUser;
import entity.Listing;
import java.util.List;

public interface BookInfoDataAccessInterface {
    List<Listing> getBookListings(String ISBN);
    CommonUser findUserByUsername(String username);
}
