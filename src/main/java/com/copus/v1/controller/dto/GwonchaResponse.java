package com.copus.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GwonchaResponse {
    private String seojiId;
    private String seojiTitle;
    private List<GwonchaPreview> datas = new ArrayList<>();
}