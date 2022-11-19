package lektion6;

import java.util.Comparator;

public class KategoriSortera implements Comparator <Kategori> {
    @Override
    public int compare(Kategori kat1, Kategori kat2) {
        int sortTal = 0;
        if (kat1 != null && kat2 != null) {
            sortTal = kat1.getNamn().compareTo(kat2.getNamn());
        }
        return sortTal;
    }
}
