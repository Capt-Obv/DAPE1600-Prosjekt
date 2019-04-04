package semesteroppgave;

public class Person {
    private String navn;
    private int telefonNr;
    
    public Person(String navn, int telefonNr) {
        this.navn = navn;
        this.telefonNr = telefonNr;
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
}
