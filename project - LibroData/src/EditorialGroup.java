import java.util.ArrayList;

/**
 * Class for EditorialGroup entity
 * Implements IPublishingArtifact interface
 */
public class EditorialGroup implements IPublishingArtifact {
    private int ID;
    private String name;
    private ArrayList<Book> books = new ArrayList<>();

    // Getters and setters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Book book) {
        this.books.add(book);
    }

    // Return a string formatted as xml
    public String Publish() {
        StringBuilder retString = new StringBuilder();
        retString.append(
                "   <editorialGroup>\n" +
                "       <ID>" + getID() + "</ID>\n" +
                "       <Name>" + getName() + "</Name>\n" +
                "       <books>\n"
        );

        for (Book book : books) {
            retString.append("          <book>\n");
            retString.append(book.Publish().replaceAll("(?m)^", "          "));
            retString.append("          </book>\n");
        }

        retString.append(
                "      </books>\n" +
                "   </editorialGroup>\n"
        );

        return retString.toString();
    }
}
