class HvitRute_utvidet extends Rute_utvidet {


    public HvitRute_utvidet(int rad, int kol, Labyrint_utvidet lab) {
        super(rad, kol, lab);
        type = "hvit";
        tegn = ".";
    }

    @Override
    public String toString() {
        return ".";
    }

    @Override
    public void finn(Rute_utvidet fra) {
        this.besokt = true;
        tall=tellervariabel;
        tellervariabel++;
        if (fra == null) {
            // alle andre veier skal prøves
            nord.finn(this);
            sor.finn(this);
            ost.finn(this);
            vest.finn(this);
        } else if (fra == nord) {
            if(!sor.besokt){
                sor.finn(this);
            }
            if(!ost.besokt){
                ost.finn(this);
            }
            if(!vest.besokt){
               vest.finn(this); 
            }
            
        } else if (fra == sor) {
            if(!nord.besokt){
                nord.finn(this);
            }
            
            if(!ost.besokt){
                ost.finn(this);
            }
            if(!vest.besokt){
                vest.finn(this); 
             }
        } else if (fra == ost) {
            if(!nord.besokt){
                nord.finn(this);
            }
            if(!sor.besokt){
                sor.finn(this);
            }
            if(!vest.besokt){
                vest.finn(this); 
             }
        } else if (fra == vest) {
            if(!nord.besokt){
                nord.finn(this);
            }
            if(!sor.besokt){
                sor.finn(this);
            }
            if(!ost.besokt){
                ost.finn(this);
            }
        }
    }

    String hentType() {
        return type;
    }
}
