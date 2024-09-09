public class Hovedprogram {
    public static void main(String[] args) {
        Labyrint labyrint = new Labyrint("3.in");
        System.out.println("Antall kolonner: "+labyrint.antKolonner);
        System.out.println("Antall rader: "+labyrint.antRader);
        // System.out.print("Test info om rute (0,0) er korrekt (korrekt svar i parentes). \nAntall naboer (2):  ");
        // labyrint.hentRute(0,0).skrivAntallNaboer();
        // System.out.println("Nabo nord (null): "+labyrint.hentRute(0,0).nord);
        // System.out.println("Nabo sør (sort): "+labyrint.hentRute(0,0).sor);
        // System.out.print("Test info om rute (1,1) er korrekt (korrekt svar i parentes). \nAntall naboer (4):  ");        labyrint.hentRute(1,1).skrivAntallNaboer();
        // System.out.println("Nabo nord (sort): "+labyrint.hentRute(1,1).nord);
        // System.out.println("Nabo sør (hvit): "+labyrint.hentRute(1,1).sor);
        // System.out.println("Riktig aapning?: "+labyrint.hentRute(0,5).hentType());
        // System.out.println(labyrint);
        // System.out.println(labyrint.rekursjon(10));
        labyrint.finnVeiUtFra(1,5);
    }
}
