package com.copus.v1.domain.info.meta;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
