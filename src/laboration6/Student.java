package laboration6;

import java.util.Calendar;

public class Student {
    // Instansvariabler
    private String firstName;
    private String lastName;
    private String term;
    private String username;
    private String email;

    // Konstruktor
    public Student (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Accessor
    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public String getTerm () {
        Calendar c = Calendar.getInstance();
        int week = c.get(Calendar.WEEK_OF_YEAR);
        if (week >= 1 && week <= 35) {
            term = "v" + Integer.toString(c.get(Calendar.YEAR)).substring(2,4);
        } else if (week < 1 || week > 35) {
            term = "h" + Integer.toString(c.get(Calendar.YEAR)).substring(2,4);
        }
        return term;
    }

    public String getUsername() {
        username = term + firstName.substring(0,3) + lastName.substring(0,3);
        username = username.toLowerCase();
        return username;
    }

    public String getEmail() {
        email = username + "@du.se";
        return email;
    }

    public String getStudent() {
        term = getTerm();
        username = getUsername();
        email = getEmail();
        return (firstName + " " + lastName + " " + term + " " + username + " " + email);
    }

    // Mutator
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
