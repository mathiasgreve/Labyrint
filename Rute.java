abstract class Rute {
    int radNr;
    int kolNr;
    Labyrint lab;
    Rute nord;
    Rute sor;
    Rute vest;
    Rute ost;
    int antallNaboer = 0;
    String tegn;
    String type;
    Boolean besokt = false;

    public Rute(int rad, int kol, Labyrint lab) {
        this.radNr = rad;
        this.kolNr = kol;
        this.lab = lab;
    }

    void leggTilNaboVest(Rute rute) {
        vest = rute;
        antallNaboer++;
    }

    void leggTilNaboOst(Rute rute) {
        ost = rute;
        antallNaboer++;
    }

    void leggTilNaboNord(Rute rute) {
        nord = rute;
        antallNaboer++;
    }

    void leggTilNaboSor(Rute rute) {
        sor = rute;
        antallNaboer++;
    }

    void skrivAntallNaboer() {
        System.out.println(antallNaboer);
    }

    public String hentTegn() {
        return tegn;
    }

    String hentType() {
        return type;
    }

    //
    abstract public void finn(Rute fra);

}