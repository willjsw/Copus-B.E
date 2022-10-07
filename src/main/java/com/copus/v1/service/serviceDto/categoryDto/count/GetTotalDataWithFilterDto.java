package com.copus.v1.service.serviceDto.categoryDto.count;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTotalDataWithFilterDto {
    private int totalCount;
    private int bookTitleCount;
    private int authorNameCount;
    private int gwonchaTitleCount;
    private int muncheTitleCount;
    private int contentCount;
    private int dataIdCount;
}
