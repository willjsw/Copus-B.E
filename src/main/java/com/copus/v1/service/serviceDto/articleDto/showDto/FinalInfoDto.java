package com.copus.v1.service.serviceDto.articleDto.showDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalInfoDto {
    private String seojiId;
    private String seojiTitle;
    private String gwonchaId;
    private String gwonchaTitle;
    private String muncheId;
    private String muncheTitle;
    private FinalDataDto finalData;
}