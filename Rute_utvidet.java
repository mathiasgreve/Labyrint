abstract class Rute_utvidet {
    int radNr;
    int kolNr;
    int tall;
    static int tellervariabel = 1;
    Labyrint_utvidet lab;
    Rute_utvidet nord;
    Rute_utvidet sor;
    Rute_utvidet vest;
    Rute_utvidet ost;
    int antallNaboer = 0;
    String tegn;
    String type;
    Boolean besokt = false;

    public Rute_utvidet(int rad, int kol, Labyrint_utvidet lab) {
        this.radNr = rad;
        this.kolNr = kol;
        this.lab = lab;
    }

    void leggTilNaboVest(Rute_utvidet rute) {
        vest = rute;
        antallNaboer++;
    }

    void leggTilNaboOst(Rute_utvidet rute) {
        ost = rute;
        antallNaboer++;
    }

    void leggTilNaboNord(Rute_utvidet rute) {
        nord = rute;
        antallNaboer++;
    }

    void leggTilNaboSor(Rute_utvidet rute) {
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
    abstract public void finn(Rute_utvidet fra);

}
