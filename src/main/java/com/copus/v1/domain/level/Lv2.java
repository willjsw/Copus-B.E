package com.copus.v1.domain.level;

import com.copus.v1.domain.enums.Lv2Type;
import com.copus.v1.domain.info.AnnotationInfo;
import com.copus.v1.domain.info.ConnectionInfo;
import com.copus.v1.domain.info.body.BodyInfo;
import com.copus.v1.domain.info.meta.MetaInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lv2 {
    @Id @Column(name = "level_2_id")
    private String id;

    private String DCI;
    private LocalDate createDate;

    @Enumerated(value = EnumType.STRING)
    private Lv2Type type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "annotation_info_id")
    private AnnotationInfo annotationInfo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "body_info_id")
    private BodyInfo bodyInfo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "connection_info_id")
    private ConnectionInfo connectionInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_1_id")
    private Lv1 lv1;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

    /**
     * level_2_id dci create_date type annotation_info_id body_info_id connection_info_id level_1_id meta_info_id
     */
    public Lv2(String id, String DCI, LocalDate createDate, Lv2Type type, AnnotationInfo annotationInfo, BodyInfo bodyInfo, ConnectionInfo connectionInfo, Lv1 lv1, MetaInfo metaInfo) {
        this.id = id;
        this.DCI = DCI;
        this.createDate = createDate;
        this.type = type;
        this.annotationInfo = annotationInfo;
        this.bodyInfo = bodyInfo;
        this.connectionInfo = connectionInfo;
        this.lv1 = lv1;
        this.metaInfo = metaInfo;
    }
}
