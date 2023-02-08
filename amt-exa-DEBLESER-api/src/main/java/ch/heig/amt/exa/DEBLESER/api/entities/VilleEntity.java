package ch.heig.amt.exa.DEBLESER.api.entities;

import jakarta.persistence.*;

@Entity(name = "Ville")
@Table(name = "Villes")
public class VilleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vil_num;

    @Column(unique = true, name = "nom")
    private String nom;


    public void setVil_num(int id) {
        this.vil_num = id;
    }

    public int getVil_num() {
        return vil_num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
