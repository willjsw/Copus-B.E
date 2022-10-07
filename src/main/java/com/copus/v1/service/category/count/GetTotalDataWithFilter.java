package com.copus.v1.service.category.count;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.serviceDto.categoryDto.count.GetTotalDataWithFilterDto;
import com.copus.v1.service.enums.SearchFilter;
import com.copus.v1.service.exception.NoFilterForSeojiPreviewException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetTotalDataWithFilter {
    private final Lv1Repository lv1Repository;
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;

    public GetTotalDataWithFilterDto getSearchCount(SearchFilter searchFilter, String keyword) {
        GetTotalDataWithFilterDto getTotalDataWithFilterDto = new GetTotalDataWithFilterDto(0,0,0,0,0,0,0);
        switch (searchFilter) {
            case dataId -> getCountByDataId(getTotalDataWithFilterDto, keyword);
            case content -> getCountByContent(getTotalDataWithFilterDto, keyword);
            case muncheTitle -> getCountByMuncheTitle(getTotalDataWithFilterDto, keyword);
            case gwonchaTitle -> getCountByGwonchaTitle(getTotalDataWithFilterDto, keyword);
            case authorName -> getCountByAuthorName(getTotalDataWithFilterDto, keyword);
            case bookTitle -> getCountByBookTitle(getTotalDataWithFilterDto, keyword);
            case total -> getCountByTotal(getTotalDataWithFilterDto, keyword);
            default -> throw new NoFilterForSeojiPreviewException("검색결과 카운트를 위한 필터가 존재하지 않습니다");
        }
        return getTotalDataWithFilterDto;
    }

    private Integer getLevelDepthByLevelId(String levelId) {
        return Math.toIntExact(levelId.chars()
                .filter(c -> c == '_')
                .count() - 1);
    }

    private void getCountByDataId(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        switch (getLevelDepthByLevelId(keyword)) {
            //서지 ID
            case 1 -> getCountByLv1Id(getTotalDataWithFilterDto, keyword);
            //권차 ID
            case 2 -> getCountByLv2Id(getTotalDataWithFilterDto, keyword);
            //문체 ID
            case 3 -> getCountByLv3Id(getTotalDataWithFilterDto, keyword);
            //최종정보 ID
            case 4 -> getCountByLv4Id(getTotalDataWithFilterDto, keyword);
            //default -> throw new InvalidLevelIdException("해당 레벨 깊이는 존재하지 않습니다");

        }
    }

    private void getCountByLv1Id(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        List<Lv1> seojies = lv1Repository.findAllByLv1IdKeyword(keyword);
        getTotalDataWithFilterDto.setDataIdCount(seojies.size());
        getTotalDataWithFilterDto.setTotalCount(getTotalDataWithFilterDto.getTotalCount()+seojies.size());

    }

    private void getCountByLv2Id(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        List<Lv2> gwonchas = lv2Repository.findAllByLv2IdKeyword(keyword);
        getTotalDataWithFilterDto.setDataIdCount(gwonchas.size());
        getTotalDataWithFilterDto.setTotalCount(getTotalDataWithFilterDto.getTotalCount()+gwonchas.size());
    }


    private void getCountByLv3Id(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        List<Lv3> munches = lv3Repository.findAllByLv3IdKeyword(keyword);
        getTotalDataWithFilterDto.setDataIdCount(munches.size());
        getTotalDataWithFilterDto.setTotalCount(getTotalDataWithFilterDto.getTotalCount()+munches.size());
    }

    private void getCountByLv4Id(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        List<Lv4> finalInfos = lv4Repository.findAllByLv4IdKeyword(keyword);
        getTotalDataWithFilterDto.setDataIdCount(finalInfos.size());
        getTotalDataWithFilterDto.setTotalCount(getTotalDataWithFilterDto.getTotalCount()+finalInfos.size());
    }

    private void getCountByContent(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        List<Lv4> finalInfos = lv4Repository.findAllByContentKeyword(keyword);
        getTotalDataWithFilterDto.setContentCount(finalInfos.size());
        getTotalDataWithFilterDto.setTotalCount(getTotalDataWithFilterDto.getTotalCount()+finalInfos.size());
    }

    private void getCountByMuncheTitle(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        List<Lv3> munches = lv3Repository.findLv3ByLv3Title(keyword);
        getTotalDataWithFilterDto.setMuncheTitleCount(munches.size());
        getTotalDataWithFilterDto.setTotalCount(getTotalDataWithFilterDto.getTotalCount()+munches.size());
    }

    private void getCountByGwonchaTitle(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        List<Lv2> gwonchas = lv2Repository.findLv2ByLv2Title(keyword);
        getTotalDataWithFilterDto.setGwonchaTitleCount(gwonchas.size());
        getTotalDataWithFilterDto.setTotalCount(getTotalDataWithFilterDto.getTotalCount()+gwonchas.size());
    }

    private void getCountByAuthorName(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        List<Lv1> seojies = lv1Repository.findLv1ByAuthorName(keyword);
        getTotalDataWithFilterDto.setAuthorNameCount(seojies.size());
        getTotalDataWithFilterDto.setTotalCount(getTotalDataWithFilterDto.getTotalCount()+seojies.size());
    }

    private void getCountByBookTitle(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        List<Lv1> seojies = lv1Repository.findLv1ByLv1Title(keyword);
        getTotalDataWithFilterDto.setBookTitleCount(seojies.size());
        getTotalDataWithFilterDto.setTotalCount(getTotalDataWithFilterDto.getTotalCount()+seojies.size());
    }

    private void getCountByTotal(GetTotalDataWithFilterDto getTotalDataWithFilterDto, String keyword) {
        getCountByContent(getTotalDataWithFilterDto, keyword);
        getCountByMuncheTitle(getTotalDataWithFilterDto, keyword);
        getCountByGwonchaTitle(getTotalDataWithFilterDto, keyword);
        getCountByAuthorName(getTotalDataWithFilterDto, keyword);
        getCountByBookTitle(getTotalDataWithFilterDto, keyword);
        getCountByDataId(getTotalDataWithFilterDto, keyword);
    }

}
