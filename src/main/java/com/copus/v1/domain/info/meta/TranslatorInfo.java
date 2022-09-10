package com.copus.v1.domain.info.meta;

import lombok.Getter;

import javax.persistence.*;

/**
 * 역자 정보
 * 보류
 */
@Entity
@Getter
public class TranslatorInfo {
    @Id
    @Column(name = "translator_info_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;
}
