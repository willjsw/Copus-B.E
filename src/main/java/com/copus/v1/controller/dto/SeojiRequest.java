package com.copus.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeojiRequest {
    // value type ==저자명 or 가나다 中 1
    public String keyword;

    public SeojiOrdering ordering;
}

