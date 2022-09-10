package com.copus.v1.domain.info.meta;

import com.copus.v1.domain.enums.BodyType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReferBody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refer_body_id")
    private Long id;

    private String referBodyText;

    @Enumerated(value = EnumType.STRING)
    private BodyType type;

    @ManyToOne
    @JoinColumn(name = "refer_to_id")
    private ReferTo referTo;

    public ReferBody(String referBodyText, BodyType type, ReferTo referTo) {
        this.referBodyText = referBodyText;
        this.type = type;
        this.referTo = referTo;
    }
}
