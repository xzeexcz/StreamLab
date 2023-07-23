package kz.bitlab.streamlab.respository.videos;


import kz.bitlab.streamlab.entities.impls.Video;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface VideoRepository extends JpaRepository<Video, Long> {
    Video getVideoByUrl(String videoId);
}
