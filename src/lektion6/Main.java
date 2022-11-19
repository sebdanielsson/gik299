package lektion6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Kategori[] kategorier = new Kategori[10];

        kategorier[0] = new Kategori("Bravo", 1);
        kategorier[1] = new Kategori("Charlie", 2);
        kategorier[2] = new Kategori("Delta", 4);
        kategorier[3] = new Kategori("Echo", 8);
        kategorier[4] = new Kategori("Alpha", 16);

        System.out.println("*** Visa alla ***");
        for (Kategori kat:kategorier) {
           if (kat !=null) {
               System.out.println(kat.getNamn() + " " + kat.getAntal());
           }
        }

        int total = 0;

        for (Kategori kat:kategorier) {
            if (kat != null) {
                total += kat.getAntal();
            }
        }

        System.out.println("*** Summan av alla kategoier ***");
        System.out.println("\nSumman av alla kategoier: " + total);

        // Söka (Read i CRUD)
        System.out.println("\n*** Söka ett objekt ***");
        String finnKategori = "Bravo";
        Kategori funnenKategori = null;

        for (Kategori kat:kategorier) {
            if (kat != null) {
                if (finnKategori.equalsIgnoreCase(kat.getNamn())) {
                    funnenKategori = kat;
                    break;
                }
            }
        }

        if (funnenKategori != null) {
            System.out.println("Fann sökresultat " + finnKategori + " med antal: " + funnenKategori.getAntal());
        } else {
            System.out.println("Kunde inte hitta " + finnKategori + ".");
        }

        // Uppdatera ett objekt
        System.out.println("\n*** Uppdatera ett objekt ***");
        finnKategori = "Bravo";
        funnenKategori = null;

        for (Kategori kat:kategorier) {
            if (kat != null) {
                if (finnKategori.equalsIgnoreCase(kat.getNamn())) {
                    funnenKategori = kat;
                    break;
                }
            }
        }

        if (funnenKategori != null) {
            funnenKategori.setNamn("BRAVO");
            System.out.println("Du sökte på " + finnKategori + "och den heter nu " + funnenKategori.getNamn());
        } else {
            System.out.println("Du sökte på " + finnKategori + " och den fanns inte.");
        }

        for (Kategori kat : kategorier) {
            if (kat != null) {
                System.out.println(kat.getNamn() + " " + kat.getAntal());
            }
        }

        // Delete
        System.out.println("\n*** Delete ***");
        finnKategori = "Charlie";
        int indexFunnenKategori = -1;
        int indexForstaNullVarde = kategorier.length;

        for (int i = 0; i < kategorier.length; i++) {
            if (kategorier[i] != null) {
                if (finnKategori.equalsIgnoreCase(kategorier[i].getNamn())) {
                    indexFunnenKategori = i;
                    break;
                }
            }
        }

        for (int i = 0; i < kategorier.length; i++) {
            if (kategorier[i] == null){
                indexForstaNullVarde = i;
                break;
            }
        }

        if (indexFunnenKategori != -1) {
            kategorier[indexFunnenKategori] = kategorier[indexForstaNullVarde -1];
            kategorier[indexForstaNullVarde -1] = null;
            System.out.println("Du har tagit bort " + finnKategori);
        } else {
            System.out.println("Du ville ta bort " + finnKategori + " men den fanns inre i arrayen.");
        }

        for (Kategori kat: kategorier) {
            if (kat != null) {
                System.out.println(kat.getNamn() + " " + kat.getAntal());
            }
        }

        // Sortera
        System.out.println("\n*** Sortera ***");
        Arrays.sort(kategorier, new KategoriSortera());
        for (Kategori kat:kategorier) {
            if (kat!=null) {
                System.out.println(kat.getNamn());
            }
        }
    }
}
