package lektion6;

public class Kategori {
    // Instansdata
    private String namn;
    private int antal;

    // Konstruktor
    public Kategori(String namn, int antal) {
        this.namn = namn;
        this.antal = antal;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }
}
