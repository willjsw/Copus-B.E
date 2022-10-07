package com.copus.v1.domain.info.meta;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_house_id")
    private Long id;

    private String storeHouseText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_info_id")
    private StoreInfo storeInfo;

    public StoreHouse(String storeHouseText, StoreInfo storeInfo) {
        this.storeHouseText = storeHouseText;
        this.storeInfo = storeInfo;
    }
}
