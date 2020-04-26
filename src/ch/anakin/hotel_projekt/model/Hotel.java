package ch.anakin.hotel_projekt.model;

import ch.anakin.hotel_projekt.data.DataHandler;
import com.sun.xml.internal.ws.util.StringUtils;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;
import java.util.HashMap;
import java.util.Map;


/**
 * short description
 * <p>
 * hotel modelcalss
 * <p>
 * Hotel_Projekt
 *
 * @author Anakin Kirschler
 * @version 1.0
 * @since 05.03.20
 */
public class Hotel {

    @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    @FormParam("hotelUUID")
    private String hotelUUID;


    @FormParam("name")
    @Pattern(regexp = "[A-Za-z]*")
    @NotEmpty
    @Size(min=1, max=50)
    private String name;

    @FormParam("sterne")
    @Min(value = 0)
    @Max(value = 6)
    @NotNull
    private Integer sterne;

    @Size(min=1, max=50)
    @Pattern(regexp = "[A-Za-z]*")
    @NotEmpty
    @FormParam("adresse")
    private String adresse;

    @Size(min=1, max=10)
    @FormParam("hausnummer")
    @NotEmpty
    private String hausnummer;

    @Min(value = 1)
    @Max(value = 999999)
    @FormParam("plz")
    @NotNull
    private Integer plz;

    @Size(min=1, max=15)
    @Pattern(regexp = "[a-zA-Z]*")
    @FormParam("ort")
    @NotEmpty
    private String wohnort;

    @Size(min=1, max=56)
    @Pattern(regexp = "[a-zA-Z]*")
    @FormParam("land")
    @NotEmpty
    private String land;

    @Pattern(regexp = "\\d{4}")
    @FormParam("baujahr")
    @NotEmpty
    private String baujahr;


    private Map<String, Gast> gaesteListe = new HashMap<>();


    @FormParam("gaesteListe")
    private String gaesteListeString;


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

    /**
     * Add gast.
     *
     * @param s    the s
     * @param gast the gast
     */
    public void addGast(String s, Gast gast){
        gaesteListe.put(s,gast);
    }

    /**
     * Gets the gaesteListeString
     *
     * @return value of gaesteListeString
     */
    public String getGaesteListeString() {
        return gaesteListeString;
    }

    /**
     * Sets the gaesteListeString
     *
     * @param gaesteListeString the value to set
     */
    public void setGaesteListeString(String gaesteListeString) {
        this.gaesteListeString = gaesteListeString;

    }
}
