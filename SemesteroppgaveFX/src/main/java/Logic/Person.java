/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

public class Person {
    private String navn;
    private int telefonNr;
    
    public Person(String navn, int telefonNr) {
        this.navn = navn;
        this.telefonNr = telefonNr;
    }
    
    public void setNavn(String navn) {this.navn = navn;}
    public String getNavn() {return navn;}
    public void setTelefonNr(int telefonNr) {this.telefonNr = telefonNr;}
    public int getTelefonNr() {return telefonNr;}
    
    @Override
    public String toString() {
        return String.format("Navn: %s \nTelefonnummer: %d", navn, telefonNr);
    }
}

class Kontaktperson extends Person {
    private String epostadresse, opplysninger;
    private String nettside = null;
    private String firma = null;
    
    public Kontaktperson(String navn, int telefonNr, String epostadresse, String
            opplysninger) {
        super(navn, telefonNr);
        this.epostadresse = epostadresse;
        this.opplysninger = opplysninger;
    }
    
        public Kontaktperson(String navn, int telefonNr, String epostadresse, String
            opplysninger, String nettside) {
        super(navn, telefonNr);
        this.epostadresse = epostadresse;
        this.opplysninger = opplysninger;
        this.nettside = nettside;
    }
    
    public Kontaktperson(String navn, int telefonNr, String epostadresse, String
            opplysninger, String nettside, String firma) {
        super(navn, telefonNr);
        this.epostadresse = epostadresse;
        this.opplysninger = opplysninger;
        this.nettside = nettside;
        this.firma = firma;
    }
    
    public void setEpostadresse(String epostadresse) {this.epostadresse
            = epostadresse;}
    public String getEpostadresse() {return epostadresse;}
    public void setOpplysninger(String opplysninger) {this.opplysninger
            = opplysninger;}
    public String getOpplysninger() {return opplysninger;}
    public void setNettside(String nettside) {this.nettside = nettside;}
    public String getNettside() {return nettside;}
    public void setFirma(String firma) {this.firma = firma;}
    public String getFirma() {return firma;}
    
    @Override
    public String toString() {
        String result = super.toString();
        if(nettside == null && firma == null) {
            result += String.format("\nEpostadresse: %s"
                    + "\nOpplysninger: %s", epostadresse, opplysninger);
        } else if (nettside != null && firma!= null) {
            result += String.format("\nEpostadresse: %s"
                + "\nOpplysninger: %s \nNettside: %s \nFirma: %s",
                    epostadresse, opplysninger, nettside, firma); 
        } else if(nettside != null && firma == null) {
            result += String.format("\nEpostadresse: %s"
                    + "\nOpplysninger: %s \nNettside: %s", epostadresse,
                    opplysninger, nettside);
        } else {
            result += String.format("\nEpostadresse: %s"
                    + "\nOpplysninger: %s \nFirma: %s", epostadresse,
                    opplysninger, firma);
        }
        return result;
    }
}
