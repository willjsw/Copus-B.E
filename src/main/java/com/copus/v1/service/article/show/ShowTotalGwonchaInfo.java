package com.copus.v1.service.article.show;

import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.service.GetMetaInfo;
import com.copus.v1.service.serviceDto.articleDto.showDto.DatasDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.GwonchaInfoDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.MunchesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowTotalGwonchaInfo {

    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;

    private final GetMetaInfo getMetaInfo;

    public GwonchaInfoDto getTotalGwonchaInfo(String level_1_Id) {
        List<Lv2> gwonchas = lv2Repository.findAllByLv1Id(level_1_Id);
        String seojiId = level_1_Id;
        String seojiTitle = getMetaInfo.getSeojiTitleByLv1Id(level_1_Id);
        List<DatasDto> datas = new ArrayList<>();
        for (Lv2 gwoncha : gwonchas) {

            String gwonchaId = gwoncha.getId();
            String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(gwoncha.getMetaInfo().getId());

            List<Lv3> lv3s = lv3Repository.findAllByLv2Id(gwonchaId);
            List<MunchesDto> munches = new ArrayList<>();
            for(Lv3 lv3 : lv3s){
                munches.add(
                        new MunchesDto(lv3.getId(), getMetaInfo.getTitleByMetaInfoId(lv3.getMetaInfo().getId())));
            }

            datas.add(
                    new DatasDto(gwonchaId, gwonchaTitle, munches));
        }

        return new GwonchaInfoDto(seojiId, seojiTitle, datas);
    }

}
