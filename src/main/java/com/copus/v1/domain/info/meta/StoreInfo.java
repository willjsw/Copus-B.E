package com.copus.v1.domain.info.meta;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 소장 정보
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_info_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

    @OneToMany(mappedBy = "storeInfo")
    private List<StoreHouse> storeHouse = new ArrayList<>();

    public StoreInfo(MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }
}
