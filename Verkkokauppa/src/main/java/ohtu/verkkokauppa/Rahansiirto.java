package ohtu.verkkokauppa;

public interface Rahansiirto {
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}