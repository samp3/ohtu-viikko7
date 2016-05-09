package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends peliToiminnot {

    private static final Scanner scanner = new Scanner(System.in);
    private Tuomari tuomari;
    private String ekanSiirto;
    private String tokanSiirto;
    private Tekoaly tekoaly;

    public void pelaa() {

        kysySirrot();
        peliLoop();
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }


    @Override
    public void kysySirrot() {
        tuomari = new Tuomari();
        tekoaly = new Tekoaly();

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
}
