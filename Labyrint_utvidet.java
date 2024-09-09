import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Labyrint_utvidet {
    Rute_utvidet[][] rutenett;
    int antRader;
    int antKolonner;

    // konstruktør
    public Labyrint_utvidet(String filnavn) {
        // lese inn fil
        lesInnFil(filnavn);
    }

    // lager toString()
    @Override
    public String toString() {
        String lab = "";

        for (int radN = 0; radN < antRader; radN++) {
            for (int kolN = 0; kolN < antKolonner; kolN++) {
                if (rutenett[radN][kolN] instanceof SortRute_utvidet) {
                    lab += " # ";
                } else if (rutenett[radN][kolN] instanceof HvitRute_utvidet) {
                    if(rutenett[radN][kolN].tall > 0){
                        if(rutenett[radN][kolN].tall > 9){
                            lab+=rutenett[radN][kolN].tall+" ";  
                        } else{
                            lab+=" "+rutenett[radN][kolN].tall+" ";
                        }
                        
                    } else{
                        lab += " . ";
                    }
                    
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

        rutenett = new Rute_utvidet[antRader][antKolonner];

        // leser inn linje for linje
        String[] linje;
        int rad = 0;
        while (sc.hasNextLine()) {
            linje = sc.nextLine().split("");
            for (int i = 0; i < linje.length; i++) {
                // System.out.println("("+rad + ", "+i+"): "+linje[i]);
                if (linje[i].strip().equals("#")) {
                    // System.out.println("lager sort");
                    rutenett[rad][i] = new SortRute_utvidet(rad, i, this);
                } else if (linje[i].strip().equals(".")) {
                    // System.out.println("lager hvit");
                    if (rad == 0 || rad == antRader - 1 || i == 0 || i == antKolonner - 1) {
                        rutenett[rad][i] = new Aapning_utvidet(rad, i, this);
                    } else {
                        rutenett[rad][i] = new HvitRute_utvidet(rad, i, this);
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
        if(hentRute(rad,kol) instanceof Aapning_utvidet){
            System.out.println("Ferdig");
        }else if(hentRute(rad,kol).nord instanceof SortRute_utvidet && hentRute(rad,kol).nord instanceof SortRute_utvidet && hentRute(rad,kol).sor instanceof SortRute_utvidet && hentRute(rad,kol).ost instanceof SortRute_utvidet && hentRute(rad,kol).vest instanceof SortRute_utvidet){
            System.out.println("Innelaast rute...kommer ingen vei videre");
        }
        System.out.println("Labyrint etter gjnnomgang: ");
        System.out.print(this);
        
    }

    // hjelpemetoder
    void settNaboer(int rad, int kol) {
        Rute_utvidet denneRuta = hentRute(rad, kol);
        if (rad > 0) {
            Rute_utvidet naboN = hentRute(rad - 1, kol);
            denneRuta.leggTilNaboNord(naboN);
        }

        if (rad < antRader - 1) {
            Rute_utvidet naboS = hentRute(rad + 1, kol);
            denneRuta.leggTilNaboSor(naboS);
        }

        if (rad > 0) {
            Rute_utvidet naboV = hentRute(rad, kol - 1);
            denneRuta.leggTilNaboVest(naboV);
        }

        if (rad < antRader - 1) {
            Rute_utvidet naboO = hentRute(rad, kol + 1);
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

    Rute_utvidet hentRute(int rad, int kol) {
        if ((rad < antRader && kol < antKolonner) && (rad >= 0 && kol >= 0)) {
            return rutenett[rad][kol];
        } else
            return null;
    }

}