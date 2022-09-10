package com.copus.v1.controller.response_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData {
    private String 서명_id;
    private String 서명_서명;
    private String 서명_저자;
    private String 서명_문체;
    private String 서명_간행년;

    private String 저자_id;
    private String 저자_서명;
    private String 저자_저자;
    private String 저자_문체;
    private String 저자_간행년;

    private String 본문_id;
    private String 본문_서명;
    private String 본문_권차;
    private String 본문_문체;
    private String 본문_저자;
    private String 본문_간행년;
    private String 본문_페이지;
    private String 본문_본문;

    public ResultData(String 월고집, String 조성가, String 저자) {
        this.서명_서명 = 월고집;
        this.서명_저자 = 조성가;
        this.서명_간행년 = 저자;
    }
}
