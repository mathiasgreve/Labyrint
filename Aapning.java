class Aapning extends HvitRute {

    public Aapning(int rad, int kol, Labyrint lab) {
        super(rad, kol, lab);
        type = "aapning";
        tegn = ".";
    }

    @Override
    public void finn(Rute fra) {
        System.out.println("Aapning: (" + this.radNr + ", " + this.kolNr + ")");
        return;
    }

}