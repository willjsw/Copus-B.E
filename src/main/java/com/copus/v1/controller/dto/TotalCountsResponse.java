package com.copus.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalCountsResponse {
    private Long totalCount;
    private Long bookTitleCount;
    private Long authorNameCount;
    private Long contentCount;
}