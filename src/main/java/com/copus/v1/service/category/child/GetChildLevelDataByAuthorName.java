package com.copus.v1.service.category.child;

import com.copus.v1.service.serviceDto.categoryDto.child.GetChildLevelDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetChildLevelDataByAuthorName {

    private final GetChildLevelData getChildLevelData;


    public List<GetChildLevelDataDto> getChildDataByAuthorName(String parentId, int depth) {
        List<GetChildLevelDataDto> getChildLevelDataDtos = new ArrayList<>();
        switch (depth) {

            case -1 -> getChildLevelData.getChildAuthorNameByConsonant(parentId, getChildLevelDataDtos);
            case 0 -> getChildLevelData.getChildLv1ByAuthorName(parentId, getChildLevelDataDtos);
            case 1 -> getChildLevelData.getChildLv2ByLv1Id(parentId, getChildLevelDataDtos);
            case 2 -> getChildLevelData.getChildLv3ByLv2Id(parentId, getChildLevelDataDtos);
            case 3 -> getChildLevelData.getChildLv4ByLv3Id(parentId, getChildLevelDataDtos);
            //default -> throw new InvalidLevelIdException("해당 레벨 깊이는 존재하지 않습니다");
        }
        return getChildLevelDataDtos;
    }
}