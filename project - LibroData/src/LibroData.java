import java.io.*;
import java.util.*;

/**
 * Driver class - initialise all data into a LibroData
 *                and test the methods
 */
public class LibroData {

    // Hashmaps used to store the input data
    HashMap<Integer, Book> books = new HashMap<>();
    HashMap<Integer, Author> authors = new HashMap<>();
    HashMap<Integer, Language> languages = new HashMap<>();
    HashMap<Integer, EditorialGroup> editorialGroups = new HashMap<>();
    HashMap<Integer, PublishingBrand> publishingBrands = new HashMap<>();
    HashMap<Integer, PublishingRetailer> publishingRetailers = new HashMap<>();
    HashMap<Integer, Country> countries = new HashMap<>();


    // Constructor which uses an Initialise object to store the data
    LibroData() {
        Initialise init = new Initialise();

        // Populate the data
        init.initBooks(this.books);
        init.initAuthors(this.authors);
        init.initLanguages(this.languages);
        init.initEditoralGroups(this.editorialGroups);
        init.initPublishingBrands(this.publishingBrands);
        init.initPublishingRetailers(this.publishingRetailers);
        init.initCountries(this.countries);

        // Establish relations between given data
        init.initBooksAuthors(this.books, this.authors);
        init.initEditGroupsBooks(this.editorialGroups, this.books);
        init.initPubBrandsBooks(this.publishingBrands, this.books);
        init.initPubRetCountries(this.publishingRetailers, this.countries);
        init.initPubRetBooks(this.publishingRetailers, this.books);
        init.initPubRetEditGroups(this.publishingRetailers, this.editorialGroups);
        init.initPubRetPubBrands(this.publishingRetailers, this.publishingBrands);
    }

