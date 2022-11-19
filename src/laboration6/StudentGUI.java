package laboration6;

import javax.swing.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;

public class StudentGUI {
    public JPanel mainPanel;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfTerm;
    private JTextField tfUsername;
    private JTextField tfEmail;
    private JTextArea taList;
    private JButton btnShow;
    private JButton btnSave;
    private JButton btnCleanTf;
    private JButton btnPrevious;
    private JButton btnNext;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnSearchUsername;
    private JButton btnSearchLastName;
    private JButton btnSort;
    private JButton btnCleanTa;
    private JLabel lblAntalEfternamn;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblTerm;
    private JLabel lblusername;
    private JLabel lblEmail;

    String firstName, lastName;
    int index = -1, lastIndex, totalLastName;

    ArrayList<Student> list = new ArrayList<>();
    ListIterator<Student> listItr = list.listIterator();

    public StudentGUI() {
        Student n1 = new Student("Sebastian", "Danielsson");
        Student n2 = new Student("Ronja", "Steindahl");
        Student n3 = new Student("Test", "Danielsson");

        list.add(n1);
        list.add(n2);
        list.add(n3);

        show();

        btnSave.addActionListener(e -> {
            cleanTa();
            firstName = tfFirstName.getText();
            lastName = tfLastName.getText();

            Student newStudent = new Student(firstName, lastName);
            list.add(newStudent);

            tfTerm.setText(newStudent.getTerm());
            tfUsername.setText(newStudent.getUsername());
            tfEmail.setText(newStudent.getEmail());
            taList.setText("Du lade till:\n" + newStudent.getFirstName() + " " + newStudent.getLastName() + "\n\n");
            show();
        });

        btnShow.addActionListener(e -> {
            cleanTa();
            show();
        });

        btnCleanTf.addActionListener(e -> cleanTf());

        btnCleanTa.addActionListener(e -> cleanTa());

        btnSearchUsername.addActionListener(e -> {
            String searchUsername = tfUsername.getText();
            boolean foundUser = false;
            cleanTa();
            cleanTf();
            tfUsername.setText(searchUsername);

            listItr = list.listIterator();
            while (listItr.hasNext()) {
                Student nextStudent=listItr.next();
                String foundStudent = nextStudent.getUsername();
                if (searchUsername.equalsIgnoreCase(foundStudent)) {
                    taList.append("[" + listItr.previousIndex() + "] " + nextStudent.getStudent() + "\n");
                    foundUser = true;
                }
            }
            if (!foundUser) {
                taList.append("Kunde ej hitta " + searchUsername + ".");
            }
        });

        btnSearchLastName.addActionListener(e -> {
            totalLastName = 0;
            String searchLastName = tfLastName.getText();
            boolean foundLastName = false;
            cleanTa();
            cleanTf();
            tfLastName.setText(searchLastName);

            listItr = list.listIterator();
            while (listItr.hasNext()) {
                Student nextStudent=listItr.next();
                String foundStudent = nextStudent.getLastName();
                if (searchLastName.equalsIgnoreCase(foundStudent)) {
                    taList.append("[" + listItr.previousIndex() + "] " + nextStudent.getStudent() + "\n");
                    foundLastName = true;
                    totalLastName++;
                }
            }
            if (!foundLastName) {
                taList.setText("Kunde ej hitta användare med efternamnet " + searchLastName + ".");
            }
            lblAntalEfternamn.setText("Antal personer med efternamnet " + searchLastName + ": " + Integer.toString(totalLastName));
        });

        btnSort.addActionListener(e -> {
            cleanTa();
            list.sort(new Sort());
            taList.append("Studenter sorterat på efternamn:\n");
            show();
        });

        btnPrevious.addActionListener(e -> {
            lastIndex = list.toArray().length;
            cleanTf();
            cleanTa();

            if (index > 0) {
                index--;
                taList.setText("[" + index + "] " + list.get(index).getStudent() + "\n");
            } else if (index <= 0) {
                index = lastIndex;
                index--;
                taList.setText("[" + index + "] " + list.get(index).getStudent() + "\n");
            }
        });

        btnNext.addActionListener(e -> {
            lastIndex = list.toArray().length;
            cleanTf();
            cleanTa();

            if (index < lastIndex-1) {
                index++;
                taList.setText("[" + index + "] " + list.get(index).getStudent() + "\n");
            } else if (index >= lastIndex-1) {
                index = -1;
                index++;
                taList.setText("[" + index + "] " + list.get(index).getStudent() + "\n");
            }
        });

        btnUpdate.addActionListener(e -> {
            String searchUsername = tfUsername.getText();
            boolean foundUser = false;
            cleanTa();
            tfUsername.setText(searchUsername);

            listItr = list.listIterator();
            while (listItr.hasNext()) {
                Student nextStudent=listItr.next();
                if (Objects.equals(nextStudent.getUsername(), searchUsername)) {
                    nextStudent.setFirstName(tfFirstName.getText());
                    nextStudent.setLastName(tfLastName.getText());
                    taList.append("Ersatte användare " + searchUsername + " med " + nextStudent.getUsername() + ".\n\n");
                    show();
                    foundUser = true;
                }
            }
            if (!foundUser) {
                taList.append("Kunde ej hitta " + searchUsername + ".");
            }
        });

        btnDelete.addActionListener(e -> {
            String searchUsername = tfUsername.getText();
            boolean foundUser = false;
            cleanTa();
            tfUsername.setText(searchUsername);

            listItr = list.listIterator();
            while (listItr.hasNext()) {
                Student nextStudent=listItr.next();
                if (Objects.equals(nextStudent.getUsername(), searchUsername)) {
                    listItr.remove();
                    taList.append("Raderade " + searchUsername + ".\n\n");
                    show();
                    foundUser = true;
                }
            }
            if (!foundUser) {
                taList.append("Kunde ej hitta " + searchUsername + ".");
            }
        });
    }

    private void cleanTa() {
        taList.setText(null);
    }

    private void cleanTf() {
        tfFirstName.setText(null);
        tfLastName.setText(null);
        tfTerm.setText(null);
        tfUsername.setText(null);
        tfEmail.setText(null);
    }

    private void show() {
        listItr = list.listIterator();
        while (listItr.hasNext()) {
            Student nextStudent=listItr.next();
            taList.append("[" + listItr.previousIndex() + "] " + nextStudent.getStudent() + "\n");
        }
    }
}