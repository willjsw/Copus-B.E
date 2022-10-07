package com.copus.v1.service.article.show;

import com.copus.v1.domain.level.Lv1;
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
public class GwonchaService {

    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;

    private final GetMetaInfo getMetaInfo;

    public GwonchaInfoDto getGwonchaInfo(String level_2_Id) {
        Lv2 gwoncha = lv2Repository.findOne(level_2_Id);
        String gwonchaId = gwoncha.getId();
        String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(gwoncha.getMetaInfo().getId());

        Lv3 munche = lv3Repository.findAllByLv2Id(gwonchaId).get(0);
        String muncheId = munche.getId();
        String muncheTitle = getMetaInfo.getTitleByMetaInfoId(munche.getMetaInfo().getId());

        Lv1 seoji = gwoncha.getLv1();
        String seojiId = seoji.getId();
        String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(seoji.getMetaInfo().getId());

        List<MunchesDto> munches = new ArrayList<>();
        munches.add(new MunchesDto(muncheId, muncheTitle ));

        List<DatasDto> datas = new ArrayList<>();
        datas.add(new DatasDto(gwonchaId, gwonchaTitle, munches));

        return new GwonchaInfoDto(seojiId, seojiTitle, datas);
    }

}
