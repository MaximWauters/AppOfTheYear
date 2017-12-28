package landermaxim.appoftheyear;

/**
 * Created by Lander on 20/12/2017.
 */

public class Medicate {
    String naam;
    String dagperiode;
    String note;

    public Medicate(){

    }

    public Medicate(String naam, String dagperiode, String note) {
        this.naam = naam;
        this.dagperiode = dagperiode;
        this.note = note;
    }

    public String getNaam() { return naam; }

    public String getTijd() {
        return dagperiode;
    }

    public String getNote() {
        return note;
    }
}
