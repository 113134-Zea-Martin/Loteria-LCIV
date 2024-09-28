package ar.edu.utn.frc.tup.lciii.repositories;

import ar.edu.utn.frc.tup.lciii.entities.ApuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApuestaRepository extends JpaRepository<ApuestaEntity, Integer> {
    List<ApuestaEntity> findByIdSorteo(int id_sorteo);
}
