package com.copus.v1.domain.info.meta;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 목차 정보
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChapterInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_info_id")
    private Long id;

    @Lob
    private String chapterInfoText;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

    public ChapterInfo(String chapterInfoText, MetaInfo metaInfo) {
        this.chapterInfoText = chapterInfoText;
        this.metaInfo = metaInfo;
    }
}

