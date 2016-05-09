package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        aloitaPeli();

    }

    public static void aloitaPeli() {
        while (true) {
            ohjeet();

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                aloitaIhmistaVastaan();
            } else if (vastaus.endsWith("b")) {
                aloitaHelppoaTekoalyaVastaan();
            } else if (vastaus.endsWith("c")) {
                aloitaVaikeaaTekoalyaVastaan();
            } else {
                break;
            }

        }
    }

    public static void aloitaIhmistaVastaan() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
        kaksinpeli.pelaa();
    }

    public static void aloitaHelppoaTekoalyaVastaan() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        KPSTekoaly yksinpeli = new KPSTekoaly();
        yksinpeli.pelaa();
    }

    public static void aloitaVaikeaaTekoalyaVastaan() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
        pahaYksinpeli.pelaa();
    }

    public static void ohjeet() {
        System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
    }

}
