package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.KPSParempiTekoaly;
import ohtu.kivipaperisakset.KPSPelaajaVsPelaaja;
import ohtu.kivipaperisakset.KPSTekoaly;
import ohtu.kivipaperisakset.Tekoaly;
import ohtu.kivipaperisakset.TekoalyParannettu;
import java.util.Scanner;

public abstract class KPSPeli {
    Vastustaja vastustaja;
    private static final Scanner scanner = new Scanner(System.in);

    public static KPSPeli luoKPSPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }

    public static KPSPeli luoKPSTekoaly() {
        return new KPSTekoaly(new Tekoaly());
    }

    public static KPSPeli luoKPSParempiTekoaly() {
        return new KPSTekoaly(new TekoalyParannettu(20));
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto = siirto(ekanSiirto, scanner);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari + "\n");

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            tokanSiirto = siirto(ekanSiirto, scanner);
        }

        System.out.println("\n Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract String siirto(String ekaSiirto, Scanner scanner);
}