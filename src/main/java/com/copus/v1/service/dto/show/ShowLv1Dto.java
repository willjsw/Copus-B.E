package com.copus.v1.service.dto.show;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowLv1Dto {
    private String lv1Id;
    private String lv1Title;
    private String author;
    private String zipsuStart;
    private String zipsuEnd;
    private String originalPublishYear;
    private List<ShowLv1Dto> buga;
    private String beomrye;
    private String chapter;
    private String haejae;


}
