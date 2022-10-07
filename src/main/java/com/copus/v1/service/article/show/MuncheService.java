package com.copus.v1.service.article.show;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.GetMetaInfo;
import com.copus.v1.service.serviceDto.articleDto.showDto.FinalsDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.MuncheInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MuncheService {

    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;


    private final GetMetaInfo getMetaInfo;

    public MuncheInfoDto getMuncheInfo(String level_3_Id) {

        Lv3 munche = lv3Repository.findOne(level_3_Id);
        String muncheId = munche.getId();
        String muncheTitle = getMetaInfo.getTitleByMetaInfoId(munche.getMetaInfo().getId());

        Lv2 gwoncha = munche.getLv2();
        String gwonchaId = getMetaInfo.getTitleByMetaInfoId(gwoncha.getMetaInfo().getId());
        String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(gwoncha.getMetaInfo().getId());

        Lv1 seoji = gwoncha.getLv1();
        String seojiId = seoji.getId();
        String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(seoji.getMetaInfo().getId());


        List<Lv4> lv4s = lv4Repository.findAllByLv3Id(muncheId);
        List<FinalsDto> finals = new ArrayList<>();
        for(Lv4 lv4 : lv4s){
            finals.add(
                    new FinalsDto(lv4.getId(), getMetaInfo.getTitleByMetaInfoId(lv4.getMetaInfo().getId()))
            );
        }

        return new MuncheInfoDto(seojiId, seojiTitle, gwonchaId, gwonchaTitle, muncheTitle, finals);
    }

}
