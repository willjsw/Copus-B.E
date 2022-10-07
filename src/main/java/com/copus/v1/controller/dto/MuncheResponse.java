package com.copus.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MuncheResponse {
    private String seojiId;
    private String seojiTitle;
    private String gwonchaId;
    private String gwonchaTitle;
    private String muncheTitle;
    private List<FinalPreview> datas = new ArrayList<>();
}