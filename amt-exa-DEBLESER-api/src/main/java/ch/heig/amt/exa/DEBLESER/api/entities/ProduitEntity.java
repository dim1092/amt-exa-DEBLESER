package ch.heig.amt.exa.DEBLESER.api.entities;

import jakarta.persistence.*;

@Entity(name = "Produit")
@Table(name = "Produits")
public class ProduitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prd_num;

    @Column(name = "description")
    private String description;

    @Column(name = "poids")
    private int poids;

    @Column(name = "status_livraison")
    private String status_livraison;

    @Column(name = "vil_num")
    private int vil_num;



    public void setPrd_num(int id) {
        this.prd_num = id;
    }

    @Id
    public int getPrd_num() {
        return prd_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getStatus_livraison() {
        return status_livraison;
    }

    public void setStatus_livraison(String status_livraison) {
        this.status_livraison = status_livraison;
    }

    public int getVil_num() {
        return vil_num;
    }

    public void setVil_num(int vil_num) {
        this.vil_num = vil_num;
    }
}
