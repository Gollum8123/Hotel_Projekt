package ch.anakin.hotel_projekt.data;

import ch.anakin.hotel_projekt.model.Gast;
import ch.anakin.hotel_projekt.service.Config;

import java.io.*;
import java.util.Vector;

/**
 * data handler for reading and writing the csv files
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
     * Gets instance.
     *
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

    /**
     * Write books.
     *
     * @param gastVector the gast vector
     */
    public static void writeGaeste(Vector<Gast> gastVector) {
        Writer writer = null;
        FileOutputStream fileOutputStream = null;

        try {
            String bookPath = Config.getProperty("gaesteFile");
            fileOutputStream = new FileOutputStream(bookPath);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "utf-8"));

            for (Gast gastEingabe : gastVector) {
                String contents = String.join(";",
                        gastEingabe.getVorname(),
                        gastEingabe.getNachname(),
                        gastEingabe.getAdresse(),
                        gastEingabe.getHausnummer(),
                        gastEingabe.getPlz().toString(),
                        gastEingabe.getWohnort(),
                        gastEingabe.getLand(),
                        gastEingabe.getTelefon(),
                        gastEingabe.getMobil(),
                        gastEingabe.getGeburtsdatum(),
                        gastEingabe.getMail(),
                        gastEingabe.getCheck_in(),
                        gastEingabe.getCheck_out()
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
     * Gets gast vector.
     *
     * @return the gast vector
     */
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
