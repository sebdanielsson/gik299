package laboration1;

public class Flygtider {
    public static void main(String[] args) {
        //skriva ut * samt byta rad
        System.out.println("*************************************************************** \n");
        //Skriva ut frågan samt byta rad
        System.out.println("Vilken tid anländer flyget från Stockholm i Miami? \n");
        // Skriv ut mening och beräkna ankomsttid (10h 20 min) justerat för tidszon(-6h) samt byta rad.
        System.out.println("Avgångstiden från Arlanda kl. 09:39, anländer i Miami kl. "+(9+10-6)+":"+(39+20)+"\n");
        //skriva ut * samt byta rad
        System.out.println("*************************************************************** \n");
        //Skriva ut frågan samt byta rad
        System.out.println("Vilken tid anländer flyget från Miami på Arlanda?\n");
        // Skriv ut mening och beräkna ankomsttid (10h 20 min) justerat för tidszon(+6h) samt byta rad.
        System.out.println("Avgångstid från Miami kl. 07:13, anländer på Arlanda kl. "+(7+10+6)+":"+(13+20)+"\n");
        //skriva ut * samt byta rad
        System.out.println("*************************************************************** \n");
    }
}
