package com.copus.v1.controller.dto;

import com.copus.v1.service.serviceDto.articleDto.searchDto.SearchPreviewDataDto;
import com.copus.v1.service.serviceDto.articleDto.searchDto.SearchPreviewDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class PreviewResponse {
    private int count;
    private List<SeojiPreview> datas = new ArrayList<>();

    public PreviewResponse(SearchPreviewDto previewDto) {
        count = previewDto.getCount();
        for (SearchPreviewDataDto data : previewDto.getData()) {
            datas.add(new SeojiPreview(data));
        }
    }
}
