package lektion5;

public class Person {
    private String namn;
    private int alder;

    // Konstruktor
    public Person(String namn, int alder) {
        this.namn = namn;
        this.alder = alder;
    }

    // Tom konstruktor med default-värden
    public Person() {
        namn = "Default Person";
        alder = 0;
    }

    public String getNamn () {
        return namn;
    }

    public void setNamn (String namn) {
        this.namn = namn;
    }

    public int getAlder () {
        return alder;
    }

    public void setAlder (int alder) {
        this.alder = alder;
    }

    public String getPerson() {
        return namn + " " + alder;
    }
}
