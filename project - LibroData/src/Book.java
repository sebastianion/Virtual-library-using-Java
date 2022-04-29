import java.util.*;

/**
 * Class for Book entity
 * Implements IPublishingArtifact and Comparable interfaces
 */
public class Book implements IPublishingArtifact, Comparable<Book> {
    private int ID;
    private String name;
    private String subtitle;
    private String ISBN;
    private int pageCount;
    private String keywords;
    private int languageID;
    private Date createdOn;
    private ArrayList<Author> authors = new ArrayList<>();

    // Default constructor
    Book() {

    }

    // Getters and setters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getLanguageID() {
        return languageID;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    // Method to get the authors' names
    public ArrayList<String> getAuthorsNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Author author : authors) {
            names.add(author.getFirstName() + " " +
                        author.getLastName());
        }

        return names;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setAuthors(Author author) {
        this.authors.add(author);
    }

    // Return a string formatted as xml
    public String Publish() {
        return (
                "   <title>" + getName() + "</title>\n" +
                "   <subtitle>" + getSubtitle() + "</subtitle>\n" +
                "   <isbn>" + getISBN() + "</isbn>\n" +
                "   <pageCount>" + getPageCount() + "</pageCount>\n" +
                "   <keywords>" + getKeywords() + "</keywords>\n" +
                "   <languageID>" + getLanguageID() + "</languageID>\n" +
                "   <createdOn>" + getCreatedOn() + "</createdOn>\n" +
                "   <authors>" + getAuthorsNames() + "</authors>\n"
        );
    }

    // Comparator based on the books' names
    @Override
    public int compareTo(Book o) {
        return (this.getName().compareTo((o.getName())));
    }

    // Overridden equals method
    @Override
    public boolean equals(Object other) {

        if (other == null || getClass() != other.getClass())
            return false;

        return this.getID() == ((Book) other).getID();
    }
}
