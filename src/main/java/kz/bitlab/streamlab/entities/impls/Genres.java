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
@Table(name = "t_genres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Genres extends BaseEntity {
    @Column(name = "genre_action", length = 20)
    private String genreName;
}
