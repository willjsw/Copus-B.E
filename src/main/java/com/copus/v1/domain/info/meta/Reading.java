package com.copus.v1.domain.info.meta;

import com.copus.v1.domain.enums.ReadingType;
import lombok.Getter;

import javax.persistence.*;

/**
 *
 * 보류
 */
@Entity
@Getter
public class Reading {
    @Id
    @Column(name = "reading_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reading_info_id")
    private ReadingInfo readingInfo;

    @Enumerated(value = EnumType.STRING)
    private ReadingType type;
    private String readingText;
}
