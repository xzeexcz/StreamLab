package kz.bitlab.streamlab.entities.impls;

import kz.bitlab.streamlab.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_video_thumbnail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoThumbnail extends BaseEntity {
    @Column(name = "v_thumbnail_height")
    private int height;

    @Column(name = "v_thumbnail_url")
    private String url;

    @Column(name = "v_thumbnail_width")
    private int width;

}
