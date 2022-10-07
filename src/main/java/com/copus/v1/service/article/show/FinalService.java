package com.copus.v1.service.article.show;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.info.body.ContentRepository;

import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.GetMetaInfo;
import com.copus.v1.service.serviceDto.articleDto.showDto.FinalDataDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.FinalInfoDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FinalService {

    private final Lv4Repository lv4Repository;
    private final ContentRepository contentRepository;

    private final GetMetaInfo getMetaInfo;

    public FinalInfoDto getFinalInfo(String level_4_Id) {

        Lv4 finalInfo = lv4Repository.findOne(level_4_Id);
        String title = getMetaInfo.getTitleByMetaInfoId(finalInfo.getMetaInfo().getId());
        String content = contentRepository.findOneByBodyInfoId(finalInfo.getBodyInfo().getId()).get(0).getContentText();
        FinalDataDto finalDataDto = new FinalDataDto(title,content);

        Lv3 munche = finalInfo.getLv3();
        String muncheId = munche.getId();
        String muncheTitle = getMetaInfo.getTitleByMetaInfoId(munche.getMetaInfo().getId());

        Lv2 gwoncha = munche.getLv2();
        String gwonchaId = getMetaInfo.getTitleByMetaInfoId(gwoncha.getMetaInfo().getId());
        String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(gwoncha.getMetaInfo().getId());

        Lv1 seoji = gwoncha.getLv1();
        String seojiId = seoji.getId();
        String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(seoji.getMetaInfo().getId());

        return new FinalInfoDto(seojiId, seojiTitle, gwonchaId, gwonchaTitle, muncheId, muncheTitle, finalDataDto);
    }

}
