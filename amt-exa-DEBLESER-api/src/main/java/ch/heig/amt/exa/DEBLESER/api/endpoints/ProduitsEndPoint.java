package ch.heig.amt.exa.DEBLESER.api.endpoints;

import ch.heig.amt.exa.DEBLESER.api.entities.ProduitEntity;
import org.openapitools.api.ProduitsApi;
import ch.heig.amt.exa.DEBLESER.api.exceptions.QuoteNotFoundException;
import org.openapitools.model.Produit;
import ch.heig.amt.exa.DEBLESER.api.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProduitsEndPoint implements ProduitsApi {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public ResponseEntity<List<Produit>> getProduits() {
        List<ProduitEntity> produitEntities = produitRepository.findAll();
        List<Produit> produits  = new ArrayList<>();
        // Convert each ProduitEntity to Produit
        for (ProduitEntity produitEntity : produitEntities) {
            Produit produit = new Produit();
            produit.setPrdNum(produitEntity.getPrd_num());
            produit.setDescription(produitEntity.getDescription());
            produit.setPoids(produitEntity.getPoids());
            produits.add(produit);
        }
        return new ResponseEntity<List<Produit>>(produits,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> addProduit(@RequestBody Produit produit) {
       ProduitEntity produitEntity = new ProduitEntity();
        produitEntity.setDescription(produit.getDescription());
        produitEntity.setPoids(produit.getPoids());
        produitEntity.setStatus_livraison(produit.getStatusLivraison());
        produitEntity.setVil_num(produit.getVilNum());
        ProduitEntity produitAdded = produitRepository.save(produitEntity);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produitAdded.getPrd_num())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Produit> getProduit(Integer id) {
        Optional<ProduitEntity> opt = produitRepository.findById(id);
        if (opt.isPresent()) {
            ProduitEntity produitEntity = opt.get();
            Produit produit = new Produit();
            produit.setPrdNum(produitEntity.getPrd_num());
            produit.setDescription(produitEntity.getDescription());
            produit.setPoids(produitEntity.getPoids());
            produit.setStatusLivraison(produitEntity.getStatus_livraison());
            produit.setVilNum(produitEntity.getVil_num());
            return new ResponseEntity<Produit>(produit, HttpStatus.OK);
        } else {
//            return ResponseEntity.notFound().build();
            throw new QuoteNotFoundException(id);
        }
    }

}
