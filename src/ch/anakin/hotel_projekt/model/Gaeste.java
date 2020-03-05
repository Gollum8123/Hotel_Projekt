package ch.anakin.hotel_projekt.model;

import java.util.Date;

/**
 * short description
 * <p>
 * Hotel_Projekt
 *
 * @author Anakin Kirschler
 * @version 1.0
 * @since 05.03.20
 */
public class Gaeste {
    /**
     * Personattribute
     */
    private String vorname;
    private String nachname;
    private String adresse;
    private String hausnummer;
    private int plz;
    private String wohnort;
    private String land;
    private String telefon;
    private String mobil;
    private Date geburtsdatum;
    private String mail;

    /**
     * Gästeattribute
     */
    private Date check_in;
    private Date check_out;
    private String kredidkarten_infos;

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
    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    /**
     * Sets the geburtsdatum
     *
     * @param geburtsdatum the value to set
     */

    public void setGeburtsdatum(Date geburtsdatum) {
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
    public Date getCheck_in() {
        return check_in;
    }

    /**
     * Sets the check_in
     *
     * @param check_in the value to set
     */

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    /**
     * Gets the check_out
     *
     * @return value of check_out
     */
    public Date getCheck_out() {
        return check_out;
    }

    /**
     * Sets the check_out
     *
     * @param check_out the value to set
     */

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    /**
     * Gets the kredidkarten_infos
     *
     * @return value of kredidkarten_infos
     */
    public String getKredidkarten_infos() {
        return kredidkarten_infos;
    }

    /**
     * Sets the kredidkarten_infos
     *
     * @param kredidkarten_infos the value to set
     */

    public void setKredidkarten_infos(String kredidkarten_infos) {
        this.kredidkarten_infos = kredidkarten_infos;
    }
}
