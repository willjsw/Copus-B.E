package com.copus.v1.service.serviceDto.articleDto.searchDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPreviewDto {
    private int count;
    private List<SearchPreviewDataDto> data;
}