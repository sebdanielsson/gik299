package lektion5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonGUI {
    public JPanel mainPanel;
    private JLabel labelNamn;
    private JTextField tfNamn;
    private JLabel labelAlder;
    private JTextField tfAlder;
    private JTextArea taShow;
    private JButton btnSave;
    private JButton btnShow;

    Person[] personer = new Person[5];
    int index = 2;

    Person p1 = new Person("Sebastian", 27);
    Person p2 = new Person("Amanda", 26);

    public PersonGUI() {
        personer[0] = p1;
        personer[1] = p2;

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clean();
                String namn = tfNamn.getText();
                int alder = Integer.parseInt(tfAlder.getText());

                Person nyPerson = new Person(namn, alder);

                if (personer.length == index) {
                    taShow.setText("Du kan inte lägga till" + nyPerson.getNamn() + "på grund av att arrayen är full.");
                } else {
                    personer[index] = nyPerson;
                    taShow.setText("Du lade till:\n" + nyPerson.getNamn() + " (Index: " + index + ")");
                    index ++;
                }
            }
        });

        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clean();
                show();
            }
        });
    }

    public void clean() {
        taShow.setText(null);
    }

    public void show() {
        for (Person tempPers: personer) {
            if (tempPers != null) {
                taShow.append(tempPers.getPerson() + "\n");
            }
        }
    }
}
