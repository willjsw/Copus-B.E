package com.copus.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GwonchaPreview {
    private String gwonchaId;
    private String gwonchaTitle;
    private List<MunchePreview> munches = new ArrayList<>();
}