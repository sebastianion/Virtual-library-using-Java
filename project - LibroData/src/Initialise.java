import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Initialise class - initialise the given data sets
 */
public class Initialise {

    // Default constructor
    Initialise() {

    }

    /**
     *  The method initialises a hashmap of objects of type Book;
     *  The ID of a book represents the key, and the book itself
     *  represents the value in the hashmap;
     *  That way, we will be able to access a book using its ID.
     *
     * @param books the hashmap that needs to be filled
     */
    public void initBooks(HashMap<Integer, Book> books) {
        File fileBooks = new File("init/books.in");

        /* reading from books.in */
        try (BufferedReader brBooks = new BufferedReader(new FileReader(fileBooks))) {
            brBooks.readLine();
            String line;
            while ((line = brBooks.readLine()) != null) {
                String[] parsedLine = line.split("###");
                Book book = new Book();
                book.setID(Integer.parseInt(parsedLine[0]));
                book.setName(parsedLine[1]);
                book.setSubtitle(parsedLine[2]);
                book.setISBN(parsedLine[3]);
                book.setPageCount(Integer.parseInt(parsedLine[4]));
                book.setKeywords(parsedLine[5]);
                book.setLanguageID(Integer.parseInt(parsedLine[6]));

                Date date = new SimpleDateFormat("dd.M.yyyy HH:mm:ss").parse(parsedLine[7]);
                book.setCreatedOn(date);

                // Add the book to the hashmap
                books.put(book.getID(), book);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method initialises a hashmap of objects of type Author;
     *  The ID of an author represents the key, and the author itself
     *  represents the value in the hashmap;
     *  That way, we will be able to access an author using its ID.
     *
     * @param authors the hashmap that needs to be filled
     */
    public void initAuthors(HashMap<Integer, Author> authors) {
        File fileAuthors = new File("init/authors.in");

        /* reading from authors.in */
        try (BufferedReader brAuthors = new BufferedReader(new FileReader(fileAuthors))) {
            brAuthors.readLine();
            String line;
            while ((line = brAuthors.readLine()) != null) {
                String[] parsedLine = line.split("###");
                Author author = new Author();
                author.setID(Integer.parseInt(parsedLine[0]));
                author.setFirstName(parsedLine[1]);
                author.setLastName(parsedLine[2]);

                authors.put(author.getID(), author);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method initialises a hashmap of objects of type Language;
     *  The ID of a language represents the key, and the language itself
     *  represents the value in the hashmap;
     *  That way, we will be able to access a language using its ID.
     *
     * @param languages the hashmap that needs to be filled
     */
    public void initLanguages(HashMap<Integer, Language> languages) {
        File fileLanguages = new File("init/languages.in");

        /* reading from languages.in */
        try (BufferedReader brLanguages = new BufferedReader(new FileReader(fileLanguages))) {
            brLanguages.readLine();
            String line;
            while ((line = brLanguages.readLine()) != null) {
                String[] parsedLine = line.split("###");
                Language language = new Language();
                language.setID(Integer.parseInt(parsedLine[0]));
                language.setCode(parsedLine[1]);
                language.setName(parsedLine[2]);

                languages.put(language.getID(), language);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method initialises a hashmap of objects of type EditorialGroup;
     *  The ID of an editorial group represents the key, and the editorial
     *  group itself represents the value in the hashmap;
     *  That way, we will be able to access an editorial group using its ID.
     *
     * @param editorialGroups the hashmap that needs to be filled
     */
    public void initEditoralGroups(HashMap<Integer, EditorialGroup> editorialGroups) {
        File fileEditGroups = new File("init/editorial-groups.in");

        /* reading from editorial-groups.in */
        try (BufferedReader brEditorial = new BufferedReader(new FileReader(fileEditGroups))) {
            brEditorial.readLine();
            String line;
            while ((line = brEditorial.readLine()) != null) {
                String[] parsedLine = line.split("###");
                EditorialGroup editorialGroup = new EditorialGroup();
                editorialGroup.setID(Integer.parseInt(parsedLine[0]));
                editorialGroup.setName(parsedLine[1]);

                editorialGroups.put(editorialGroup.getID(), editorialGroup);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method initialises a hashmap of objects of type PublishingBrand;
     *  The ID of a publishing brand represents the key, and the publishing brand
     *  itself represents the value in the hashmap;
     *  That way, we will be able to access a publishing brand using its ID.
     *
     * @param publishingBrands the hashmap that needs to be filled
     */
    public void initPublishingBrands(HashMap<Integer, PublishingBrand> publishingBrands) {
        File filePubBrands = new File("init/publishing-brands.in");

        /* reading from publishing-brands.in */
        try (BufferedReader brBrand = new BufferedReader(new FileReader(filePubBrands))) {
            brBrand.readLine();
            String line;
            while ((line = brBrand.readLine()) != null) {
                String[] parsedLine = line.split("###");
                PublishingBrand publishingBrand = new PublishingBrand();
                publishingBrand.setID(Integer.parseInt(parsedLine[0]));
                publishingBrand.setName(parsedLine[1]);

                publishingBrands.put(publishingBrand.getID(), publishingBrand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method initialises a hashmap of objects of type PublishingRetailer;
     *  The ID of a publishing retailer represents the key, and the publishing retailer
     *  itself represents the value in the hashmap;
     *  That way, we will be able to access a publishing retailer using its ID.
     *
     * @param publishingRetailers the hashmap that needs to be filled
     */
    public void initPublishingRetailers(HashMap<Integer, PublishingRetailer> publishingRetailers) {
        File filePubRetailers = new File("init/publishing-retailers.in");

        /* reading from publishing-retailers.in */
        try (BufferedReader brRetailer = new BufferedReader(new FileReader(filePubRetailers))) {
            brRetailer.readLine();
            String line;
            while ((line = brRetailer.readLine()) != null) {
                String[] parsedLine = line.split("###");
                PublishingRetailer publishingRetailer = new PublishingRetailer();
                publishingRetailer.setID(Integer.parseInt(parsedLine[0]));
                publishingRetailer.setName(parsedLine[1]);

                publishingRetailers.put(publishingRetailer.getID(), publishingRetailer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method initialises a hashmap of objects of type Country;
     *  The ID of a country represents the key, and the country itself
     *  represents the value in the hashmap;
     *  That way, we will be able to access a country using its ID.
     *
     * @param countries the hashmap that needs to be filled
     */
    public void initCountries(HashMap<Integer, Country> countries) {
        File fileCountries = new File("init/countries.in");

        /* reading from countries.in */
        try (BufferedReader brCountry = new BufferedReader(new FileReader(fileCountries))) {
            brCountry.readLine();
            String line;
            while ((line = brCountry.readLine()) != null) {
                String[] parsedLine = line.split("###");
                Country country = new Country();
                country.setID(Integer.parseInt(parsedLine[0]));
                country.setCountryCode(parsedLine[1]);

                countries.put(country.getID(), country);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method establishes the relation between books and authors;
     *  Accesses every book and author (the values) using the given IDs (the keys)
     *  and uses the setAuthors method for Book.
     *
     * @param books the books hashmap
     * @param authors the authors hashmap
     */
    public void initBooksAuthors(HashMap<Integer, Book> books, HashMap<Integer, Author> authors) {
        File fileBA = new File("init/books-authors.in");

        /* reading from books-authors.in */
        try (BufferedReader brBA = new BufferedReader(new FileReader(fileBA))) {
            brBA.readLine();
            String line;
            while ((line = brBA.readLine()) != null) {
                String[] parsedLine = line.split("###");
                books.get(Integer.parseInt(parsedLine[0])).setAuthors(
                        authors.get(Integer.parseInt(parsedLine[1]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method establishes the relation between editorial groups and books;
     *  Accesses every editorial group and book (the values) using the given
     *  IDs (the keys) and uses the setBooks method for EditorialGroup.
     *
     * @param editorialGroups the editorial groups hashmap
     * @param books the books hashmap
     */
    public void initEditGroupsBooks(HashMap<Integer, EditorialGroup> editorialGroups,
                                      HashMap<Integer, Book> books) {
        File fileEGB = new File("init/editorial-groups-books.in");

        /* reading from editorial-groups-books.in */
        try (BufferedReader brEGB = new BufferedReader(new FileReader(fileEGB))) {
            brEGB.readLine();
            String line;
            while ((line = brEGB.readLine()) != null) {
                String[] parsedLine = line.split("###");

                editorialGroups.get(Integer.parseInt(parsedLine[0])).setBooks(
                        books.get(Integer.parseInt(parsedLine[1]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method establishes the relation between publishing brands and books;
     *  Accesses every publishing brand and book (the values) using the given
     *  IDs (the keys) and uses the setBooks method for PublishingBrand.
     *
     * @param publishingBrands the publishing brands hashmap
     * @param books the books hashmap
     */
    public void initPubBrandsBooks(HashMap<Integer, PublishingBrand> publishingBrands,
                                   HashMap<Integer, Book> books) {
        File filePBB = new File("init/publishing-brands-books.in");

        /* reading from publishing-brands-books.in */
        try (BufferedReader brPBB = new BufferedReader(new FileReader(filePBB))) {
            brPBB.readLine();
            String line;
            while ((line = brPBB.readLine()) != null) {
                String[] parsedLine = line.split("###");

                publishingBrands.get(Integer.parseInt(parsedLine[0])).setBooks(
                        books.get(Integer.parseInt(parsedLine[1]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method establishes the relation between publishing retailers and countries;
     *  Accesses every publishing retailer and country (the values) using the given
     *  IDs (the keys) and uses the setCountries method for PublishingRetailer.
     *
     * @param publishingRetailers the publishing retailers hashmap
     * @param countries the countries hashmap
     */
    public void initPubRetCountries(HashMap<Integer, PublishingRetailer> publishingRetailers,
                                    HashMap<Integer, Country> countries) {
        File filePRC = new File("init/publishing-retailers-countries.in");

        /* reading from publishing-retailers-countries.in */
        try (BufferedReader brPRC = new BufferedReader(new FileReader(filePRC))) {
            brPRC.readLine();
            String line;
            while ((line = brPRC.readLine()) != null) {
                String[] parsedLine = line.split("###");

                publishingRetailers.get(Integer.parseInt(parsedLine[0])).setCountries(
                        countries.get(Integer.parseInt(parsedLine[1]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method establishes the relation between publishing retailers and books;
     *  Accesses every publishing retailer and book (the values) using the given
     *  IDs (the keys) and uses the setPublishingArtifacts method for PublishingRetailer.
     *
     * @param publishingRetailers the publishing brands hashmap
     * @param books the books hashmap
     */
    public void initPubRetBooks(HashMap<Integer, PublishingRetailer> publishingRetailers,
                                HashMap<Integer, Book> books) {
        File filePRB = new File("init/publishing-retailers-books.in");

        /* reading from publishing-retailers-books.in */
        try (BufferedReader brPRB = new BufferedReader(new FileReader(filePRB))) {
            brPRB.readLine();
            String line;
            while ((line = brPRB.readLine()) != null) {
                String[] parsedLine = line.split("###");

                publishingRetailers.get(Integer.parseInt(parsedLine[0])).setPublishingArtifacts(
                        books.get(Integer.parseInt(parsedLine[1]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method establishes the relation between publishing retailers
     *  and editorial groups;
     *  Accesses every publishing retailer and editorial group (the values) using the given
     *  IDs (the keys) and uses the setPublishingArtifacts method for PublishingRetailer.
     *
     * @param publishingRetailers the publishing brands hashmap
     * @param editorialGroups the editorial groups hashmap
     */
    public void initPubRetEditGroups(HashMap<Integer, PublishingRetailer> publishingRetailers,
                                     HashMap<Integer, EditorialGroup> editorialGroups) {
        File filePREG = new File("init/publishing-retailers-editorial-groups.in");

        /* reading from publishing-retailers-editorial-groups.in */
        try (BufferedReader brPREG = new BufferedReader(new FileReader(filePREG))) {
            brPREG.readLine();
            String line;
            while ((line = brPREG.readLine()) != null) {
                String[] parsedLine = line.split("###");

                publishingRetailers.get(Integer.parseInt(parsedLine[0])).setPublishingArtifacts(
                        editorialGroups.get(Integer.parseInt(parsedLine[1]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  The method establishes the relation between publishing retailers
     *  and publishing brands;
     *  Accesses every publishing retailer and publishing brand (the values) using the given
     *  IDs (the keys) and uses the setPublishingArtifacts method for PublishingRetailer.
     *
     * @param publishingRetailers the publishing brands hashmap
     * @param publishingBrands the publishing brands hashmap
     */
    public void initPubRetPubBrands(HashMap<Integer, PublishingRetailer> publishingRetailers,
                                    HashMap<Integer, PublishingBrand> publishingBrands) {
        File filePRPB = new File("init/publishing-retailers-publishing-brands.in");

        /* reading from publishing-retailers-publishing-brands.in */
        try (BufferedReader brPRPB = new BufferedReader(new FileReader(filePRPB))) {
            brPRPB.readLine();
            String line;
            while ((line = brPRPB.readLine()) != null) {
                String[] parsedLine = line.split("###");

                publishingRetailers.get(Integer.parseInt(parsedLine[0])).setPublishingArtifacts(
                        publishingBrands.get(Integer.parseInt(parsedLine[1]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
