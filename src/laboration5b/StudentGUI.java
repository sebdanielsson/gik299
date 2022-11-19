package laboration5b;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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

    String firstName, lastName;

    Student[] studentId = new Student[20];

    int index = 3;
    int sista = index-1;
    int countDown = sista;
    int countUp = 0;

    public StudentGUI() {


        studentId[0] = new Student("Sebastian", "Danielsson");
        studentId[1] = new Student("Ronja", "Steindahl");
        studentId[2] = new Student("Test", "Testsson");

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
                taList.append("\n");
                show();
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

        btnCleanTa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTa();
            }
        });

        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTf();
                cleanTa();
                taList.append("[" + countDown + "] " + studentId[countDown].getStudent() + "\n");

                if (countDown > -1) {
                    countDown--;
                }

                if (countDown < 0) {
                    countDown=sista;
                }
            }
        });

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTf();
                cleanTa();

                taList.append("[" + countUp + "] " + studentId[countUp].getStudent() + "\n");

                if (countUp < index) {
                    countUp++;
                }

                if (countUp > index - 1) {
                    countUp = 0;
                }
            }
        });

        btnSearchUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchUsername = tfUsername.getText();
                Student foundUser = null;
                show();
                cleanTf();
                cleanTa();
                tfUsername.setText(searchUsername);

                for (Student sid:studentId) {
                    if (sid != null) {
                        if (searchUsername.equalsIgnoreCase(sid.getUsername())) {
                            taList.append("Sökresultat: " + sid.getStudent() + "\n");
                        }
                    }
                }
            }
        });

        btnSearchLastName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int searchMatches = 0;
                String searchLastName = tfLastName.getText();
                Student foundUsername = null;
                show();
                cleanTf();
                cleanTa();
                tfLastName.setText(searchLastName);

                for (Student sid:studentId) {
                    if (sid != null) {
                        if (searchLastName.equalsIgnoreCase(sid.getLastName())) {
                            taList.append("Sökresultat: " + sid.getStudent() + "\n");
                            searchMatches++;
                        }
                    }
                }
                taList.append("Antal träffar: " + searchMatches);
             }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchUsername = tfUsername.getText();
                Student foundUsername = null;
                show();
                cleanTa();

                for (Student sid:studentId) {
                    if (sid != null) {
                        if (searchUsername.equalsIgnoreCase(sid.getUsername())) {
                            sid.setFirstName(tfFirstName.getText());
                            sid.setLastName(tfLastName.getText());
                            foundUsername = sid;
                        }
                    }
                }

                if (foundUsername != null) {
                    taList.append("Ersatte användare " + searchUsername + " med " + foundUsername.getUsername() + "\n\n");
                    show();
                } else {
                    taList.append("Kunde inte hitta " + searchUsername + ". Ingen ändring utförd.\n");
                }
            }
        });

        btnSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(studentId, new Sort());
                cleanTa();
                for (Student sid : studentId) {
                    if (sid != null) {

                         taList.append(sid.getStudent() + "\n");
                    }
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchUsername = tfUsername.getText();
                int indexFoundUsername = -1;
                int indexFirstNull = studentId.length;
                show();
                cleanTa();

                for (int i = 0; i < studentId.length; i++) {
                    if (studentId[i] != null) {
                        if (searchUsername.equalsIgnoreCase(studentId[i].getUsername())) {
                            indexFoundUsername = i;
                            break;
                        }
                    }
                }

                for (int i = 0; i < studentId.length; i++) {
                    if (studentId[i] == null){
                        indexFirstNull = i;
                        break;
                    }
                }

                if (indexFoundUsername  != -1) {
                    studentId[indexFoundUsername] = studentId[indexFirstNull -1];
                    studentId[indexFirstNull -1] = null;
                    taList.append(searchUsername + " är nu borttagen.\n\nUppdaterad lista:\n");

                    show();
                } else {
                    taList.setText("Kunde inte hitta " + searchUsername + ". Ingen ändring utförd.\n");
                }

                for (Student sid: studentId) {
                    if (sid != null) {
                        System.out.println(sid.getUsername());
                    }
                }
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
        for (Student student : studentId) {
            if (student != null) {
                taList.append(student.getStudent() + "\n");
            }
        }
    }
}