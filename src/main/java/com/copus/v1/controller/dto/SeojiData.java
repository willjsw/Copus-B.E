package com.copus.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeojiData {
    private String seojiId;
    private String seojiTItle;
    private String authorName;
    private String zipsuStart;
    private String zipsuEnd;
    private String publishYear;
    private SeojiBuga buga;
}

