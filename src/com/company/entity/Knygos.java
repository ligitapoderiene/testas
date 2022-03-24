package com.company.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "knygos")

public class Knygos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "metai")
    private int metai;
    @Column(name = "leidimas")
    private int leidimas;
    @Column(name = "pavadinimas")
    private String pavadinimas;
    @OneToMany(mappedBy = "knygos", cascade = CascadeType.ALL)
    private List<Autoriai> autoriai;

    // del to nes naudojame hibernate
    public Knygos() {

    }

    // Konstruktorius skirtas egzistuojanciu irasu duomenu bazeje, redagavimui, paieskai
    public Knygos(int id, int metai, int leidimas, String pavadinimas) {
        this.id = id;
        this.metai = metai;
        this.leidimas = leidimas;
        this.pavadinimas =pavadinimas;
    }

    // Konstruktorius skirtas naujo iraso kurimui (dar neissaugotoje duomenu bazeje).
    public Knygos(int metai, int leidimas, String pavadinimas) {
        this.metai = metai;
        this.leidimas = leidimas;
        this.pavadinimas =pavadinimas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMetai() {
        return metai;
    }

    public void setMetai(int metai) {
        this.metai = metai;
    }

    public int getLeidimas() {
        return leidimas;
    }

    public void setLeidimas(int leidimas) {
        this.leidimas = leidimas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public List<Autoriai> getAutoriai() {
        return autoriai;
    }

    public void setAutoriai(List<Autoriai> autoriai) {
        this.autoriai = autoriai;
    }

    @Override
    public String toString() {
        return "Knygos{" +
                "id=" + id +
                ", metai=" + metai +
                ", leidimas=" + leidimas +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", autoriai=" + autoriai +
                '}';
    }


}


