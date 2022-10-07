package com.copus.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeojiPreview {
    private String seojiId;
    private String seojiTitle;
    private String authorName;
    private String publishYear;
    private String gwonchaId;
    private String gwonchaTitle;
    private String muncheId;
    private String muncheTitle;
    private String finalId;
    private String finalTitle;
    private String contentPartition;
}