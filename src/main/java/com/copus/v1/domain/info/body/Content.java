package com.copus.v1.domain.info.body;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long id;

    @Lob
    private String contentText;

    @OneToOne
    @JoinColumn(name = "body_info_id")
    private BodyInfo bodyInfo;

    public Content(String contentText, BodyInfo bodyInfo) {
        this.contentText = contentText;
        this.bodyInfo = bodyInfo;
    }
}
