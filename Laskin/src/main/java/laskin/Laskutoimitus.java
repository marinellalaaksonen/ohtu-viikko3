package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Laskutoimitus implements Komento {
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    protected Sovelluslogiikka sovellus;
    private int edellinenLuku;

    public Laskutoimitus (TextField tuloskentta, TextField syotekentta, 
            Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.edellinenLuku = 0;
    }

    private int lueLuku() {
        int luku = 0;

        try {
            luku = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        this.edellinenLuku = luku;

        return luku;
    }

    private void tulosta() {
        int laskunTulos = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        nollaa.disableProperty().set(laskunTulos == 0);
    }

    @Override
    public void suorita() {
        laske(lueLuku());
        tulosta();

        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        eiku(edellinenLuku);
        edellinenLuku = 0;

        tulosta();

        undo.disableProperty().set(true);
    }

    abstract void laske(int luku);
    abstract void eiku(int luku);
}