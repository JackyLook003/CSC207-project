package use_case.booksearch;
import entity.Book;

import java.util.ArrayList;


public class BookSearchInteractor implements BookSearchInputBoundary{

    final BookSearchDataAccessInterface searchDataAccessObject;

    final BookSearchOutputBoundary searchPresenter;

    public BookSearchInteractor(BookSearchDataAccessInterface bookSearchDataAccessInterface,
                                BookSearchOutputBoundary bookSearchOutputBoundary) {
        this.searchDataAccessObject = bookSearchDataAccessInterface;
        this.searchPresenter = bookSearchOutputBoundary;
    }

    @Override
    public void execute(BookSearchInputData bookSearchInputData) {
        try {
            ArrayList<Book> books = searchDataAccessObject.getSearchResult(bookSearchInputData.getSearchQuery());

              //SearchFilterInputData filterInputData = new SearchFilterInputData();

            BookSearchOutputData outputData = new BookSearchOutputData(books);
            searchPresenter.presentBookSearchResponse(outputData);
        } catch (Exception e) {
            // Handle any exceptions, such as network errors, invalid queries, etc.
            BookSearchOutputData errorOutputData = new BookSearchOutputData(e.getMessage());
            searchPresenter.presentBookSearchResponse(errorOutputData);
        }
    }
}
