package kz.bitlab.streamlab.entities.impls;


import kz.bitlab.streamlab.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_videos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Video extends BaseEntity {
    @Column(name = "video_id")
    private String url;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "t_video_snippet_id")
    private VideoSnippet videoSnippet;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "t_video_statistics_id")
    private VideoStatistics videoStatistics;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "t_video_thumbnails_id")
    private VideoThumbnails videoThumbnails;
}
