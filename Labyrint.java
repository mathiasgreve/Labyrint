import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Labyrint {
    Rute[][] rutenett;
    int antRader;
    int antKolonner;

    // konstruktør
    public Labyrint(String filnavn) {
        // lese inn fil
        lesInnFil(filnavn);
    }

    // lager toString()
    @Override
    public String toString() {
        String lab = "";

        for (int radN = 0; radN < antRader; radN++) {
            for (int kolN = 0; kolN < antKolonner; kolN++) {
                if (rutenett[radN][kolN] instanceof SortRute) {
                    lab += "#";
                } else if (rutenett[radN][kolN] instanceof HvitRute) {
                    lab += ".";
                }
            }
            lab += "\n";
        }

        return lab;
    }

    // leser inn fil
    private void lesInnFil(String filnavn) {
        File fil = new File(filnavn);

        Scanner sc = null;
        try {
            sc = new Scanner(fil);
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen: " + fil.getName());
            System.exit(1);
        }

        String[] rutenettInfo;
        rutenettInfo = sc.nextLine().split(" ");
        antRader = Integer.parseInt(rutenettInfo[0]);
        antKolonner = Integer.parseInt(rutenettInfo[1]);

        rutenett = new Rute[antRader][antKolonner];

        // leser inn linje for linje
        String[] linje;
        int rad = 0;
        while (sc.hasNextLine()) {
            linje = sc.nextLine().split("");
            for (int i = 0; i < linje.length; i++) {
                // System.out.println("("+rad + ", "+i+"): "+linje[i]);
                if (linje[i].strip().equals("#")) {
                    // System.out.println("lager sort");
                    rutenett[rad][i] = new SortRute(rad, i, this);
                } else if (linje[i].strip().equals(".")) {
                    // System.out.println("lager hvit");
                    if (rad == 0 || rad == antRader - 1 || i == 0 || i == antKolonner - 1) {
                        rutenett[rad][i] = new Aapning(rad, i, this);
                    } else {
                        rutenett[rad][i] = new HvitRute(rad, i, this);
                    }

                }
            }
            rad++;
        }

        // lager ruter (hvit eller sort)

        // setter nabo-koblinger
        kobleSammenRuter();

        // sjekker at alt er gjort riktig - skriver ut labyrinten
        System.out.println(this);

    }

    // finner veien ut
    void finnVeiUtFra(int rad, int kol) {
        System.out.println("Finner vei ut fra " + "(" + rad + "," + kol + ")");
        // skal kalle på finn()-metoden på den ruta som ligger i posisjonen (rad,kol)
        hentRute(rad, kol).finn(null);
        if(hentRute(rad,kol) instanceof Aapning){
            System.out.println("Ferdig");
        }else if(hentRute(rad,kol).nord instanceof SortRute && hentRute(rad,kol).nord instanceof SortRute && hentRute(rad,kol).sor instanceof SortRute && hentRute(rad,kol).ost instanceof SortRute && hentRute(rad,kol).vest instanceof SortRute){
            System.out.println("Innelaast rute...kommer ingen vei videre");
        }
    }

    // hjelpemetoder
    void settNaboer(int rad, int kol) {
        Rute denneRuta = hentRute(rad, kol);
        if (rad > 0) {
            Rute naboN = hentRute(rad - 1, kol);
            denneRuta.leggTilNaboNord(naboN);
        }

        if (rad < antRader - 1) {
            Rute naboS = hentRute(rad + 1, kol);
            denneRuta.leggTilNaboSor(naboS);
        }

        if (rad > 0) {
            Rute naboV = hentRute(rad, kol - 1);
            denneRuta.leggTilNaboVest(naboV);
        }

        if (rad < antRader - 1) {
            Rute naboO = hentRute(rad, kol + 1);
            denneRuta.leggTilNaboOst(naboO);
        }
    }

    void kobleSammenRuter() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                settNaboer(rad, kol);
            }
        }
    }

    Rute hentRute(int rad, int kol) {
        if ((rad < antRader && kol < antKolonner) && (rad >= 0 && kol >= 0)) {
            return rutenett[rad][kol];
        } else
            return null;
    }

}