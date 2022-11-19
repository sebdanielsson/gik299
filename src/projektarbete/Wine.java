package projektarbete;

public class Wine {
    // Instansvariabler
    private String tillverkare;
    private int pris;
    private int lagersaldo;
    private String vintage;
    private String namn;
    private String prodID;
    private String vintyp; // (Produkttyp)

    // Konstruktor
     public Wine(String namn, String tillverkare, String vintage, String vintyp, int pris, int lagersaldo, String prodID){
         this.prodID=prodID;
         this.namn= namn;
         this.tillverkare=tillverkare;
         this.vintage= vintage;
         this.vintyp= vintyp;
         this.pris=pris;
         this.lagersaldo= lagersaldo;
     }

     // Accessor
     public String getNamn() {
         return namn;
     }

     public String getTillverkare() {
         return tillverkare;
     }

     public String getVintage() {
         return vintage;
     }
     public String getVintyp(){
         return vintyp;
     }

    public int getPris() {
        return pris;
    }

    public int getLagersaldo() {
        return lagersaldo;
    }

    public String getProdID() {
        return prodID;
    }

    public String getWine(){
         return (namn + ", " + tillverkare + ", " + vintage + ", " + vintyp + ", " + pris + " kr, " + lagersaldo + " st, " + prodID);
    }

    // Mutator
    public void setPris(int pris) {
        this.pris = pris;
    }

    public void setLagersaldo(int lagersaldo) {
        this.lagersaldo = lagersaldo;
    }
}