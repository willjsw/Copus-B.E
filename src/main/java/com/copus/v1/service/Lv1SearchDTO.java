package com.copus.v1.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lv1SearchDTO {
    private int searchNum;
    private List<String> lv1Id;
    private List<String> lv1TitleChn;
    private List<String> lv1TitleKor;
    private List<String> authorChn;
    private List<String> authorKor;
    private List<String> zipsuStart;
    private List<String> zipsuEnd;
    private List<String> originalPublishYear;
}
