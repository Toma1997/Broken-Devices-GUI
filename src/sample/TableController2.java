package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class TableController2 implements Initializable {


    @FXML
    private TableColumn<Lokacija, String> col_idlokacije;
    @FXML
    private TableColumn<Lokacija, String> col_grad;
    @FXML
    private TableColumn<Lokacija, String> col_adresa;
    @FXML
    private  TableView<Lokacija> TableView;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try{

            String SQLquery = "SELECT * FROM lokacije";
            DBConnect db = new DBConnect();

            ResultSet rezultat = db.Query(SQLquery);

            ObservableList<Lokacija> data = FXCollections.observableArrayList();
            while(rezultat.next()){
                Lokacija lokacija = new Lokacija();

                lokacija.setID_lokacije(rezultat.getString("id_lokacije"));
                lokacija.setGrad(rezultat.getString("grad"));
                lokacija.setAdresa( rezultat.getString("adresa"));

                data.add(lokacija);
            }

            col_idlokacije.setCellValueFactory(new PropertyValueFactory("ID lokacije"));
            col_grad.setCellValueFactory(new PropertyValueFactory("Grad"));
            col_adresa.setCellValueFactory(new PropertyValueFactory("Adresa"));

            TableView.setItems(data);

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Greska!");
        }
    }
    public void IdiNaGlavniMeni(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Layouts/Main.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
}

