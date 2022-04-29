import java.util.*;

/**
 * Class for Data Structures methods
 */
public class Administration {
    /**
     * The method stores the books for a publishing retailer;
     * Uses a for each loop to iterate over every object of type IPublishingArtifact,
     * checks if it is an instance of Book, EditorialGroup or PublishingBrand and
     * behaves accordingly.
     *
     * @param publishingRetailerID the ID of a publishing retailer
     *
     * @return arrayOfBooks an ArrayList of objects of type Book that belong to
     *         the publishing retailer.
     */
    public ArrayList<Book> getBooksForPublishingRetailerID(int publishingRetailerID) {
        // Initialise a Driver object which has all the needed initialisations
        LibroData libroData = new LibroData();

        // The books will be stored using a hashmap
        HashMap<Integer, Book> books = new HashMap<>();

        // Iterate through the publishing retailer's publishing artifacts
        for (IPublishingArtifact publishingArtifact :
                libroData.publishingRetailers.get(publishingRetailerID).getPublishingArtifacts()) {
            /*
              If the publishing artifact is a Book, simply add it to the books hashmap,
              the first parameter being its ID;
              If the publishing artifact is an EditorialGroup, iterate over its books
              list and add them to the books hashmap;
              If the publishing artifact is a PublishingBrand, iterate over its books
              list and add them to the books hashmap.
             */
            if (publishingArtifact instanceof Book) {
                books.put(publishingArtifact.getID(), (Book) publishingArtifact);
            } else if (publishingArtifact instanceof EditorialGroup) {
                for (Book book :
                        libroData.editorialGroups.get((publishingArtifact.getID())).getBooks())
                    books.put(book.getID(), book);
            } else if (publishingArtifact instanceof PublishingBrand) {
                for (Book book :
                        libroData.publishingBrands.get((publishingArtifact.getID())).getBooks())
                    books.put(book.getID(), book);
            }
        }

        /*
         *  Save the values from the hashmap into a collection and
         *  generate a new ArrayList containing those values
         */
        Collection<Book> bookNames = books.values();
        ArrayList<Book> arrayOfBooks = new ArrayList<>(bookNames);

        // Sort the ArrayList using Book's comparator
        arrayOfBooks.sort(Book::compareTo);

        return arrayOfBooks;
    }

    /**
     * The method stores the languages for a publishing retailer;
     * Initialises an ArrayList of objects of type Book using the previous method to
     * get access the publishing retailer's books;
     * Uses a for each loop to iterate over every object of type Book and add the
     * respective language to the hashmap, the first parameter being its ID;
     *
     * @param publishingRetailerID the ID of a publishing retailer
     *
     * @return new ArrayList<>(values) an ArrayList of objects of type Language that belong to
     *         the publishing retailer.
     */
    public ArrayList<Language> getLanguagesForPublishingRetailerID(int publishingRetailerID) {
        // Initialise a Driver object which has all the needed initialisations
        LibroData libroData = new LibroData();

        // The books will be stored using a hashmap
        HashMap<Integer, Language> languages = new HashMap<>();
        ArrayList<Book> books = getBooksForPublishingRetailerID(publishingRetailerID);

        // Iterate through the publishing retailer's books
        for (Book book : books) {
            languages.put(book.getLanguageID(), libroData.languages.get(book.getLanguageID()));
        }

        /*
         *  Save the values from the hashmap into a collection and
         *  return a new ArrayList containing those values
         */
        Collection<Language> values = languages.values();

        return new ArrayList<>(values);
    }

    /**
     * The method stores the countries of a book;
     * Iterates over every publishing retailer and stops when the current retailer
     * contains the book;
     *
     * @param bookID the ID of a book
     *
     * @return publishingRetailer.getCountries() an ArrayList of objects of type Country
     * that belong to the book;
     *         null default return case.
     */
    public ArrayList<Country> getCountriesForBookID(int bookID) {
        // Initialise a Driver object which has all the needed initialisations
        LibroData libroData = new LibroData();
        Book book = libroData.books.get(bookID);

        for (PublishingRetailer publishingRetailer : libroData.publishingRetailers.values()) {
            if (getBooksForPublishingRetailerID(publishingRetailer.getID()).contains(book)) {
                return publishingRetailer.getCountries();
            }
        }

        return null;
    }

    /**
     * The method stores the common books of 2 retailers;
     * Gets the books for the 2 retailers and calls the retailAll ArrayList method
     * to only store the common books.
     *
     * @param retailerID1 the ID of the first retailer
     * @param retailerID2 the ID of the second retailer
     *
     * @return commonBooks an ArrayList of objects of type Country that stores
     * the common books.
     */
    public ArrayList<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2) {
        ArrayList<Book> books1 = getBooksForPublishingRetailerID(retailerID1);
        ArrayList<Book> books2 = getBooksForPublishingRetailerID(retailerID2);
        ArrayList<Book> commonBooks = new ArrayList<>(books1);
        commonBooks.retainAll(books2);

        return commonBooks;
    }

    /**
     * The method stores all the books of 2 retailers;
     * Gets the books for the 2 retailers, iterates ofer them and adds them
     * to a hashmap, so there won't be any duplicates;
     *
     * @param retailerID1 the ID of the first retailer
     * @param retailerID2 the ID of the second retailer
     *
     * @return books an ArrayList of objects of type Country that stores
     * all the common books.
     */
    public ArrayList<Book> getAllBooksForRetailerIDs (int retailerID1, int retailerID2) {
        HashMap<Integer, Book> allBooks = new HashMap<>();
        ArrayList<Book> books1 = getBooksForPublishingRetailerID(retailerID1);
        ArrayList<Book> books2 = getBooksForPublishingRetailerID(retailerID2);

        for (Book book : books1)
            allBooks.put(book.getID(), book);
        for (Book book : books2)
            allBooks.put(book.getID(), book);

        /*
         *  Save the values from the hashmap into a collection and
         *  generate a new ArrayList containing those values
         */
        Collection<Book> values = allBooks.values();
        ArrayList<Book> books = new ArrayList<>(values);

        // Sort the ArrayList using Book's comparator
        books.sort(Book::compareTo);

        return books;
    }
}
