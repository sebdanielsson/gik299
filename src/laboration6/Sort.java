package laboration6;

import java.util.Comparator;

public class Sort implements Comparator<Student> {
    @Override
        public int compare(Student sid1, Student sid2){

        int sortTal = 0;

        if (sid1 != null && sid2 !=null){
            sortTal=sid1.getLastName().compareTo(sid2.getLastName());

        }
        return sortTal;
    }
}
