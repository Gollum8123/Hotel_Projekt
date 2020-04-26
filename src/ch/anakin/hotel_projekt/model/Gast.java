package ch.anakin.hotel_projekt.model;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;

/**
 * short description
 * <p>
 * gast modelclass
 * <p>
 * Hotel_Projekt
 *
 * @author Anakin Kirschler
 * @version 1.0
 * @since 05.03.20
 */
public class Gast {
    /**
     * Personattribute
     */
    @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    @FormParam("gastUUID")
    private String gastUUID;

    @FormParam("vorname")
    @Pattern(regexp = "[A-Z][a-z]*")
    @Size(min = 1, max = 50)
    @NotEmpty
    private String vorname;


    @FormParam("nachname")
    @Size(min = 1, max = 50)
    @Pattern(regexp = "[A-Z][a-z]*")
    @NotEmpty
    private String nachname;

    @FormParam("adresse")
    @Size(min=1, max=50)
    @Pattern(regexp = "[A-Za-z]*")
    @NotEmpty
    private String adresse;

    @FormParam("hausnummer")
    @Size(min=1, max=6)
    @NotEmpty
    private String hausnummer;


    @Min(value = 1)
    @Max(value = 999999)
    @NotNull
    @FormParam("plz")
    private Integer plz;

    @FormParam("wohnort")
    @Pattern(regexp = "[A-Za-z]*")
    @NotEmpty
    private String wohnort;

    @FormParam("land")
    @Pattern(regexp = "[A-Za-z]*")
    @NotEmpty
    private String land;

    /**
     * Validate international phone numbers in EPP format
     */
    @FormParam("telefon")
    @Size(min=7, max=40)
    private String telefon;

    /**
     * Validate international phone numbers in EPP format
     */
    @FormParam("mobil")
    @NotEmpty
    @Size(min=7, max=40)
    private String mobil;

    /**
     *
     */
    @FormParam("geburtsdatum")
    @NotEmpty
    @Pattern(regexp = "[0-9]{2}.[0-9]{2}.[0-9]{4}")
    private String geburtsdatum;


    /**
     * Java email validation permitted by RFC822
     */
    @FormParam("mail")
    @NotEmpty
    @Email
    private String mail;

    /**
     * Gästeattribute
     *
     */

    @FormParam("check_in")
    @NotEmpty
    @Pattern(regexp = "[0-9]{2}.[0-9]{2}.[0-9]{4}")
    private String check_in;


    @FormParam("check_out")
    @NotEmpty
    @Pattern(regexp = "[0-9]{2}.[0-9]{2}.[0-9]{4}")
    private String check_out;


    /**
     * Gets the gastUUID
     *
     * @return value of gastUUID
     */
    public String getGastUUID() {
        return gastUUID;
    }

    /**
     * Sets the gastUUID
     *
     * @param gastUUID the value to set
     */
    public void setGastUUID(String gastUUID) {
        this.gastUUID = gastUUID;
    }

    /**
     * Gets the vorname
     *
     * @return value of vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Sets the vorname
     *
     * @param vorname the value to set
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * Gets the nachname
     *
     * @return value of nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Sets the nachname
     *
     * @param nachname the value to set
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
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
     * Gets the telefon
     *
     * @return value of telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Sets the telefon
     *
     * @param telefon the value to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Gets the mobil
     *
     * @return value of mobil
     */
    public String getMobil() {
        return mobil;
    }

    /**
     * Sets the mobil
     *
     * @param mobil the value to set
     */
    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    /**
     * Gets the geburtsdatum
     *
     * @return value of geburtsdatum
     */
    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    /**
     * Sets the geburtsdatum
     *
     * @param geburtsdatum the value to set
     */
    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    /**
     * Gets the mail
     *
     * @return value of mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets the mail
     *
     * @param mail the value to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Gets the check_in
     *
     * @return value of check_in
     */
    public String getCheck_in() {
        return check_in;
    }

    /**
     * Sets the check_in
     *
     * @param check_in the value to set
     */
    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    /**
     * Gets the check_out
     *
     * @return value of check_out
     */
    public String getCheck_out() {
        return check_out;
    }

    /**
     * Sets the check_out
     *
     * @param check_out the value to set
     */
    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }
}
