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
@Table(name = "t_video_statistics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoStatistics extends BaseEntity {
    @Column(name = "v_statistics_likesCount")
    private Long likesCount;
    @Column(name = "v_statistics_viewsCount")
    private Long viewsCount;
}
