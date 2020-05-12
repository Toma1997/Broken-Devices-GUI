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

public class TableController implements Initializable {


    @FXML
    private TableColumn<Racunar, String> col_idracunara;
    @FXML
    private TableColumn<Racunar, String> col_ime;
    @FXML
    private TableColumn<Racunar, String> col_ibroj;
    @FXML
    private TableColumn<Racunar, String> col_konf;
    @FXML
    private TableColumn<Racunar, String> col_mat;
    @FXML
    private TableColumn<Racunar, String> col_proc;
    @FXML
    private TableColumn<Racunar, String> col_ram;
    @FXML
    private TableColumn<Racunar, String> col_hdd;
    @FXML
    private TableColumn<Racunar, String> col_nap;
    @FXML
    private TableColumn<Racunar, String> col_graf;
    @FXML
    private TableColumn<Racunar, String> col_kom;
    @FXML
    private TableColumn<Racunar, String> col_lok;
    @FXML
    private  TableView<Racunar> TableView;


    @Override
    public void initialize(URL url, ResourceBundle rb) {


        try{

            String SQLquery = "SELECT * FROM racunari";
            DBConnect db = new DBConnect();

            ResultSet rezultat = db.Query(SQLquery);

            ObservableList<Racunar> data = FXCollections.observableArrayList();
            while(rezultat.next()){

                Racunar racunar = new Racunar();

                racunar.setIdRacunara(rezultat.getString("id_racunari"));
                racunar.setIme(rezultat.getString("ime"));
                racunar.setIBroj( rezultat.getString("inventarski_broj"));
                racunar.setKonfiguracija(  rezultat.getString("konfiguracija"));
                racunar.setMaticna( rezultat.getString("maticna"));
                racunar.setProcesor( rezultat.getString("procesor"));
                racunar.setRam(rezultat.getString("ram"));
                racunar.setHdd(rezultat.getString("hdd"));
                racunar.setNapajanje(rezultat.getString("napajanje"));
                racunar.setGraficka( rezultat.getString("graficka"));
                racunar.setKomentar(rezultat.getString("komentar"));
                racunar.setIdLokacije(rezultat.getString("id_lokacije"));

                data.add(racunar);
            }

            col_idracunara.setCellValueFactory(new PropertyValueFactory("ID racunara"));
            col_ime.setCellValueFactory(new PropertyValueFactory("Ime"));
            col_ibroj.setCellValueFactory(new PropertyValueFactory("Inventarski broj"));
            col_konf.setCellValueFactory(new PropertyValueFactory("Konfiguracija"));
            col_mat.setCellValueFactory(new PropertyValueFactory("Maticna"));
            col_proc.setCellValueFactory(new PropertyValueFactory("Procesor"));
            col_ram.setCellValueFactory(new PropertyValueFactory("RAM"));
            col_hdd.setCellValueFactory(new PropertyValueFactory("HDD"));
            col_nap.setCellValueFactory(new PropertyValueFactory("Napajanje"));
            col_graf.setCellValueFactory(new PropertyValueFactory("Graficka"));
            col_kom.setCellValueFactory(new PropertyValueFactory("Komentar"));
            col_lok.setCellValueFactory(new PropertyValueFactory("ID Lokacije"));

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
