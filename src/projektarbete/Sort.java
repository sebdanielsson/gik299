package projektarbete;

import java.util.Comparator;
//kod för sort
public class Sort implements Comparator<Wine>{
    @Override
    //jämnför wine med varandra, Den med lägst värde sätts först
        public int compare(Wine vin1, Wine vin2){
        int sortTal = 0;

        if(vin1 != null && vin2 !=null){
            sortTal=vin1.getTillverkare().compareTo(vin2.getTillverkare());
        }
        return sortTal;
    }
}
