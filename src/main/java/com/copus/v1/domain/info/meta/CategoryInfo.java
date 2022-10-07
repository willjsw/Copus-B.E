package com.copus.v1.domain.info.meta;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 분류 정보
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_info_id")
    private Long id;

    @OneToMany(mappedBy = "categoryInfo")
    private List<Category> categories =new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

    @OneToMany(mappedBy = "categoryInfo")
    private List<Category> category = new ArrayList<>();

    public CategoryInfo(MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }
}
