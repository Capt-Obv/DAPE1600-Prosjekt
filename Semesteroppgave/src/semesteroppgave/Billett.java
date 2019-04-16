package semesteroppgave;

public class Billett {
    private Lokale sted;
    private int plassNr;
    private Dato dato;
    private int pris;
    private Person kjøper;
    
    public Billett(Lokale sted, int plassNr, Dato dato, int pris, 
            Person kjøper) {
        this.sted = sted;
        this.plassNr = plassNr;
        this.dato = dato;
        this.pris = pris;
        this.kjøper = kjøper;
    }
    
    public void setSted(Lokale sted) {this.sted = sted;}
    public Lokale getSted() {return sted;}
    public void setPlassNr(int plassNr) {this.plassNr = plassNr;}
    public int getPlassNr() {return plassNr;}
    public void setTidspunkt(Dato dato) {this.dato = dato;}
    public Dato getTidspunkt() {return dato;}
    public void setPris(int pris) {this.pris = pris;}
    public int getPris() {return pris;}
    public void setPerson(Person kjøper) {this.kjøper = kjøper;}
    public Person getPerson() {return kjøper;}
    
    @Override
    public String toString() {
        return String.format("Sted: %d \nDato: %d \nPlassNr: %d \nPris: %d"
                + "\nKjøper: %d", sted, dato, plassNr, pris, kjøper);
    }
}
            
class Dato {
    private int år;
    private int måned;
    private int dag;
    
    public Dato(int år, int måned, int dag) {
        this.år = år;
        this.måned = måned;
        this.dag = dag;
    }
    
    public void setÅr(int år) {this.år = år;}
    public int getÅr() {return år;}
    public void setMåned(int måned) {this.måned = måned;}
    public int getMåned() {return måned;}
    public void setDag(int dag) {this.dag = dag;}
    public int getDag() {return dag;}
    
    @Override
    public String toString() {
        return String.format("%d/%d - %d %d:%d", dag, måned, år);
    }
}
