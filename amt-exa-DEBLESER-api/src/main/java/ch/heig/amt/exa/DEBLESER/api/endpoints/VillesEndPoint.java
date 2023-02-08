package ch.heig.amt.exa.DEBLESER.api.endpoints;

import ch.heig.amt.exa.DEBLESER.api.entities.ProduitEntity;
import ch.heig.amt.exa.DEBLESER.api.entities.VilleEntity;
import ch.heig.amt.exa.DEBLESER.api.exceptions.QuoteNotFoundException;
import ch.heig.amt.exa.DEBLESER.api.repositories.VilleRepository;
import org.openapitools.api.VillesApi;
import org.openapitools.model.Produit;
import ch.heig.amt.exa.DEBLESER.api.repositories.ProduitRepository;
import org.openapitools.model.Ville;
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
public class VillesEndPoint implements VillesApi {

    @Autowired
    private VilleRepository villeRepository;

    @Override
    public ResponseEntity<List<Ville>> getVilles() {
        List<VilleEntity> villeEntities = villeRepository.findAll();
        List<Ville> villes  = new ArrayList<>();
        // Convert each VilleEntity to Ville
        for (VilleEntity villeEntity : villeEntities) {
            Ville ville = new Ville();
            ville.setVilNum(villeEntity.getVil_num());
            ville.setNom(villeEntity.getNom());
            villes.add(ville);
        }
        return new ResponseEntity<List<Ville>>(villes,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> addVille(@RequestBody Ville ville) {
        VilleEntity villeEntity = new VilleEntity();
        villeEntity.setNom(ville.getNom());
        villeEntity.setVil_num(ville.getVilNum());

        VilleEntity produitAdded = villeRepository.save(villeEntity);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produitAdded.getVil_num())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Ville> getVille(Integer id) {
        Optional<VilleEntity> opt = villeRepository.findById(id);
        if (opt.isPresent()) {
            VilleEntity villeEntity = opt.get();
            Ville ville = new Ville();
            ville.setNom(villeEntity.getNom());
            ville.setVilNum(villeEntity.getVil_num());
            return new ResponseEntity<Ville>(ville, HttpStatus.OK);
        } else {
//            return ResponseEntity.notFound().build();
            throw new QuoteNotFoundException(id);
        }
    }

}
