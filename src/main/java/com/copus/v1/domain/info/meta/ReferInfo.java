package com.copus.v1.domain.info.meta;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 참조 정보
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReferInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refer_info_id")
    private Long id;

    @OneToMany(mappedBy = "referInfo")
    private List<ReferTo> referToes = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

    public ReferInfo(MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }
}
