package com.copus.v1.service.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchByTotalDto {
    private ArrayList<SearchByLv1TitleDto> searchByLv1TitleDto;
    private ArrayList<SearchByLv2TitleDto> searchByLv2TitleDto;
    private ArrayList<SearchByLv3TitleDto> searchByLv3TitleDto;
    private ArrayList<SearchByLv4TitleDto> searchByLv4TitleDto;
    private ArrayList<SearchByLv4ContentDto> searchByLv4ContentDto;
    private ArrayList<SearchByAuthorNameDto> searchByAuthorNameDto;
}
