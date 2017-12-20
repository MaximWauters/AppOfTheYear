package landermaxim.appoftheyear;

/**
 * Created by Lander on 20/12/2017.
 */

public class Medicate {
    String naam;
    String tijd;
    String note;

    public Medicate(){

    }

    public Medicate(String naam, String tijd, String note) {
        this.naam = naam;
        this.tijd = tijd;
        this.note = note;
    }

    public String getNaam() {
        return naam;
    }

    public String getTijd() {
        return tijd;
    }

    public String getNote() {
        return note;
    }
}
