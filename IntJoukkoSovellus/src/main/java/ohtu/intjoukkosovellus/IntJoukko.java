package ohtu.intjoukkosovellus;

import java.util.Arrays;
import java.lang.*;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm = 0;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        luvut = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        luvut = new int[kapasiteetti];
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            return;
        }
        luvut = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            if (alkioidenLkm == luvut.length) {
                kasvataTaulukkoa();
            }
            luvut[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        if (etsiIndeksi(luku) == -1) return false;
        else return true;
    }

    public boolean poista(int luku) {
        if (etsiIndeksi(luku) == -1) return false;
        else {
            luvut[etsiIndeksi(luku)] = luvut[alkioidenLkm - 1];
            alkioidenLkm--;
            return true;
        }
    }

    private void kasvataTaulukkoa() {
        int[] uusi = new int[alkioidenLkm + kasvatuskoko];
        for (int i = 0; i < alkioidenLkm; i++) {
            uusi[i] = luvut[i];
        }
        luvut = uusi;
    }

    private int etsiIndeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return i;
            }
        }
        return -1;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) return "{}";
        else {
            String joukkoStringina = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                joukkoStringina += luvut[i] + ", ";
            }
            return joukkoStringina + luvut[alkioidenLkm - 1] + "}";
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvut[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        lisaaIntJoukko(yhdiste, a);
        lisaaIntJoukko(yhdiste, b);
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko aErotusB = erotus(a, b);
        IntJoukko yhdiste = erotus(a, aErotusB); // A /\ B = A - (A - B)
        return yhdiste;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        lisaaIntJoukko(erotus, a);
        poistaIntJoukko(erotus, b);
 
        return erotus;
    }

    private static void lisaaIntJoukko(IntJoukko x, IntJoukko lisattava) {
        int[] lisattavaListana = lisattava.toIntArray();
        for (int i = 0; i < lisattavaListana.length; i++) {
            x.lisaa(lisattavaListana[i]);
        }
    }

    private static void poistaIntJoukko(IntJoukko x, IntJoukko poistettava) {
        int[] poistettavaListana = poistettava.toIntArray();
        for (int i = 0; i < poistettavaListana.length; i++) {
            x.poista(poistettavaListana[i]);
        }
    }
        
}