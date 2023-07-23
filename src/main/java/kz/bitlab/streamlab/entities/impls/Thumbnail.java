package kz.bitlab.streamlab.entities.impls;

import kz.bitlab.streamlab.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "t_thumbnail")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Thumbnail extends BaseEntity {

    @Column(name = "thumbnail_height")
    private int height;

    @Column(name = "thumbnail_url")
    private String url;

    @Column(name = "thumbnail_width")
    private int width;
}
