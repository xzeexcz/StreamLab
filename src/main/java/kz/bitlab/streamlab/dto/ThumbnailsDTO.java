package kz.bitlab.streamlab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThumbnailsDTO {
    private ThumbnailDTO defaultThumbnail;
    private ThumbnailDTO highThumbnail;
    private ThumbnailDTO maxresThumbnail;
    private ThumbnailDTO mediumThumbnail;
    private ThumbnailDTO standardThumbnail;
}
