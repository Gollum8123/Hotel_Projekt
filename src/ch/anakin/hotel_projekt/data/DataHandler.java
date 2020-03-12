package ch.anakin.hotel_projekt.data;


import ch.anakin.hotel_projekt.model.Gast;
import ch.anakin.hotel_projekt.service.Config;

import java.io.*;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Vector;

/**
 * data handler for reading and writing the csv files
 * <p>
 * M133: Bookshelf
 *
 * @author Marcel Suter
 */

public class DataHandler {
    private static final DataHandler instance = new DataHandler();
    private static Vector<Gast> gastVector = new Vector<>();


    /**
     * default constructor: defeat instantiation
     */
    private DataHandler() {
    }

    /**
     * @return the instance of this class
     */
    public static DataHandler getInstance() {
        return DataHandler.instance;
    }

    /**
     * reads all data from the csv-file into the bookMap
     *
     * @return a map with all books
     */
    public static void readBooks() {

        BufferedReader bufferedReader;
        FileReader fileReader;
        try {
            String bookPath = Config.getProperty("bookFile");
            fileReader = new FileReader(bookPath);
            bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException fileEx) {
            fileEx.printStackTrace();
            throw new RuntimeException();
        }

        try {
            String line;
            Gast gast = null;
            while ((line = bufferedReader.readLine()) != null) {
                gast = new Gast();
                String[] values = line.split(";");
                gast.setVorname(values[0]);
                gast.setNachname(values[1]);
                gast.setAdresse(values[2]);
                gast.setAdresse(values[3]);
                gast.setHausnummer(values[4]);
                gast.setPlz(new Integer(values[5]));

            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
            throw new RuntimeException();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

    /**
     * reads all data from the csv-file into the publisherMap
     *
     */
    public static void readPublishers() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        try {
            String publisherPath = Config.getProperty("publisherFile");
            fileReader = new FileReader(publisherPath);
            bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException fileEx) {
            fileEx.printStackTrace();
            throw new RuntimeException();
        }

        try {
            String line;
            Publisher publisher = null;
            while ((line = bufferedReader.readLine()) != null) {
                publisher = new Publisher();
                String[] values = line.split(";");
                publisher.setPublisherUUID(values[0]);
                publisher.setPublisher(values[1]);

                publisherMap.put(values[0], publisher);
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
            throw new RuntimeException();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

    /**
     * writes the bookMap to the csv-file
     *
     * @param bookMap map with all the books
     */
    public static void writeBooks(Map<String, Book> bookMap) {
        Writer writer = null;
        FileOutputStream fileOutputStream = null;

        try {
            String bookPath = Config.getProperty("bookFile");
            fileOutputStream = new FileOutputStream(bookPath);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "utf-8"));

            for (Map.Entry<String, Book> bookEntry : bookMap.entrySet()) {
                Book book = bookEntry.getValue();
                String contents = String.join(";",
                        book.getBookUUID().toString(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPublisher().getPublisherUUID(),
                        book.getPrice().toString(),
                        book.getIsbn()
                );
                writer.write(contents + '\n');
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
            throw new RuntimeException();

        } finally {

            try {
                if (writer != null) {
                    writer.close();
                }

                if (fileOutputStream != null) {
                    fileOutputStream.close();

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Gets the bookMap
     *
     * @return value of bookMap
     */
    public static Map<String, Book> getBookMap() {
        if (bookMap.isEmpty()) {
            readBooks();
        }
        return bookMap;
    }

    /**
     * Sets the bookMap
     *
     * @param bookMap the value to set
     */

    public static void setBookMap(Map<String, Book> bookMap) {
        DataHandler.bookMap = bookMap;
    }

    /**
     * Gets the publisherMap
     *
     * @return value of publisherMap
     */
    public static Map<String, Publisher> getPublisherMap() {
        if (publisherMap.isEmpty()) {
            readPublishers();
        }
        return publisherMap;
    }

    /**
     * Sets the publisherMap
     *
     * @param publisherMap the value to set
     */

    public static void setPublisherMap(Map<String, Publisher> publisherMap) {
        DataHandler.publisherMap = publisherMap;
    }
}
