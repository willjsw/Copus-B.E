package com.copus.v1.domain.level;

import com.copus.v1.domain.enums.Lv3Type;
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
public class Lv3 {
    @Id @Column(name = "level_3_id")
    private String id;

    private String DCI;
    private LocalDate createDate;

    @Enumerated(value = EnumType.STRING)
    private Lv3Type type;

    @OneToOne
    @JoinColumn(name = "annotation_info_id")
    private AnnotationInfo annotationInfo;

    @OneToOne
    @JoinColumn(name = "body_info_id")
    private BodyInfo bodyInfo;

    @OneToOne
    @JoinColumn(name = "connection_info_id")

    private ConnectionInfo connectionInfo;
    @ManyToOne
    @JoinColumn(name = "level_2_id")
    private Lv2 lv2;

    @OneToOne
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

    /**
     * level_3_id dci create_date type annotation_info_id body_info_id connection_info_id level_2_id meta_info_id
     */
    public Lv3(String id, String DCI, LocalDate createDate, Lv3Type type, AnnotationInfo annotationInfo, BodyInfo bodyInfo, ConnectionInfo connectionInfo, Lv2 lv2, MetaInfo metaInfo) {
        this.id = id;
        this.DCI = DCI;
        this.createDate = createDate;
        this.type = type;
        this.annotationInfo = annotationInfo;
        this.bodyInfo = bodyInfo;
        this.connectionInfo = connectionInfo;
        this.lv2 = lv2;
        this.metaInfo = metaInfo;
    }
}