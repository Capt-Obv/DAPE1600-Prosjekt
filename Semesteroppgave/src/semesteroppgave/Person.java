package semesteroppgave;

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
        return String.format("Navn: %d \nTelefonnummer: %d", navn, telefonNr);
    }
}

class Kontaktperson extends Person {
    private String epostadresse, opplysninger;
    private String nettside = "";
    private String firma = "";
    
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
    
    public Kontaktperson(String navn, String epostadresse, int telefonNr, String
            opplysninger, String firma) {
        super(navn, telefonNr);
        this.epostadresse = epostadresse;
        this.opplysninger = opplysninger;
        this.firma = firma;
    }
    
    public Kontaktperson(String navn, String epostadresse, int telefonNr, String
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
        if(nettside.length() == 0 && firma.length() == 0) {
            result += String.format("\nEpostadresse: %d"
                    + "\nOpplysninger: %d", epostadresse, opplysninger);
        } else if (nettside.length() != 0 && firma.length() != 0) {
            result += String.format("\nEpostadresse: %d"
                + "\nOpplysninger: %d \nNettside: %d \nFirma: %d",
                    epostadresse, opplysninger, nettside, firma); 
        } else if(nettside.length() != 0 && firma.length() == 0) {
            result += String.format("\nEpostadresse: %d"
                    + "\nOpplysninger: %d \nNettside: %d", epostadresse,
                    opplysninger, nettside);
        } else {
            result += String.format("\nEpostadresse: %d"
                    + "\nOpplysninger: %d \nFirma: %d", epostadresse,
                    opplysninger, firma);
        }
        return result;
    }
}
