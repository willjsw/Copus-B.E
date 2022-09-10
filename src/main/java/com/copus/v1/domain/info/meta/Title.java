package com.copus.v1.domain.info.meta;

import com.copus.v1.domain.enums.TitleType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "title_id")
    private Long id;

    //datenum,,,? 일단 String
    private String dateNum;
    private String titleText;

    @Enumerated(value = EnumType.STRING)
    private TitleType type;

    //날씨,,,? 일단 String
    private String weather;

    @ManyToOne
    @JoinColumn(name = "title_info_id")
    private TitleInfo titleInfo;

    public Title(String dateNum, String titleText, TitleType type, String weather, TitleInfo titleInfo) {
        this.dateNum = dateNum;
        this.titleText = titleText;
        this.type = type;
        this.weather = weather;
        this.titleInfo = titleInfo;
    }

}
