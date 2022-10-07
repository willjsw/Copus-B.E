package com.copus.v1.domain.info.meta;

import com.copus.v1.domain.enums.ReferToType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReferTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refer_to_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private ReferToType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refer_info_id")
    private ReferInfo referInfo;

    @OneToMany(mappedBy = "referTo")
    private List<ReferBody> referBodies = new ArrayList<>();

    public ReferTo(ReferToType type, ReferInfo referInfo) {
        this.type = type;
        this.referInfo = referInfo;
    }
}

