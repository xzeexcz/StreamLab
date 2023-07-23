package kz.bitlab.streamlab.entities.impls;

import kz.bitlab.streamlab.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_thumbnails")
@Getter
@Setter
public class Thumbnails extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "default_thumbnail_id")
    private Thumbnail defaultThumbnail;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "high_thumbnail_id")
    private Thumbnail highThumbnail;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maxres_thumbnail_id")
    private Thumbnail maxresThumbnail;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medium_thumbnail_id")
    private Thumbnail mediumThumbnail;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "standard_thumbnail_id")
    private Thumbnail standardThumbnail;
}
