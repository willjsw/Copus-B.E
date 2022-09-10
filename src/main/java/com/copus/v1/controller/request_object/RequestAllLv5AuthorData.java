package com.copus.v1.controller.request_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAllLv5AuthorData {
    private String literature;
    private String consonant;
    private String authorname;
    private String bookName;
    private String gwoncha;
    private String munche;
    private String title;
}
