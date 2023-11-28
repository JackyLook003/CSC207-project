package entity;

public class Book {

    private int everInStock;
    private String title;
    private int year;
    private String author;
    private String summary;
    private String ISBN;
    private int inStock;
    private String coverUrl;

    public Book(String title, int year, String author, String summary, String ISBN, int inStock, String coverUrl) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.summary = summary;
        this.ISBN = ISBN;
        this.inStock = inStock;
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public int getInStock() {
        return inStock;
    }
    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", summary='" + summary + '\'' +
                ", ISBN=" + ISBN +
                ", inStock=" + inStock +
                ", coverUrl='" + coverUrl + '\'' +
                '}';
    }
    public String getCoverUrl() {
        return this.coverUrl;
    }
    public int getEverInStock(){ return this.everInStock; }
    public void setEverInStock(){
        this.everInStock = this.everInStock++;
    }
}
