package com.copus.v1.controller.dto;

import com.copus.v1.service.serviceDto.articleDto.searchDto.SearchPreviewDataDto;
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


    public SeojiPreview(SearchPreviewDataDto data) {
        this.seojiId = data.getSeojiId();
        this.seojiTitle = data.getSeojiTitle();
        this.authorName = data.getAuthorName();
        this.publishYear = data.getPublishYear();
        this.gwonchaId = data.getGwonchaId();
        this.gwonchaTitle = data.getGwonchaTitle();
        this.muncheId = data.getMuncheId();
        this.muncheTitle = data.getMuncheTitle();
        this.finalId = data.getFinalId();
        this.finalTitle = data.getFinalTitle();
        this.contentPartition = data.getContentPartition();
    }
}