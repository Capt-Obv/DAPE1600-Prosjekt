/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author sarah
 */
public class Lokale {
    private String navn;
    private final int antPlasser;
    private String type;
    
    public Lokale(String navn, int antPlasser, String type) {
        this.navn = navn;
        this.antPlasser = antPlasser;
    }
    
    public void setNavn(String navn) {this.navn = navn;}
    public String getNavn() {return navn;}
    public int getAntPlasser() {return antPlasser;}
    public String getType() {return type;}
    
    @Override
    public String toString() {
        return String.format("Lokalets navn: %s \nKapasitet: %d \nType: %s",
                 navn, antPlasser, type);
    }
}

class Kino extends Lokale {
    public Kino(String navn, int antPlasser) {
        super(navn, antPlasser, "kino");
    }
}

class Konsertsal extends Lokale {
    private String type = "konsertsal";
    public Konsertsal(String navn, int antPlasser) {
        super(navn, antPlasser,"konsertsal");
    }
}

class Foredragsal extends Lokale {
    public Foredragsal(String navn, int antPlasser) {
        super(navn, antPlasser, "foredragsal");
    }
}

class Teatersal extends Lokale {
    public Teatersal(String navn, int antPlasser) {
        super(navn, antPlasser, "teatersal");
    }
}

