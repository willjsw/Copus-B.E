package com.copus.v1.domain.info.meta;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 왕대 정보
 * 보류
 */
@Entity
@Getter
public class KingInfo {
    @Id
    @Column(name = "king_info_id")
    private Long id;

    //왕대 명
    private String name;

    //재위 시작
    private LocalDate ascendDateAD;
    private String ascendDateAlias;

    //재위끝
    private LocalDate descendDateAD;
    private String descendDateAlias;

    @OneToOne
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

}
