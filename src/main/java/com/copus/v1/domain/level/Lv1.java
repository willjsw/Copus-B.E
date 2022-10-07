package com.copus.v1.domain.level;

import com.copus.v1.domain.enums.Lv1Type;
import com.copus.v1.domain.info.CommentaryInfo;
import com.copus.v1.domain.info.meta.MetaInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lv1 {
    @Id @Column(name = "level_1_id")
    private String id;

    private LocalDate createDate;
    private String parentLv1;

    @Enumerated(value = EnumType.STRING)
    private Lv1Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    //메타 정보
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meta_info_id")
    private MetaInfo metaInfo;

    //해설 정보
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentary_info_id")
    private CommentaryInfo commentaryInfo;

    /**
     * level_1_id, create_date, parent_lv1, type, item_id, meta_info_id, commentary_info_id
     */
    public Lv1(String id, LocalDate createDate, String parentLv1, Lv1Type type, Item item, MetaInfo metaInfo, CommentaryInfo commentaryInfo) {
        this.id = id;
        this.createDate = createDate;
        this.parentLv1 = parentLv1;
        this.type = type;
        this.item = item;
        this.metaInfo = metaInfo;
        this.commentaryInfo = commentaryInfo;
    }
}
