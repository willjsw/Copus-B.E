package com.copus.v1.domain.info.meta;

import com.copus.v1.domain.enums.AuthorType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 저자 정보
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_info_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private AuthorType type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

    @OneToOne(mappedBy = "authorInfo")
    private Author author;

    public AuthorInfo(AuthorType type, MetaInfo metaInfo) {
        this.type = type;
        this.metaInfo = metaInfo;
    }

}
