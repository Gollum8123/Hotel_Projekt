package ch.anakin.hotel_projekt.data;

import ch.anakin.hotel_projekt.model.Gast;
import ch.anakin.hotel_projekt.model.Hotel;
import ch.anakin.hotel_projekt.model.User;
import ch.anakin.hotel_projekt.service.Config;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * data handler for reading and writing the csv files
 *
 * @author Anakin Kirschler
 */
public class DataHandler {
    private static final DataHandler instance = new DataHandler();
    private static Map<String,Gast> gastMap = new HashMap<>();
    private static Map<String, Hotel> hotelMap = new HashMap<>();
    private static Integer integerTranslator = null;


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
            String gastPath = ch.anakin.hotel_projekt.service.Config.getProperty("gaesteFile");
            fileReader = new FileReader(gastPath);
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
                gast.setGastUUID(values[0]);
                gast.setVorname(values[1]);
                gast.setNachname(values[2]);
                gast.setAdresse(values[3]);
                gast.setHausnummer(values[4]);
                gast.setPlz(new Integer(values[5]));
                gast.setWohnort(values[6]);
                gast.setLand(values[7]);
                gast.setTelefon(values[8]);
                gast.setMobil(values[9]);
                gast.setGeburtsdatum(values[10]);
                gast.setMail(values[11]);
                gast.setCheck_in(values[12]);
                gast.setCheck_out(values[13]);

                gastMap.put(values[0], gast);

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
     * Read hotel.
     */
    public static void readHotel() {

        BufferedReader bufferedReader;
        FileReader fileReader;
        try {
            String hotelPath = ch.anakin.hotel_projekt.service.Config.getProperty("hotelFile");
            fileReader = new FileReader(hotelPath);
            bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException fileEx) {
            fileEx.printStackTrace();
            throw new RuntimeException();
        }

        try {
            String line;
            Hotel hotel = null;
            while ((line = bufferedReader.readLine()) != null) {
                hotel = new Hotel();
                String[] values = line.split(";");
                String[] gaeste = values[9].split(",");
                hotel.setHotelUUID(values[0]);
                hotel.setName(values[1]);
                hotel.setSterne(integerTranslator.parseInt(values[2]));
                hotel.setAdresse(values[3]);
                hotel.setHausnummer(values[4]);
                hotel.setPlz(integerTranslator.parseInt(values[5]));
                hotel.setWohnort(values[6]);
                hotel.setLand(values[7]);
                hotel.setBaujahr(values[8]);

                String uuidPlatzhalter = "";
                for (String gast : gaeste) {
                    Map<String, Gast> gastMap = DataHandler.getGastMap();

                    Map<String, Gast> result = gastMap.entrySet()
                            .stream()
                            .filter(entry -> entry.getKey().contains(gast))
                            .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

                    for(Map.Entry<String, Gast> entry: result.entrySet()){
                        hotel.addGast(entry.getKey(), entry.getValue());
                        uuidPlatzhalter += entry.getKey() + ",";
                    }
                }
                hotel.setGaesteListeString(uuidPlatzhalter.substring(0,uuidPlatzhalter.length()-1));

                hotelMap.put(values[0], hotel);

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
     * @param gastMap the gast Map
     */
    public static void writeGaeste(Map<String, Gast> gastMap) {
        Writer writer = null;
        FileOutputStream fileOutputStream = null;

        try {
            String gastPath = ch.anakin.hotel_projekt.service.Config.getProperty("gaesteFile");
            fileOutputStream = new FileOutputStream(gastPath);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "utf-8"));

            for (Map.Entry<String,Gast> gastEntry : gastMap.entrySet()) {
                Gast gast = gastEntry.getValue();
                String contents = String.join(";",
                        gast.getGastUUID(),
                        gast.getVorname(),
                        gast.getNachname(),
                        gast.getAdresse(),
                        gast.getHausnummer(),
                        gast.getPlz().toString(),
                        gast.getWohnort(),
                        gast.getLand(),
                        gast.getTelefon(),
                        gast.getMobil(),
                        gast.getGeburtsdatum(),
                        gast.getMail(),
                        gast.getCheck_in(),
                        gast.getCheck_out()
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
     * Wirte hotel.
     *
     * @param hotelMap the hotel map
     */
    public static void wirteHotel(Map<String, Hotel> hotelMap) {
        Writer writer = null;
        FileOutputStream fileOutputStream = null;

        try {
            String hotelPath = ch.anakin.hotel_projekt.service.Config.getProperty("hotelFile");
            fileOutputStream = new FileOutputStream(hotelPath);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "utf-8"));

            for (Map.Entry<String,Hotel> hotelEingabe : hotelMap.entrySet()) {

                Hotel hotel = hotelEingabe.getValue();


                String contents = String.join(";",
                        hotel.getHotelUUID(),
                        hotel.getName(),
                        hotel.getSterne().toString(),
                        hotel.getAdresse(),
                        hotel.getHausnummer(),
                        hotel.getPlz().toString(),
                        hotel.getWohnort(),
                        hotel.getLand(),
                        hotel.getBaujahr(),
                        hotel.getGaesteListeString()
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
     * Read user user.
     *
     * @param username the username
     * @param password the password
     * @return the user
     */
    public static User readUser(String username, String password) {

        BufferedReader bufferedReader;
        FileReader fileReader;
        try {
            String bookPath = Config.getProperty("userFile");
            fileReader = new FileReader(bookPath);
            bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException fileEx) {
            fileEx.printStackTrace();
            throw new RuntimeException();
        }

        try {
            String line;
            User user = new User();
            while ((line = bufferedReader.readLine()) != null && user.getUserRole().equals("guest" )) {
                String[] values = line.split(";");

                if (username.equals(values[0]) && password.equals(values[1])){
                    user.setUsername(values[0]);
                    user.setUserRole(values[2]);
                }

            }
            return user;
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
     * Gets the gastMap
     *
     * @return value of gastMap
     */
    public static Map<String, Gast> getGastMap() {
        if(gastMap.isEmpty()){
            readGaeste();
        }
        return gastMap;
    }

    /**
     * Sets the gastMap
     *
     * @param gastMap the value to set
     */
    public static void setGastMap(Map<String, Gast> gastMap) {
        DataHandler.gastMap = gastMap;
    }

    /**
     * Gets the hotelMap
     *
     * @return value of hotelMap
     */
    public static Map<String, Hotel> getHotelMap() {
        if (hotelMap.isEmpty()){
            readHotel();
        }

        return hotelMap;
    }

    /**
     * Sets the hotelMap
     *
     * @param hotelMap the value to set
     */
    public static void setHotelMap(Map<String, Hotel> hotelMap) {
        DataHandler.hotelMap = hotelMap;
    }
}
