package ch.anakin.hotel_projekt.model;

import ch.anakin.hotel_projekt.data.DataHandler;

import javax.ws.rs.FormParam;
import java.text.DateFormat;
import java.util.Vector;

/**
 * short description
 * <p>
 * Hotel_Projekt
 *
 * @author Anakin Kirschler
 * @version 1.0
 * @since 05.03.20
 */
public class Hotel {

    private String name;
    private int Sterne;
    private String adresse;
    private String hausnummer;
    private int plz;
    private String wohnort;
    private String land;
    private int baujahr;


    private String typ;
    private Vector<Gast> gaesteListe;

    public Hotel() {
        this.gaesteListe = DataHandler.getGastVector();
    }

    /**
     * Gets the name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name the value to set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Sterne
     *
     * @return value of Sterne
     */
    public int getSterne() {
        return Sterne;
    }

    /**
     * Sets the Sterne
     *
     * @param sterne the value to set
     */

    public void setSterne(int sterne) {
        Sterne = sterne;
    }

    /**
     * Gets the adresse
     *
     * @return value of adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets the adresse
     *
     * @param adresse the value to set
     */

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Gets the hausnummer
     *
     * @return value of hausnummer
     */
    public String getHausnummer() {
        return hausnummer;
    }

    /**
     * Sets the hausnummer
     *
     * @param hausnummer the value to set
     */

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    /**
     * Gets the plz
     *
     * @return value of plz
     */
    public int getPlz() {
        return plz;
    }

    /**
     * Sets the plz
     *
     * @param plz the value to set
     */

    public void setPlz(int plz) {
        this.plz = plz;
    }

    /**
     * Gets the wohnort
     *
     * @return value of wohnort
     */
    public String getWohnort() {
        return wohnort;
    }

    /**
     * Sets the wohnort
     *
     * @param wohnort the value to set
     */

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    /**
     * Gets the land
     *
     * @return value of land
     */
    public String getLand() {
        return land;
    }

    /**
     * Sets the land
     *
     * @param land the value to set
     */

    public void setLand(String land) {
        this.land = land;
    }

    /**
     * Gets the baujahr
     *
     * @return value of baujahr
     */
    public int getBaujahr() {
        return baujahr;
    }

    /**
     * Sets the baujahr
     *
     * @param baujahr the value to set
     */

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    /**
     * Gets the typ
     *
     * @return value of typ
     */
    public String getTyp() {
        return typ;
    }

    /**
     * Sets the typ
     *
     * @param typ the value to set
     */

    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * Gets the gaesteListe
     *
     * @return value of gaesteListe
     */
    public Vector<Gast> getGaesteListe() {
        return gaesteListe;
    }

    /**
     * Sets the gaesteListe
     *
     * @param gaesteListe the value to set
     */

    public void setGaesteListe(Vector<Gast> gaesteListe) {
        this.gaesteListe = gaesteListe;
    }
}
