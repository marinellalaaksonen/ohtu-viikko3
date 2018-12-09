package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Nollaa implements Komento {
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int edellinenTulos;

    public Nollaa (TextField tuloskentta, TextField syotekentta, 
            Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.edellinenTulos = 0;
    }

    @Override
    public void suorita() {
        edellinenTulos = sovellus.tulos();
        sovellus.nollaa();

        tuloskentta.setText("" + sovellus.tulos());
        nollaa.disableProperty().set(true);
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        sovellus.plus(edellinenTulos);

        int laskunTulos = sovellus.tulos();
        tuloskentta.setText("" + laskunTulos);

        nollaa.disableProperty().set(laskunTulos == 0);
        undo.disableProperty().set(true);
    }
}