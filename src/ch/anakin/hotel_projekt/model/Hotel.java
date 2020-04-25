package ch.anakin.hotel_projekt.model;

import ch.anakin.hotel_projekt.data.DataHandler;

import javax.ws.rs.FormParam;
import java.util.Map;


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

    @FormParam("hotelUUID")
    private String hotelUUID;

    @FormParam("name")
    private String name;

    @FormParam("Sterne")
    private Integer sterne;

    @FormParam("adresse")
    private String adresse;

    @FormParam("hausnummer")
    private String hausnummer;

    @FormParam("plz")
    private Integer plz;

    @FormParam("wohnort")
    private String wohnort;

    @FormParam("land")
    private String land;

    @FormParam("baujahr")
    private String baujahr;

    @FormParam("gaesteListe")
    private Map<String, Gast> gaesteListe;




    /**
     * Gets the hotelUUID
     *
     * @return value of hotelUUID
     */
    public String getHotelUUID() {
        return hotelUUID;
    }

    /**
     * Sets the hotelUUID
     *
     * @param hotelUUID the value to set
     */

    public void setHotelUUID(String hotelUUID) {
        this.hotelUUID = hotelUUID;
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
    public Integer getSterne() {
        return sterne;
    }

    /**
     * Sets the Sterne
     *
     * @param sterne the value to set
     */

    public void setSterne(Integer sterne) {
        this.sterne = sterne;
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
    public Integer getPlz() {
        return plz;
    }

    /**
     * Sets the plz
     *
     * @param plz the value to set
     */

    public void setPlz(Integer plz) {
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
    public String getBaujahr() {
        return baujahr;
    }

    /**
     * Sets the baujahr
     *
     * @param baujahr the value to set
     */

    public void setBaujahr(String baujahr) {
        this.baujahr = baujahr;
    }


    /**
     * Gets the gaesteListe
     *
     * @return value of gaesteListe
     */
    public Map<String, Gast> getGaesteListe() {
        return gaesteListe;
    }

    /**
     * Sets the gaesteListe
     *
     * @param gaesteListe the value to set
     */

    public void setGaesteListe(Map<String, Gast> gaesteListe) {
        this.gaesteListe = gaesteListe;
    }




}
