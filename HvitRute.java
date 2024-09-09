class HvitRute extends Rute {

    public HvitRute(int rad, int kol, Labyrint lab) {
        super(rad, kol, lab);
        type = "hvit";
        tegn = ".";
    }

    @Override
    public String toString() {
        return ".";
    }

    @Override
    public void finn(Rute fra) {
        this.besokt = true;
        if (fra == null) {
            // alle andre veier skal prøves
            nord.finn(this);
            sor.finn(this);
            ost.finn(this);
            vest.finn(this);
        } else if (fra == nord) {
            sor.finn(this);
            ost.finn(this);
            vest.finn(this);
        } else if (fra == sor) {
            nord.finn(this);
            ost.finn(this);
            vest.finn(this);
        } else if (fra == ost) {
            nord.finn(this);
            sor.finn(this);
            vest.finn(this);
        } else if (fra == vest) {
            nord.finn(this);
            sor.finn(this);
            ost.finn(this);
        }
    }

    String hentType() {
        return type;
    }
}