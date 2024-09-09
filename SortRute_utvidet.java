class SortRute_utvidet extends Rute_utvidet {

    public SortRute_utvidet(int rad, int kol, Labyrint_utvidet lab) {
        super(rad, kol, lab);
        type = "sort";
        tegn = "#";
    }

    @Override
    public String toString() {
        return tegn;
    }

    @Override
    public String hentTegn() {
        return tegn;
    }

    @Override
    public void finn(Rute_utvidet fra) {
    }

}
