package com.company.entity;

import javax.persistence.*;

@Entity
@Table(name = "autoriai")

public class Autoriai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "knygosId")
    private int knygosId;
    @Column(name = "vardas")
    private String vardas;
    @Column(name = "pavarde")
    private String pavarde;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "knygosId")
    private Knygos knygos;

    // Del to nes naudojam hibernate
    public Autoriai() {

    }

    // Skirtas egzistuojanciu irasu duomenu bazeje - redagavimui ir paieskai.
    public Autoriai(int id, int knygosId, String vardas, String pavarde) {
        this.id = id;
        this.knygosId = knygosId;
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    // Skirtas naujo iraso kurimui (dar neissaugotoje duomenu bazeje).
    public Autoriai(int knygosId, String vardas, String pavarde) {
        this.knygosId = knygosId;
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKnygosId() {
        return knygosId;
    }

    public void setKnygosId(int knygosId) {
        this.knygosId = knygosId;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String  getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public Knygos getKnygos() {
        return knygos;
    }

    public void setKnygos(Knygos knygos) {
        this.knygos = knygos;
    }

    @Override
    public String toString() {
        return "Autoriai{" +
                "id=" + id +
                ", knygosId=" + knygosId +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", knygos=" + knygos +
                '}';
    }
}
