package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Tapahtumamuistio {
    public void lisaaTapahtuma(String tapahtuma);

    public ArrayList<String> getTapahtumat();    
}