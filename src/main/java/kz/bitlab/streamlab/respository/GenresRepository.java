package kz.bitlab.streamlab.respository;

import kz.bitlab.streamlab.entities.impls.Genres;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface GenresRepository extends JpaRepository<Genres, Long> {
}
