package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    public String siirto(String ekanSiirto, Scanner scanner) {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
}