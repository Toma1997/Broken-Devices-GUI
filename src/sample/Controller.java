package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller{
    @FXML
    public TextField Ime;
    @FXML
    public TextField InventarskiBroj;
    @FXML
    public TextField Konfiguracija;
    @FXML
    public TextField Maticna;
    @FXML
    public TextField Procesor;
    @FXML
    public TextField Ram;
    @FXML
    public TextField Hdd;
    @FXML
    public TextField Napajanje;
    @FXML
    public TextField Graficka;
    @FXML
    public TextField Komentar;
    @FXML
    public TextField IDlokacije;

    @FXML
    public Label Validacija;




    public void IdiNaDodajUredjaj(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Layouts/DodajUredjaj.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void IdiNaAzurirajUredjaj(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Layouts/AzurirajUredjaj.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void IdiNaPrikazLokacija(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Layouts/PrikazLokacija.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void IdiNaPrikazRacunara(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Layouts/PrikazRacunara.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void IdiNaObrisiUredjaj(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Layouts/ObrisiUredjaj.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void IdiNaGlavniMeni(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Layouts/Main.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void DodajUredjaj(ActionEvent event) {

        //Validacija
        String validacijaTekst = "";

        if(Ime.getText() == null || Ime.getText().trim().isEmpty()) {
            validacijaTekst += "Zahteva se ime racunara!\n";
        }

        if(!isNumeric(InventarskiBroj.getText())) {
            validacijaTekst += "Inventarski broj mora biti broj\n";
        }

        // provera za konfiguraciju ne treba, jer moze biti null!

        if(Maticna.getText() == null || Maticna.getText().trim().isEmpty()) {
            validacijaTekst += "Zahteva se unos o tome da li ima Maticne ploce\n";
        }

        if(Procesor.getText() == null || Procesor.getText().trim().isEmpty()) {
            validacijaTekst += "Zahteva se unos o procesoru ako ga ima!\n";
        }

        if(Ram.getText() == null || Ram.getText().trim().isEmpty()) {
            validacijaTekst += "Zahteva se o kolicini RAM!\n";
        }

        if(Hdd.getText() == null || Hdd.getText().trim().isEmpty()) {
            validacijaTekst += "Zahteva se unos o kapacitetu Hard diska!\n";
        }

        if(Napajanje.getText() == null || Napajanje.getText().trim().isEmpty()) {
            validacijaTekst += "Zahteva se unos o tome da li ima Napajanje\n";
        }

        if(Graficka.getText() == null || Graficka.getText().trim().isEmpty()) {
            validacijaTekst += "Zahteva se unos o tome da li ima Graficke!\n";
        }

        // provera za komentar ne treba, jer moze biti null!

        if(IDlokacije.getText() == null || IDlokacije.getText().trim().isEmpty()) {
            validacijaTekst += "Zahteva se unos o broju lokacije 1-4!\n";
        }


        if(validacijaTekst.equals("")) {
            try {
                DBConnect db = new DBConnect();

                String upit = "INSERT INTO `racunari` (`ime`, `inventarski_broj`, `konfiguracija`," +
                        " `maticna`, `procesor`, `ram`, `hdd`, `napajanje`, `graficka`, `komentar`, `id_lokacije`) VALUES ('" +
                        Ime.getText() + "', '" + InventarskiBroj.getText() + "', '" + Konfiguracija.getText() + "', '" +
                        Maticna.getText() + "', '" + Procesor.getText() + "', '" + Ram.getText() + "', '" + Hdd.getText() + "', '" +
                        Napajanje.getText() + "', '" + Graficka.getText() + "', '" + Komentar.getText() + "', " + IDlokacije.getText() + ")";

                int rezultat = db.st.executeUpdate(upit);

                System.out.println("Uspesno dodato!");

                Ime.setText("");
                InventarskiBroj.setText("");
                Konfiguracija.setText("");
                Maticna.setText("");
                Procesor.setText("");
                Ram.setText("");
                Hdd.setText("");
                Napajanje.setText("");
                Graficka.setText("");
                Komentar.setText("");
                IDlokacije.setText("");

                Validacija.setText("Dodato!");

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else {
            Validacija.setText(validacijaTekst);
        }
    }

    // TREBA DORADITI METODU
    public void AzurirajUredjaj(ActionEvent event) {

        //Validacija
        String validacijaTekst = "";
        String zaAzuriranje = "";

        if(Ime.getText() == null || Ime.getText().trim().isEmpty()) {
            validacijaTekst += "Zahteva se ime racunara!\n";
        }

        if(!isNumeric(InventarskiBroj.getText())) {
            validacijaTekst += "Inventarski broj mora biti broj\n";
        }

        if(Konfiguracija.getText() != null && !Konfiguracija.getText().trim().isEmpty()) {
            zaAzuriranje += "`konfiguracija` = '" + Konfiguracija.getText() + "', ";
        }

        if(Maticna.getText() != null && !Maticna.getText().trim().isEmpty()) {
            zaAzuriranje += "`maticna` = '" + Maticna.getText() + "', ";
        }

        if(Procesor.getText() != null && !Procesor.getText().trim().isEmpty()) {
            zaAzuriranje += "`procesor` = '" + Procesor.getText() + "', ";
        }

        if(Ram.getText() != null && !Ram.getText().trim().isEmpty()) {
            zaAzuriranje += "`ram` = '" + Ram.getText() + "', ";
        }

        if(Hdd.getText() != null && !Hdd.getText().trim().isEmpty()) {
            zaAzuriranje += "`hdd` = '" + Hdd.getText() + "', ";
        }

        if(Napajanje.getText() != null && !Napajanje.getText().trim().isEmpty()) {
            zaAzuriranje += "`napajanje` = '" + Napajanje.getText() + "', ";
        }

        if(Graficka.getText() != null && !Graficka.getText().trim().isEmpty()) {
            zaAzuriranje += "`graficka` = '" + Graficka.getText() + "', ";
        }

        if(Komentar.getText() != null && !Komentar.getText().trim().isEmpty()) {
            zaAzuriranje += "`komentar` = '" + Komentar.getText() + "', ";
        }

        if(IDlokacije.getText() != null && !IDlokacije.getText().trim().isEmpty()) {
            zaAzuriranje += "`id_lokacije` = " + IDlokacije.getText() + ", ";
        }


        if(validacijaTekst.equals("")) {
            try {
                DBConnect db = new DBConnect();

                String upitTrazeniRacunar = "UPDATE `racunari` SET "+ zaAzuriranje.substring(0, zaAzuriranje.length()-2) +
                        " WHERE `ime` LIKE '" + Ime.getText() + "' AND `inventarski_broj` LIKE '" + InventarskiBroj.getText() + "';";

                int rezultat = db.st.executeUpdate(upitTrazeniRacunar);
                System.out.println("Uspesno azuriran!");

                Ime.setText("");
                InventarskiBroj.setText("");
                Konfiguracija.setText("");
                Maticna.setText("");
                Procesor.setText("");
                Ram.setText("");
                Hdd.setText("");
                Napajanje.setText("");
                Graficka.setText("");
                Komentar.setText("");
                IDlokacije.setText("");


                Validacija.setText("Azuriran!");

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else {
            Validacija.setText(validacijaTekst);
        }
    }

    public void ObrisiUredjaj(ActionEvent event) {

        //Validacija
        String validacijaTekst = "";

        if(Ime.getText() == null || Ime.getText().trim().isEmpty()) {
            validacijaTekst += "Zahteva se ime racunara!\n";
        }

        if(!isNumeric(InventarskiBroj.getText())) {
            validacijaTekst += "Inventarski broj mora biti broj\n";
        }

        if(validacijaTekst.equals("")) {
            try {
                DBConnect db = new DBConnect();

                String upitTrazeniRacunar = "DELETE FROM `racunari` WHERE `ime` LIKE '" +
                        Ime.getText() + "' AND `inventarski_broj` LIKE '" + InventarskiBroj.getText() + "';";

                int rezultat = db.st.executeUpdate(upitTrazeniRacunar);
                System.out.println("Uspesno obrisan!");

                Ime.setText("");
                InventarskiBroj.setText("");


                Validacija.setText("Obrisan!");

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else {
            Validacija.setText(validacijaTekst);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            int broj = Integer.parseInt(str);

        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
