package ch.anakin.hotel_projekt.data;

import ch.anakin.hotel_projekt.model.Gast;
import ch.anakin.hotel_projekt.service.Config;
import java.io.*;
import java.util.Vector;

/**
 * data handler for reading and writing the csv files
 * <p>
 *
 * @author Anakin Kirschler
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
     * @return a map with all gaeste
     */
    public static void readGaeste() {

        BufferedReader bufferedReader;
        FileReader fileReader;
        try {
            String bookPath = Config.getProperty("gaesteFile");
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
                gast.setHausnummer(values[3]);
                gast.setPlz(new Integer(values[4]));
                gast.setWohnort(values[4]);
                gast.setLand(values[6]);
                gast.setTelefon(values[7]);
                gast.setMobil(values[8]);
                gast.setGeburtsdatum(values[9]);
                gast.setMail(values[10]);
                gast.setCheck_in(values[11]);
                gast.setCheck_out(values[12]);

                gastVector.add(gast);

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


    public static Vector<Gast> getGastVector() {
        if (gastVector.isEmpty()) {
            readGaeste();
        }

        return gastVector;

    }

    /**
     * Sets the bookMap
     *
     * @param gastVector the value to set
     */

    public static void setGastVector(Vector<Gast> gastVector) {
        DataHandler.gastVector = gastVector;
    }

}
