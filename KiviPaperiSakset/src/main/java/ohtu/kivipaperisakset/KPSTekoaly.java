package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPSPeli {
    private Vastustaja tekoaly;

    public KPSTekoaly(Vastustaja tekoaly) {
        this.tekoaly = tekoaly;
    }

    @Override
    public String siirto(String ekanSiirto, Scanner scanner) {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}