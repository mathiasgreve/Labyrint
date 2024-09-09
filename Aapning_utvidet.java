class Aapning_utvidet extends HvitRute_utvidet {

    public Aapning_utvidet(int rad, int kol, Labyrint_utvidet lab) {
        super(rad, kol, lab);
        type = "aapning";
        tegn = ".";
    }

    @Override
    public void finn(Rute_utvidet fra) {
        tall=tellervariabel;
        System.out.println("Aapning: (" + this.radNr + ", " + this.kolNr + ")");
        return;
    }

}
