package ch.anakin.hotel_projekt.model;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Gast {
    /**
     * Personattribute
     */

    @FormParam("vorname")
    
    @Pattern(regexp = "[A-Z][a-zA-Z]*")
    @Size(min=1, max=50)
    private String vorname;

    @FormParam("nachname")

    @Size(min=1, max=50)
    @Pattern(regexp = "[A-Z][a-zA-Z]*")
    private String nachname;

    @FormParam("adresse")
    @Pattern(regexp = "[A-Za-z]*")
    private String adresse;

    @FormParam("hausnummer")
    
    @Pattern(regexp = "[0-9]*")
    private String hausnummer;

    @FormParam("plz")
    
    private Integer plz;

    @FormParam("wohnort")
    
    @Pattern(regexp = "[A-Za-z]*")
    private String wohnort;

    @FormParam("land")
    
    @Pattern(regexp = "[A-Za-z]*")
    private String land;

    /**
     * Validate international phone numbers in EPP format
     */
    @FormParam("telefon")
    @Pattern(regexp = "[0-9]*")
    private String telefon;

    /**
     * Validate international phone numbers in EPP format
     */
    @FormParam("mobil")
    
    @Pattern(regexp = "[0-9]*")
    private String mobil;

    /**
     * Regex check in set % get Geburtsdatum
     */
    @FormParam("geburtsdatum")
    
    //@Past
    private Date geburtsdatum;


    /**
     * Java email validation permitted by RFC822
     */
    @FormParam("mail")
    
    @Email
    private String mail;

    /**
     * Gästeattribute
     * regex check in set % get ckeck_in & check_out
     */

    @FormParam("check_in")
    
    private Date check_in;


    @FormParam("check_out")
    
    private Date check_out;



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
    public Date  getGeburtsdatum() {
        return geburtsdatum;
    }

    /**
     * Sets the geburtsdatum
     *
     * @param geburtsdatum the value to set
     */

    public void setGeburtsdatum(String geburtsdatum) {

        Date date = null;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try{
            date = df.parse(geburtsdatum);

        }catch (ParseException ex){
            System.out.println(ex);
        }
        this.check_in = date;


        this.geburtsdatum = date;
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

    public void setCheck_in(String check_in) {

        Date date = null;
        DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try{
            date = df2.parse(check_in);

        }catch (ParseException ex){
            System.out.println(ex);
        }
        this.check_in = date;

    }

    public void setCheck_in(Date date){this.check_in = check_in;}

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

    public void setCheck_out(String check_out) {
        Date date = null;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try{
            date = df.parse(check_out);

        }catch (ParseException ex){
            System.out.println(ex);
        }
        this.check_out = date;

    }





}
