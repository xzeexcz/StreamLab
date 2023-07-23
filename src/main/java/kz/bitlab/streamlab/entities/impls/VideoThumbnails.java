package kz.bitlab.streamlab.entities.impls;

import kz.bitlab.streamlab.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_video_thumbnails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoThumbnails extends BaseEntity {
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "v_default_thumbnail_id")
    private VideoThumbnail defaultThumbnail;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "v_high_thumbnail_id")
    private VideoThumbnail highThumbnail;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "v_maxres_thumbnail_id")
    private VideoThumbnail maxresThumbnail;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "v_medium_thumbnail_id")
    private VideoThumbnail mediumThumbnail;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "v_standard_thumbnail_id")
    private VideoThumbnail standardThumbnail;
}
