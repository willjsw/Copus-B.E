package com.copus.v1.service.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchByLv4ContentDto {

    private String lv1Id;
    private String lv1TitleKor;
    private String lv1TitleChn;
    private String lv2Id;
    private String lv2Title;
    private String lv3Id;
    private String lv3Title;
    private String lv4Id;
    private String lv4Title;
    private String authorKor;
    private String authorChn;
    private String originalPublishYear;
    private String content;
}
