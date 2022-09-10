package com.copus.v1.domain.info;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 주석 정보
 */
@Entity
@Getter
@NoArgsConstructor
public class AnnotationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "annotation_info_id")
    private Long id;

    @OneToMany(mappedBy = "annotationInfo")
    private List<Annotation> annotations = new ArrayList<>();
}
