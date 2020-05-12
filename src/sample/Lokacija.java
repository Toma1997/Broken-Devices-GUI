package sample;

import javafx.beans.property.SimpleStringProperty;

public class Lokacija {
    public SimpleStringProperty ID_lokacije = new SimpleStringProperty();
    public SimpleStringProperty Grad = new SimpleStringProperty();
    public SimpleStringProperty Adresa = new SimpleStringProperty();

    public Lokacija() {
    }

    public Lokacija(SimpleStringProperty iD_lokacije, SimpleStringProperty grad, SimpleStringProperty adresa) {
        ID_lokacije = iD_lokacije;
        Grad = grad;
        Adresa = adresa;
    }

    public String getID_lokacije() {
        return this.ID_lokacije.get();
    }

    public void setID_lokacije(String ID_lokacije) {
        this.ID_lokacije.set(ID_lokacije);
    }

    public String getGrad() {
        return Grad.get();
    }

    public void setGrad(String grad) {
        this.Grad.set(grad);
    }

    public String getAdresa() {
        return Adresa.get();
    }

    public void setAdresa(String adresa) {
        this.Adresa.set(adresa);
    }
}
