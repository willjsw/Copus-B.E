package com.copus.v1.controller.request_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAllLev5Data {
    private String literature;
    private String consonant;
    private String bookName;
    private String gwoncha;
    private String munche;
    private String title;
    private String level4Id;
}
