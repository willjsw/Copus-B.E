package com.copus.v1.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MuncheSearchDTO {
    private int caseNum;
    private List<String> lv3Id;
    private List<String> lv3Title;
}
