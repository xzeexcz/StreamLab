package kz.bitlab.streamlab.dto.videos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoThumbnailsDTO {
    private VideoThumbnailDTO defaultThumbnail;
    private VideoThumbnailDTO highThumbnail;
    private VideoThumbnailDTO maxresThumbnail;
    private VideoThumbnailDTO mediumThumbnail;
    private VideoThumbnailDTO standardThumbnail;
}
