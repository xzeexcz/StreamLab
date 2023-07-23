package kz.bitlab.streamlab.dto.videos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoDTO {
    private String url;
    private VideoSnippetDTO videoSnippetDTO;
    private VideoStatisticsDTO videoStatisticsDTO;
    private VideoThumbnailsDTO videoThumbnailsDTO;
}
