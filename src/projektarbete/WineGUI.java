package projektarbete;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

public class WineGUI {
    public JPanel mainPanel;
    // Labels
    private JLabel lblProdID;
    private JLabel lblNamn;
    private JLabel lblVintage;
    private JLabel lblManufacturer;
    private JLabel lblQuantity;
    private JLabel lblCategory;
    private JLabel lblPrice;
    private JLabel lblTotalBottles;
    // Textfields
    private JTextField tfProdID;
    private JTextField tfName;
    private JTextField tfVintage;
    private JTextField tfManufacturer;
    private JTextField tfAntal;
    private JTextField tfCategory;
    private JTextField tfPrice;
    // Buttons
    private JButton btnCreate;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnSearchCategory;
    private JButton btnSortManufacturer;
    private JButton btnShowWines;
    private JButton btnFilterPrice;
    // Textarea
    private JTextArea taCart;

    // Variabler
    String namn, vintage, vintyp, tillverkare, prodID;
    int pris, lagersaldo, totalBottles;

    // Skapa ArrayList för våra Wine-objekt och en ListIterator
    ArrayList<Wine> vinlist = new ArrayList<>();
    ListIterator<Wine> listItr = vinlist.listIterator();

    // Skapa 3 fördefinierade artiklar och lägg in i vår ArrayList
    public WineGUI() {
        Wine w1 = new Wine("Avalon", "Purple Wine Company", "2018", "Röd Vin", 199, 4,"PWC456");
        Wine w2 = new Wine("Lynx", "House of Big Wines", "2020", "Vit Vin", 99, 4,"HBW601");
        Wine w3 = new Wine("Paperstar Blonde", "Kunin Wines", "2016", "Vit Vin", 279, 4, "KW596");

        vinlist.add(w1);
        vinlist.add(w2);
        vinlist.add(w3);

        // Visa nuvarande produktlista vid programmets uppstart
        show();

        // Visa alla produkter
        btnShowWines.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTa();
                show();
            }
        });

        // Lägga till produkt i Arraylist
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTa();
                namn = tfName.getText();
                prodID = tfProdID.getText();
                tillverkare=tfManufacturer.getText();
                vintage = tfVintage.getText();
                lagersaldo = Integer.parseInt(tfAntal.getText());
                vintyp=tfCategory.getText();
                pris=Integer.parseInt(tfPrice.getText());

                String searchProdID = tfProdID.getText();
                boolean foundProdID = false;

                listItr = vinlist.listIterator();
                 // Loopa igenom koden för att se om produkt-id redan finns, isf läggs det inte till
                while (listItr.hasNext()) {
                    Wine nextWine = listItr.next();
                    String foundWine = nextWine.getProdID();
                    if (searchProdID.equalsIgnoreCase(foundWine)) {
                        taCart.append("Produkt-id " + prodID + " finns redan i er samling.\n\n");
                        foundProdID = true;

                    }
                }
                // Finns inte produkt-id läggs produkten till
                if (!foundProdID) {
                    Wine newWine= new Wine(namn, tillverkare, vintage, vintyp, pris, lagersaldo, prodID);
                    taCart.append("Du lade till " + prodID + " i din samling.\n\n");
                    vinlist.add(newWine);
                    show();
                }
            }
        });

        // Ta bort produkt ur ArrayList
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchProdID = tfProdID.getText();
                boolean foundProdID = false;

                cleanTf();
                cleanTa();
                listItr = vinlist.listIterator();
                // Loopar igenom ArrayList och matchar produkt-id mellan sökfält och produkt i ArrayList. Hittas det tas produkten bort.
                while (listItr.hasNext()) {
                    Wine nextWine = listItr.next();
                    String foundWine = nextWine.getProdID();
                    if (searchProdID.equalsIgnoreCase(foundWine)) {
                        listItr.remove();
                        taCart.append("Produkt-id " + searchProdID + " har tagits bort.\n\n");
                        show();
                        foundProdID = true;
                    }
                }

                // Hittas inte ett matchande produkt-id skrivs följande ut
                if (!foundProdID) {
                    taCart.append("Du försökte ta bort produkten med ID " + searchProdID + " men den fanns inte.");
                }
            }
        });

        // Filtrera produkter baserat på kategori/produkttyp
        btnSearchCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTa();
                String searchCategory = tfCategory.getText();
                boolean foundCategory = false;

                listItr = vinlist.listIterator();

                cleanTf();
                // Loopa igenom koden för att se om produkttyp matchar det som söktes på i sökfältet, matchar det produkten i ArrayList så skrivs den ut.
                while (listItr.hasNext()) {
                    Wine nextWine = listItr.next();
                    String foundWine = nextWine.getVintyp();
                    if (searchCategory.equalsIgnoreCase(foundWine)) {
                        taCart.append(nextWine.getWine() + "\n------------------------------------------------\n");
                        foundCategory = true;

                    }
                }
                // Görs ingen matchning skrivs följande ut
                if (!foundCategory) {
                    taCart.append("Hittade inga produkter av produkttypen " + searchCategory + " i din samling.\n\n");
                }
            }
        });

        // Filtrera produkter efter maxpris
        btnFilterPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTa();
                int filterPrice = Integer.parseInt(tfPrice.getText());
                boolean foundPrice = false;

                listItr = vinlist.listIterator();

                cleanTf();
                // Loopa igenom koden för att se om priset understiger eller är lika som användarens satta maxpris.
                while (listItr.hasNext()) {
                    Wine nextWine = listItr.next();
                    String foundWine = String.valueOf(nextWine.getPris());
                    if (nextWine.getPris() <= filterPrice) {
                        taCart.append(nextWine.getWine() + "\n------------------------------------------------\n");
                        foundPrice = true;

                    }
                }
                // Finns inte priser under det satta priset skrivs följande ut.
                if (!foundPrice) {
                    taCart.append("Hittade inga produkter under " + filterPrice + " kr.\n");
                }
            }
        });

        // Uppdatera pris och antal för angivet produkt-id
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTa();
                String searchProdID = tfProdID.getText();
                boolean foundProdID = false;

                listItr = vinlist.listIterator();

                // Loopa igenom koden för att se om produkt-id finns, finns det uppdateras pris och/eller antal i lager
                while (listItr.hasNext()) {
                    Wine nextWine = listItr.next();
                    String foundWine = nextWine.getProdID();
                    if (searchProdID.equalsIgnoreCase(foundWine)) {
                        if(tfAntal.getText() == null){
                            nextWine.setPris(Integer.parseInt(tfPrice.getText()));
                        }

                        if(tfPrice.getText() == null){
                            nextWine.setLagersaldo(Integer.parseInt(tfAntal.getText()));
                        }
                        else{
                            nextWine.setPris(Integer.parseInt(tfPrice.getText()));
                            nextWine.setLagersaldo(Integer.parseInt(tfAntal.getText()));
                            foundProdID = true;
                            show();
                        }

                    }
                }
                // Finns inte produkt-id så skrivs följande ut
                if (!foundProdID) {
                    taCart.append("Hittade ingen produkt med produkt-ID " + searchProdID + " i din samling.\n\n");
                }
            }
        });

        // Sortera ArrayList efter producent/tillverkare
        btnSortManufacturer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTa();
                vinlist.sort(new Sort());
                taCart.append("Viner sorterade efter producent:\n");
                show();
            }
        });
    }

    // Hjälpmetod clear
    private void cleanTa(){
        taCart.setText(null);
    }

    private void cleanTf(){
        tfAntal.setText(null);
        tfCategory.setText(null);
        tfManufacturer.setText(null);
        tfName.setText(null);
        tfVintage.setText(null);
        tfProdID.setText(null);
        tfPrice.setText(null);
    }

    // Hjälpmetod visa
    private void show(){
        totalBottles = 0;
        listItr = vinlist.listIterator();
        while (listItr.hasNext()){
            Wine nextWine=listItr.next();
            totalBottles = totalBottles + nextWine.getLagersaldo();
            taCart.append(nextWine.getWine()+ "\n------------------------------------------------\n");
        }
        lblTotalBottles.setText("Totala antal vin flaskor: " + Integer.toString(totalBottles));
    }
}//end wineGUI
