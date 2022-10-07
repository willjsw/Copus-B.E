package com.copus.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalResponse {
    private String seojiId;
    private String seojiTitle;
    private String gwonchaId;
    private String gwonchaTitle;
    private String muncheId;
    private String muncheTitle;
    private FinalData finalData;
}
