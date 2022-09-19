package com.copus.v1.service.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchByLv1TitleDto {

    private String lv1Id;
    private String lv1Title;
    private String author;
    private String originalPublishYear;

}
