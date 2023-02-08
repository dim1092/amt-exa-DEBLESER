package ch.heig.amt.exa.DEBLESER.api.repositories;
import ch.heig.amt.exa.DEBLESER.api.entities.VilleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VilleRepository extends JpaRepository<VilleEntity, Integer> {
    VilleEntity findById(int id);
}