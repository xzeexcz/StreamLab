package kz.bitlab.streamlab.entities.impls;

import kz.bitlab.streamlab.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "t_movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie extends BaseEntity {

    @Column(name = "movies_id")
    private String movieId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_snippet_id")
    private MovieSnippet movieSnippet;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_statistics_id")
    private MovieStatistics movieStatistics;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_thumbnails_id")
    private Thumbnails thumbnails;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Genres> genres;

}
