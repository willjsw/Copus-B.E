package com.copus.v1.service.serviceDto.articleDto.showDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MuncheInfoDto {
    private String seojiId;
    private String seojiTitle;
    private String gwonchaId;
    private String gwonchaTitle;
    private String muncheTitle;
    private List<FinalsDto> finals;


}