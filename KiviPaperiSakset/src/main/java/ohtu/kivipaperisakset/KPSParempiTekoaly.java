package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends peliToiminnot {

    private static final Scanner scanner = new Scanner(System.in);
    private Tuomari tuomari;
    private String ekanSiirto;
    private String tokanSiirto;
    private TekoalyParannettu tekoaly;

    @Override
    public void pelaa() {
        kysySirrot();
        peliLoop();
        loppuPrint(tuomari);
    }

    @Override
    public void kysySirrot() {
        tuomari = new Tuomari();
        tekoaly = new TekoalyParannettu(20);
        System.out.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = scanner.nextLine();
        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
    }

    @Override
    public void peliLoop() {
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);

        }
    }

    private void loppuPrint(Tuomari tuomari) {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

}
