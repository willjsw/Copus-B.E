package com.copus.v1.service.serviceDto.articleDto.showDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeojiInfoDataDto {
    private String seojiId;
    private String seojiTitle;
    private String authorName;
    private String zipsu;
    private String publishYear;
    private SeojiInfoBugaDataDto buga;
}