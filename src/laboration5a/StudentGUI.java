package laboration5a;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    String firstName, lastName;

    Student[] studentId = new Student[20];

    int index = 3;

    public StudentGUI() {

        studentId[0] = new Student("Sebastian", "Danielsson");
        studentId[1] = new Student("Ronja", "Steindahl");
        studentId[2] = new Student("Charles", "Ingvar");

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTa();
                firstName = tfFirstName.getText();
                lastName = tfLastName.getText();

                Student newStudent = new Student(firstName, lastName);

                if (studentId.length == index) {
                    taList.setText("Du kan inte lägga till " + newStudent.getFirstName() + " " + newStudent.getLastName() + " på grund av att arrayen är full.");
                } else {
                    studentId[index] = newStudent;
                    tfTerm.setText(newStudent.getTerm());
                    tfUsername.setText(newStudent.getUsername());
                    tfEmail.setText(newStudent.getEmail());
                    taList.setText("Du lade till:\n" + newStudent.getFirstName() + " " + newStudent.getLastName() + " (Index: " + index + ")\n");
                    index ++;
                }
            }
        });

        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTa();
                show();
            }
        });

        btnCleanTf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTf();
            }
        });
    }

    public void cleanTa() {
        taList.setText(null);
    }

    public void cleanTf() {
        tfFirstName.setText(null);
        tfLastName.setText(null);
        tfTerm.setText(null);
        tfUsername.setText(null);
        tfEmail.setText(null);
    }

    public void show() {
        for (Student student : studentId) {
            if (student != null) {
                // NÖDLÖSNING, TA EJ BORT DETTA > > >    taList.append(student.getFirstName() + "\t" + student.getLastName() + "\t" + student.getTerm() + "      " + student.getUsername() + "\t" + student.getEmail() + "\n");
                taList.append(student.getStudent() + "\n");
            }
        }
    }
}