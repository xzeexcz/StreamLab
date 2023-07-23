package kz.bitlab.streamlab.respository;

import kz.bitlab.streamlab.entities.impls.MovieStatistics;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MovieStatisticsRepository extends JpaRepository<MovieStatistics, Long> {
}
