package com.copus.v1.service.show;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.service.dto.show.ShowLv1Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainShow {

    public final Lv1Repository lv1Repository;
    public final TitleRepository titleRepository;
    public final AuthorRepository authorRepository;
    public final PublishInfoRepository publishInfoRepository ;

    public ArrayList<ShowLv1Dto> mainSearchByLv1(List<Lv1> lv1List) {

        List<String> lv1IdList = new ArrayList<>();
        for (Lv1 lv1 : lv1List) {
            lv1IdList.add(lv1.getId());
        }

        ArrayList<ShowLv1Dto> showLv1DtoList = new ArrayList<>();
        ShowLv1Dto showLv1Dto;

        int searchNum = lv1IdList.toArray().length;

        if (searchNum != 0) {

            for (String lv1Id : lv1IdList) {
                showLv1Dto = new ShowLv1Dto();
                showLv1Dto.setLv1Id(lv1Id);
                String lv1TitleChn = titleRepository.findLv1TitleByLv1Id(lv1Id).get(0).getTitleText();
                String lv1TitleKor = titleRepository.findLv1TitleByLv1Id(lv1Id).get(1).getTitleText();
                showLv1Dto.setLv1Title(lv1TitleKor+"("+lv1TitleChn+")");
                String authorChn=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameChn();
                String authorKor=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameKor();
                showLv1Dto.setAuthor(authorKor+"("+authorChn+")");
                showLv1Dto.setZipsuStart(publishInfoRepository.findPublishInfoByLv1Id(lv1Id).get(0).getZipsuStart());
                showLv1Dto.setZipsuEnd(publishInfoRepository.findPublishInfoByLv1Id(lv1Id).get(0).getZipsuEnd());
                showLv1Dto.setOriginalPublishYear(publishInfoRepository.findPublishInfoByLv1Id(lv1Id).get(0).getOriginalPublishYear());

                showLv1DtoList.add(showLv1Dto);
            }
        }
        return showLv1DtoList;
    }

}
