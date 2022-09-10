package com.copus.v1.domain.info;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 해설 정보
 */
@Entity
@Getter
@NoArgsConstructor
public class CommentaryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentary_info_id")
    private Long id;

    @OneToMany(mappedBy = "commentaryInfo", cascade = CascadeType.ALL)
    private List<Commentary> commentaries = new ArrayList<>();
}
