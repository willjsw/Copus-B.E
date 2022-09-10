package com.copus.v1.service;

import com.copus.v1.domain.info.meta.Title;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.info.body.ContentRepository;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;
    private final TitleRepository titleRepository;
    private final AuthorRepository authorRepository;
    private final PublishInfoRepository publishInfoRepository ;
    private final ContentRepository contentRepository;

    ArrayList<ArrayList<String>> result = new ArrayList<>();
    ArrayList<String> caseNum = new ArrayList<>();
    ArrayList<String> caseLv1Id = new ArrayList<>();
    ArrayList<String> caseLv1Title = new ArrayList<>();
    ArrayList<String> caseLv2Id = new ArrayList<>();
    ArrayList<String> caseLv2Title = new ArrayList<>();
    ArrayList<String> caseLv3Id = new ArrayList<>();
    ArrayList<String> caseLv3Title = new ArrayList<>();
    ArrayList<String> caseLv4Id= new ArrayList<>();
    ArrayList<String> caseLv4Title = new ArrayList<>();
    ArrayList<String> caseAuthor = new ArrayList<>();
    ArrayList<String> caseOriginalPublishYear = new ArrayList<>();
    ArrayList<String> caseContent = new ArrayList<>();


    @Transactional
    public ArrayList<ArrayList<String>> searchByContent(String contentText) {

        List<Lv4> contentSearch = lv4Repository.findLv4ByContent(contentText);

        int listLength = contentSearch.toArray().length;
        if (listLength != 0) {

            caseNum.add(String.valueOf(listLength));

            for(int i=0; i<listLength; i++){
                //각 레벨 별 ID
                String lv4Id = contentSearch.get(i).getId();
                String lv3Id = contentSearch.get(i).getLv3().getId();
                List<Lv3> lv3List = lv3Repository.findLv3ByLv3Id(lv3Id);
                String lv2Id = lv3List.get(0).getLv2().getId();
                List<Lv2> lv2List = lv2Repository.findLv2ByLv2Id(lv2Id);
                String lv1Id = lv2List.get(0).getLv1().getId();
                ArrayList<String> lv1Title = new ArrayList<>();


                String authorChn = authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameChn();
                String authorKor = authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameKor();
                List<Title> lv1TitleList = titleRepository.findLv1TitleByLv1Id(lv1Id);
                int titleListLength = lv1TitleList.toArray().length;
                for (int j = 0; j < titleListLength; j++) {
                    lv1Title.add(lv1TitleList.get(j).getTitleText());
                }
                String lv2Title = titleRepository.findLv2TitleByLv2Id(lv2Id).get(0).getTitleText();
                String lv3Title = titleRepository.findLv3TitleByLv3Id(lv3Id).get(0).getTitleText();
                String lv4Title = titleRepository.findLv4TitleByLv4Id(lv4Id).get(0).getTitleText();
                String originalPublishYear= publishInfoRepository.findPublishInfoByLv1Id(lv1Id).get(0).getOriginalPublishYear();
                String content = contentRepository.findLv4ContentByTitleId(lv4Id).get(0).getContentText();

                //항목별 배열화
                caseLv1Id.add(lv1Id);
                caseLv1Title = lv1Title;
                caseLv2Id.add(lv2Id);
                caseLv2Title.add(lv2Title);
                caseLv3Id.add(lv3Id);
                caseLv3Title.add(lv3Title);
                caseLv4Id.add(lv4Id);
                caseLv4Title.add(lv4Title);
                caseAuthor.add(authorChn);
                caseAuthor.add(authorKor);
                caseOriginalPublishYear.add(originalPublishYear);
                caseContent.add(content);
            }
            //return 할 최종배열 생성
            result.add(caseNum);
            result.add(caseLv1Id);
            result.add(caseLv1Title);
            result.add(caseLv2Id);
            result.add(caseLv2Title);
            result.add(caseLv3Id);
            result.add(caseLv3Title);
            result.add(caseLv4Id);
            result.add(caseLv4Title);
            result.add(caseAuthor);
            result.add(caseOriginalPublishYear);
            result.add(caseContent);
        } else {
            caseNum.add(String.valueOf(listLength));
            result.add(caseNum);
        }

        return result;
    }
}
