package com.copus.v1.domain.info.meta;

import com.copus.v1.domain.enums.LeapFlat;
import lombok.Getter;

import javax.persistence.*;

/**
 * 시기 정보
 * 보류
 */
@Entity
@Getter
public class EraInfo {
    @Id
    @Column(name = "era_info_id")
    private Long id;

    //서기년
    private String year;
    private String zodiacYear;

    //연호
    private String alias;
    private String aliasYear;
    private String aliasYearCount;

    //월
    private String month;
    @Enumerated(EnumType.STRING)
    private LeapFlat leapFlat;

    //일
    private String day;
    private String zodiacDay;

    @OneToOne
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;
}
