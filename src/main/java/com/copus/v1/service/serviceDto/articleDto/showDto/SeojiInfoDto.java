package com.copus.v1.service.serviceDto.articleDto.showDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeojiInfoDto {
    private int count;
    private List<SeojiInfoDataDto> data;
}