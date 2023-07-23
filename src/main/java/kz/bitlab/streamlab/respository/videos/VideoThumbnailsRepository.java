package kz.bitlab.streamlab.respository.videos;

import kz.bitlab.streamlab.entities.impls.VideoThumbnails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface VideoThumbnailsRepository extends JpaRepository<VideoThumbnails, Long> {
}
