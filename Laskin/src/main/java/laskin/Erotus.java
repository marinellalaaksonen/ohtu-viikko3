package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Laskutoimitus {

    public Erotus(TextField tuloskentta, TextField syotekentta, 
            Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    protected void laske(int luku) {
        sovellus.miinus(luku);
    }

    @Override
    protected void eiku(int luku) {
        sovellus.plus(luku);
    }
}