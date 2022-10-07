package com.copus.v1.domain.info.body;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 본문 정보
 */
@Entity
@Getter
@NoArgsConstructor
public class BodyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "body_info_id")
    private Long id;
}
