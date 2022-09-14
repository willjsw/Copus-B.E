package com.copus.v1.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalInfoTitleSearchDTO {
    private int caseNum;
    private List<String> lv4Id;
    private List<String> lv4Title;
}
