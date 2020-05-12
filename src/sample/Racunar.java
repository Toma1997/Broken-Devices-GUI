package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;



public class Racunar{

    public SimpleStringProperty IdRacunara = new SimpleStringProperty();
    public SimpleStringProperty Ime = new SimpleStringProperty();
    public SimpleStringProperty InventarskiBroj = new SimpleStringProperty();
    public SimpleStringProperty Konfiguracija = new SimpleStringProperty();
    public SimpleStringProperty Maticna = new SimpleStringProperty();
    public SimpleStringProperty Procesor = new SimpleStringProperty();
    public SimpleStringProperty Ram = new SimpleStringProperty();
    public SimpleStringProperty Hdd = new SimpleStringProperty();
    public SimpleStringProperty Napajanje = new SimpleStringProperty();
    public SimpleStringProperty Graficka = new SimpleStringProperty();
    public SimpleStringProperty Komentar = new SimpleStringProperty();
    public SimpleStringProperty IdLokacije = new SimpleStringProperty();


    public Racunar() {
    }

    public Racunar(SimpleStringProperty idRacunara, SimpleStringProperty ime, SimpleStringProperty ibroj,
                   SimpleStringProperty konfiguracija, SimpleStringProperty maticna, SimpleStringProperty procesor,
                   SimpleStringProperty ram, SimpleStringProperty hdd, SimpleStringProperty napajanje,
                   SimpleStringProperty graficka, SimpleStringProperty komentar, SimpleStringProperty idLokacije) {

        IdRacunara = idRacunara;
        Ime = ime;
        InventarskiBroj = ibroj;
        Konfiguracija = konfiguracija;
        Maticna = maticna;
        Procesor = procesor;
        Ram = ram;
        Hdd = hdd;
        Napajanje = napajanje;
        Graficka = graficka;
        Komentar = komentar;
        IdLokacije = idLokacije;
    }


    public String getIdRacunara() {
        return this.IdRacunara.get();
    }
    public void setIdRacunara(String idRacunara) {
        this.IdRacunara.set(idRacunara);
    }

    public String getIme() {
        return this.Ime.get();
    }
    public void setIme(String ime) {
        this.Ime.set(ime);
    }

    public String getIBroj() {
        return this.InventarskiBroj.get();
    }
    public void setIBroj(String ibroj) {
        this.InventarskiBroj.set(ibroj);
    }

    public String getKonfiguracija() {
        return this.Konfiguracija.get();
    }
    public void setKonfiguracija(String konf) {
        this.Konfiguracija.set(konf);
    }

    public String getMaticna() {
        return this.Maticna.get();
    }
    public void setMaticna(String maticna) {
        this.Maticna.set(maticna);
    }

    public String getProcesor() {
        return this.Procesor.get();
    }
    public void setProcesor(String id) {
        this.Procesor.set(id);
    }


    public void setRam(String ram) {
        this.Ram.set(ram);
    }
    public String getRam() {
        return this.Ram.get();
    }

    public void setHdd(String hdd) {
        this.Hdd.set(hdd);
    }
    public String getHdd() {
        return this.Hdd.get();
    }


    public String getNapajanje() {
        return Napajanje.get();
    }
    public void setNapajanje(String napajanje) {
        this.Napajanje.set(napajanje);
    }

    public String getGraficka() {
        return Graficka.get();
    }
    public void setGraficka(String graficka) {
        this.Graficka.set(graficka);
    }

    public String getKomentar() {
        return Komentar.get();
    }
    public void setKomentar(String komentar) {
        this.Komentar.set(komentar);
    }

    public String getIdLokacije() {
        return IdLokacije.get();
    }
    public void setIdLokacije(String idLokacije) {
        this.IdLokacije.set(idLokacije);
    }
}