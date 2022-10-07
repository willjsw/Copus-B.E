package com.copus.v1.service.category.child;

import com.copus.v1.domain.info.meta.Author;
import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.ConsonantRangeSet;
import com.copus.v1.service.GetMetaInfo;
import com.copus.v1.service.serviceDto.categoryDto.child.GetChildLevelDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetChildLevelData {

    private final Lv1Repository lv1Repository;
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;
    private final AuthorRepository authorRepository;
    private final GetMetaInfo getMetaInfo;
    private final ConsonantRangeSet consonantRangeSet;

    public void getChildLv4ByLv3Id(String parentId, List<GetChildLevelDataDto> getChildLevelDataDtos) {
        List<Lv4> finalInfos = lv4Repository.findAllByLv3Id(parentId);
        for (Lv4 finalInfo : finalInfos) {
            Long metaInfoId = finalInfo.getMetaInfo().getId();
            String finalInfoTitle = getMetaInfo.getTitleByMetaInfoId(metaInfoId);
            getChildLevelDataDtos.add(new GetChildLevelDataDto(finalInfo.getId(), finalInfoTitle));
        }
    }

    public void getChildLv3ByLv2Id(String parentId, List<GetChildLevelDataDto> getChildLevelDataDtos) {
            List<Lv3> munches = lv3Repository.findAllByLv2Id(parentId);
            for (Lv3 munche : munches) {
                Long metaInfoId = munche.getMetaInfo().getId();
                String muncheTitle = getMetaInfo.getTitleByMetaInfoId(metaInfoId);
                getChildLevelDataDtos.add(new GetChildLevelDataDto(munche.getId(), muncheTitle));
            }
        }

    public void getChildLv2ByLv1Id(String parentId, List<GetChildLevelDataDto> getChildLevelDataDtos){
            List<Lv2> gwonchas= lv2Repository.findAllByLv1Id(parentId);
            for (Lv2 gwoncha : gwonchas) {
                Long metaInfoId = gwoncha.getMetaInfo().getId();
                String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(metaInfoId);
                getChildLevelDataDtos.add(new GetChildLevelDataDto(gwoncha.getId(), gwonchaTitle));
        }
    }

    public void getChildLv1ByAuthorName(String parentId, List<GetChildLevelDataDto> getChildLevelDataDtos){
        List<Lv1> seojies= lv1Repository.findLv1ByAuthorId(Long.parseLong(parentId));
        for (Lv1 seojie : seojies) {
            Long metaInfoId = seojie.getMetaInfo().getId();
            String seojieTitle = getMetaInfo.getTitleByMetaInfoId(metaInfoId);
            getChildLevelDataDtos.add(new GetChildLevelDataDto(seojie.getId(), seojieTitle));
        }
    }
    public void getChildLv1ByConsonant(String consonantStart, List<GetChildLevelDataDto> getChildLevelDataDtos){
        List<Lv1> seojies= lv1Repository.findLv1ByConsonant(consonantRangeSet.consonantRangeSet(consonantStart).get(0), consonantRangeSet.consonantRangeSet(consonantStart).get(1));
        for (Lv1 seojie : seojies) {
            Long metaInfoId = seojie.getMetaInfo().getId();
            String seojieTitle = getMetaInfo.getTitleByMetaInfoId(metaInfoId);
            getChildLevelDataDtos.add(new GetChildLevelDataDto(seojie.getId(), seojieTitle));
        }
    }


    public void getChildAuthorNameByConsonant(String consonantStart, List<GetChildLevelDataDto> getChildLevelDataDtos){
        List<Author> authors= authorRepository.findAuthorNameByConsonant(consonantRangeSet.consonantRangeSet(consonantStart).get(0), consonantRangeSet.consonantRangeSet(consonantStart).get(1));;
        for (Author author : authors) {
            getChildLevelDataDtos.add(new GetChildLevelDataDto(author.getId().toString(), author.concatNameKorAndChn()));
        }
    }

}