    public static void main(String[] args) throws FileNotFoundException {

        /* TESTING */
        Administration test = new Administration();
        LibroData libroData = new LibroData();

        File outFolder = new File("outputs");
        if (!outFolder.exists())
            outFolder.mkdir();

        /* publish for some books */
        PrintStream publishBooks = new PrintStream("outputs/publishedBooks.xml");
        System.setOut(publishBooks);
        System.out.println("<xml>\n");
        System.out.println(libroData.books.get(962).Publish());   /* publish book with id 962 */
        System.out.println(libroData.books.get(2026).Publish());  /* publish book with id 2026 */
        System.out.println(libroData.books.get(4074).Publish());  /* publish book with id 4074 */
        System.out.println(libroData.books.get(12682).Publish()); /* publish book with id 12682 */
        System.out.println(libroData.books.get(14958).Publish()); /* publish book with id 14958 */
        System.out.println("</xml>");

        /* publish for some editorial groups */
        PrintStream publishEditGroups = new PrintStream("outputs/publishedEditGroups.xml");
        System.setOut(publishEditGroups);
        System.out.println("<xml>\n");
        System.out.println(libroData.editorialGroups.get(20).Publish());  /* publish editorial group with id 20 */
        System.out.println(libroData.editorialGroups.get(36).Publish());  /* publish editorial group with id 36 */
        System.out.println(libroData.editorialGroups.get(73).Publish());  /* publish editorial group with id 73 */
        System.out.println(libroData.editorialGroups.get(129).Publish()); /* publish editorial group with id 129 */
        System.out.println(libroData.editorialGroups.get(242).Publish()); /* publish editorial group with id 242 */
        System.out.println("</xml>");

        /* publish for some publishing brands */
        PrintStream publishPubBrands= new PrintStream("outputs/publishedPubBrands.xml");
        System.setOut(publishPubBrands);
        System.out.println("<xml>\n");
        System.out.println(libroData.publishingBrands.get(26).Publish());  /* publish publishing brand with id 26 */
        System.out.println(libroData.publishingBrands.get(27).Publish());  /* publish publishing brand with id 27 */
        System.out.println(libroData.publishingBrands.get(64).Publish());  /* publish publishing brand with id 64 */
        System.out.println(libroData.publishingBrands.get(163).Publish()); /* publish publishing brand with id 163 */
        System.out.println(libroData.publishingBrands.get(330).Publish()); /* publish publishing brand with id 330 */
        System.out.println("</xml>");

        /* method 1 */
        PrintStream method1test1 = new PrintStream("outputs/getBooks1.txt");
        System.setOut(method1test1);
        for (Book book : test.getBooksForPublishingRetailerID(1))
            System.out.println(book.getName());

        PrintStream method1test2 = new PrintStream("outputs/getBooks2.txt");
        System.setOut(method1test2);
        for (Book book : test.getBooksForPublishingRetailerID(2))
            System.out.println(book.getName());

        PrintStream method1test3 = new PrintStream("outputs/getBooks3.txt");
        System.setOut(method1test3);
        for (Book book : test.getBooksForPublishingRetailerID(3))
            System.out.println(book.getName());

        PrintStream method1test4 = new PrintStream("outputs/getBooks4.txt");
        System.setOut(method1test4);
        for (Book book : test.getBooksForPublishingRetailerID(4))
            System.out.println(book.getName());

        PrintStream method1test5 = new PrintStream("outputs/getBooks5.txt");
        System.setOut(method1test5);
        for (Book book : test.getBooksForPublishingRetailerID(12))
            System.out.println(book.getName());

        /* method 2 */
        PrintStream method2test1 = new PrintStream("outputs/getLanguages1.txt");
        System.setOut(method2test1);
        for (Language language : test.getLanguagesForPublishingRetailerID(1))
            System.out.println(language.getName());

        PrintStream method2test2 = new PrintStream("outputs/getLanguages2.txt");
        System.setOut(method2test2);
        for (Language language : test.getLanguagesForPublishingRetailerID(2))
            System.out.println(language.getName());

        PrintStream method2test3 = new PrintStream("outputs/getLanguages3.txt");
        System.setOut(method2test3);
        for (Language language : test.getLanguagesForPublishingRetailerID(3))
            System.out.println(language.getName());

        PrintStream method2test4 = new PrintStream("outputs/getLanguages4.txt");
        System.setOut(method2test4);
        for (Language language : test.getLanguagesForPublishingRetailerID(4))
            System.out.println(language.getName());

        PrintStream method2test5 = new PrintStream("outputs/getLanguages5.txt");
        System.setOut(method2test5);
        for (Language language : test.getLanguagesForPublishingRetailerID(12))
            System.out.println(language.getName());

        /* method 3 */
        PrintStream method3test1 = new PrintStream("outputs/getCountries1.txt");
        System.setOut(method3test1);
        for (Country country : test.getCountriesForBookID(2143))
            System.out.println(country.getCountryCode());

        PrintStream method3test2 = new PrintStream("outputs/getCountries2.txt");
        System.setOut(method3test2);
        for (Country country : test.getCountriesForBookID(962))
            System.out.println(country.getCountryCode());

        PrintStream method3test3 = new PrintStream("outputs/getCountries3.txt");
        System.setOut(method3test3);
        for (Country country : test.getCountriesForBookID(2456))
            System.out.println(country.getCountryCode());

        PrintStream method3test4 = new PrintStream("outputs/getCountries4.txt");
        System.setOut(method3test4);
        for (Country country : test.getCountriesForBookID(8434))
            System.out.println(country.getCountryCode());

        PrintStream method3test5 = new PrintStream("outputs/getCountries5.txt");
        System.setOut(method3test5);
        for (Country country : test.getCountriesForBookID(14014))
            System.out.println(country.getCountryCode());

        /* method 4 */
        PrintStream method4test1 = new PrintStream("outputs/getCommon1.txt");
        System.setOut(method4test1);
        for (Book book : test.getCommonBooksForRetailerIDs(1, 2))
            System.out.println(book.getName());

        PrintStream method4test2 = new PrintStream("outputs/getCommon2.txt");
        System.setOut(method4test2);
        for (Book book : test.getCommonBooksForRetailerIDs(2, 3))
            System.out.println(book.getName());

        PrintStream method4test3 = new PrintStream("outputs/getCommon3.txt");
        System.setOut(method4test3);
        for (Book book : test.getCommonBooksForRetailerIDs(3, 4))
            System.out.println(book.getName());

        PrintStream method4test4 = new PrintStream("outputs/getCommon4.txt");
        System.setOut(method4test4);
        for (Book book : test.getCommonBooksForRetailerIDs(4, 12))
            System.out.println(book.getName());

        PrintStream method4test5 = new PrintStream("outputs/getCommon5.txt");
        System.setOut(method4test5);
        for (Book book : test.getCommonBooksForRetailerIDs(12, 1))
            System.out.println(book.getName());

        /* method 5 */
        PrintStream method5test1 = new PrintStream("outputs/getAll1.txt");
        System.setOut(method5test1);
        for (Book book : test.getAllBooksForRetailerIDs(1, 2))
            System.out.println(book.getName());

        PrintStream method5test2 = new PrintStream("outputs/getAll2.txt");
        System.setOut(method5test2);
        for (Book book : test.getAllBooksForRetailerIDs(2, 3))
            System.out.println(book.getName());

        PrintStream method5test3 = new PrintStream("outputs/getAll3.txt");
        System.setOut(method5test3);
        for (Book book : test.getAllBooksForRetailerIDs(3, 4))
            System.out.println(book.getName());

        PrintStream method5test4 = new PrintStream("outputs/getAll4.txt");
        System.setOut(method5test4);
        for (Book book : test.getAllBooksForRetailerIDs(4, 12))
            System.out.println(book.getName());

        PrintStream method5test5 = new PrintStream("outputs/getAll5.txt");
        System.setOut(method5test5);
        for (Book book : test.getAllBooksForRetailerIDs(12, 1))
            System.out.println(book.getName());

    }
}
