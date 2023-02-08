package ch.heig.amt.exa.DEBLESER.api.repositories;

import ch.heig.amt.exa.DEBLESER.api.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProduitRepository extends JpaRepository<ProduitEntity, Integer> {
    ProduitEntity findById(int id);
}