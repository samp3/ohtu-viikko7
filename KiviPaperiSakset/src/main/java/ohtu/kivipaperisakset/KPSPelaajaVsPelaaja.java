package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends peliToiminnot {

    private static final Scanner scanner = new Scanner(System.in);
    private Tuomari tuomari;
    private String ekanSiirto;
    private String tokanSiirto;

    public static String kysySiirto(int a) {

        if (a == 1) {
            System.out.print("Ensimmäisen pelaajan siirto: ");

        } else {
            System.out.print("Toisen pelaajan siirto: ");
        }
        String ekanSiirto = scanner.nextLine();
        return ekanSiirto;
    }

    public void pelaa() {
        tuomari = new Tuomari();

        ekanSiirto = kysySiirto(1);
        tokanSiirto = kysySiirto(2);

        peliLoop();
        loppuprint(tuomari);

    }

    @Override
    public void kysySirrot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void peliLoop() {
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = kysySiirto(1);
            tokanSiirto = kysySiirto(2);

        }
    }
}
