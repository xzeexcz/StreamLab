package kz.bitlab.streamlab.entities.impls;


import kz.bitlab.streamlab.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "t_video_snippet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VideoSnippet extends BaseEntity {

    @Column(name = "v_snippet_defaultAudioLang", length = 20)
    private String defaultAudioLanguage;
    @Column(name = "v_snippet_defaultLang", length = 20)
    private String defaultLanguage;
    @Column(name = "v_snippet_description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "v_snippet_title", length = 200)
    private String title;
    @Column(name = "v_snippet_release_date")
    private Date releaseDate;
    @Column(name = "v_snippet_runtime")
    private LocalTime runTime;
    @Column(name = "v_snippet_rating", length = 20, columnDefinition = "DOUBLE")
    private double rating;
}
