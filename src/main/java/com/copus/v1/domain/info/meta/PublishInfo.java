package com.copus.v1.domain.info.meta;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 간행 정보
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PublishInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publish_info_id")
    private Long id;

    //자료 형식
    private String dataFormat;

    //해제 작성일
    private LocalDate explanationDate;

    //언어
    private String language;

    //원문 간행년
    private String originalPublishYear;

    //간행 기간
    private String publishDurationEnd;
    private String publishDurationStart;

    //간행처
    private String publishOffice;

    //간행년
    private String publishYear;

    //집수
    private String zipsu;
    private String zipsuEnd;
    private String zipsuIndex;
    private String zipsuStart;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

    public PublishInfo(String dataFormat, LocalDate explanationDate, String language, String originalPublishYear, String publishDurationEnd, String publishDurationStart, String publishOffice, String publishYear, String zipsu, String zipsuEnd, String zipsuIndex, String zipsuStart, MetaInfo metaInfo) {
        this.dataFormat = dataFormat;
        this.explanationDate = explanationDate;
        this.language = language;
        this.originalPublishYear = originalPublishYear;
        this.publishDurationEnd = publishDurationEnd;
        this.publishDurationStart = publishDurationStart;
        this.publishOffice = publishOffice;
        this.publishYear = publishYear;
        this.zipsu = zipsu;
        this.zipsuEnd = zipsuEnd;
        this.zipsuIndex = zipsuIndex;
        this.zipsuStart = zipsuStart;
        this.metaInfo = metaInfo;
    }
}
