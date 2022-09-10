package com.copus.v1.domain.info;

import com.copus.v1.domain.enums.CommentType;
import com.copus.v1.domain.info.body.BodyInfo;
import com.copus.v1.domain.info.meta.MetaInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Commentary {
    @Id
    @Column(name = "commentary_id")
    private String id;

    @Enumerated(EnumType.STRING)
    private CommentType commentType;

    @OneToOne
    @JoinColumn(name = "annotation_info_id")
    private AnnotationInfo annotationInfo;

    @OneToOne
    @JoinColumn(name = "body_info_id")
    private BodyInfo bodyInfo;

    @ManyToOne
    @JoinColumn(name = "commentary_info_id")
    private CommentaryInfo commentaryInfo;

    @OneToOne
    @JoinColumn(name = "connection_info_id")
    private ConnectionInfo connectionInfo;

    @OneToOne
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

    public Commentary(String id, CommentType commentType, AnnotationInfo annotationInfo, BodyInfo bodyInfo, CommentaryInfo commentaryInfo, ConnectionInfo connectionInfo, MetaInfo metaInfo) {
        this.id = id;
        this.commentType = commentType;
        this.annotationInfo = annotationInfo;
        this.bodyInfo = bodyInfo;
        this.commentaryInfo = commentaryInfo;
        this.connectionInfo = connectionInfo;
        this.metaInfo = metaInfo;
    }
}
