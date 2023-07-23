package kz.bitlab.streamlab.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class MovieSnippetDTO {
    private String defaultAudioLanguage;
    private String defaultLanguage;
    private String description;
    private String title;
    private Date releaseDate;
    private LocalTime runTime;
    private double rating;
}
