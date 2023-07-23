package kz.bitlab.streamlab.respository;

import kz.bitlab.streamlab.entities.impls.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie findByMovieId(String movieId);

}
