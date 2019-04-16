
package semesteroppgave;

/**
 *
 * @author sarah
 */
public class Lokale {
    private String navn;
    private int antPlasser;
    
    public Lokale(String navn, int antPlasser) {
        this.navn = navn;
        this.antPlasser = antPlasser;
    }
    
    public void setNavn(String navn) {this.navn = navn;}
    public String getNavn() {return navn;}
    public void setAntPlasser(int antPlasser) {this.antPlasser = antPlasser;}
    public int getAntPlasser() {return antPlasser;}
    
    @Override
    public String toString() {
        return String.format("Lokalets navn: %s \nKapasitet: %d",
                 navn, antPlasser);
    }
}

class Kino extends Lokale {
    public Kino(String navn, int antPlasser) {
        super(navn, antPlasser);
    }
    
    @Override
    public String toString() {
            return super.toString() + "Type: kino.";
            return super.toString() + "\nType: kino.";
    }
}

class Konsertsal extends Lokale {
    
    public Konsertsal(String navn, int antPlasser) {
        super(navn, antPlasser);
    }
    @Override
    public String toString() {
            return super.toString() + "\nType: konsertsal.";
    }
}

class Foredragsal extends Lokale {
    
    public Foredragsal(String navn, int antPlasser) {
        super(navn, antPlasser);
    }
    
    @Override
    public String toString() {
            return super.toString() + "\nType: foredragsal.";
    }
}

class Teatersal extends Lokale {
    public Teatersal(String navn, int antPlasser) {
        super(navn, antPlasser);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nType: teatersal.";
    }
}
