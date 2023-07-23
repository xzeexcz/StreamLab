package kz.bitlab.streamlab.respository.videos;

import kz.bitlab.streamlab.entities.impls.VideoThumbnail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface VideoThumbnailRepository extends JpaRepository<VideoThumbnail, Long> {
}
