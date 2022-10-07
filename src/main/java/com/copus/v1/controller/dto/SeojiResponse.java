package com.copus.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeojiResponse {
    private int count;
    private List<SeojiData> datas = new ArrayList<>();
}

