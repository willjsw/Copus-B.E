package com.copus.v1.domain.info.meta;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 메타 정보
 */
@Entity
@Getter
@NoArgsConstructor
public class MetaInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meta_info_id")
    private Long id;

    @OneToOne(mappedBy = "metaInfo")
    private AuthorInfo authorInfos;

    @OneToOne(mappedBy = "metaInfo")
    private CategoryInfo categoryInfo;

    @OneToOne(mappedBy = "metaInfo")
    private ChapterInfo chapterInfo;

    @OneToOne(mappedBy = "metaInfo")
    private EraInfo eraInfo;

    @OneToOne(mappedBy = "metaInfo")
    private KingInfo kingInfo;

    @OneToOne(mappedBy = "metaInfo")
    private PublishInfo publishInfo;

    @OneToOne(mappedBy = "metaInfo")
    private ReadingInfo readingInfo;

    @OneToOne(mappedBy = "metaInfo")
    private ReferInfo referInfo;

    @OneToOne(mappedBy = "metaInfo")
    private StoreInfo storeInfo;

    @OneToOne(mappedBy = "metaInfo")
    private TitleInfo titleInfo;

    @OneToOne(mappedBy = "metaInfo")
    private TranslatorInfo translatorInfo;

}
