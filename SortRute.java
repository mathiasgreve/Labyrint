class SortRute extends Rute {

    public SortRute(int rad, int kol, Labyrint lab) {
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
    public void finn(Rute fra) {
    }

}