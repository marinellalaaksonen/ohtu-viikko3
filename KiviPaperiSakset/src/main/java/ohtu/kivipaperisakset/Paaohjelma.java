package ohtu.kivipaperisakset;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashSet<String> sallitutSyotteet = alustaSallitut();

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();

            if (!sallitutSyotteet.contains(vastaus)) break;

            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            
            KPSPeli peli;
            if (vastaus.equals("a")) {peli = KPSPeli.luoKPSPelaajaVsPelaaja();}
            else if (vastaus.endsWith("b")) {peli = KPSPeli.luoKPSTekoaly();}
            else {peli = KPSPeli.luoKPSParempiTekoaly();}

            peli.pelaa();
        }

    }

    public static HashSet<String> alustaSallitut() {
        return new HashSet<String>(Arrays.asList("a", "b", "c"));
    }
}
