package com.copus.v1.service;

import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultSearch {

    public final Lv1Repository lv1Repository;
    public final TitleRepository titleRepository;
    public final AuthorRepository authorRepository;
    public final PublishInfoRepository publishInfoRepository ;

    public ArrayList<ArrayList<String>> searchByKeyWord(List<String>lv1IdList, int listLength){

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> caseNum = new ArrayList<>();
        ArrayList<String> caseLv1Id = new ArrayList<>();
        ArrayList<String> caseLv1Title = new ArrayList<>();
        ArrayList<String> caseAuthor = new ArrayList<>();
        ArrayList<String> casezipsuStart = new ArrayList<>();
        ArrayList<String> casezipsuEnd = new ArrayList<>();
        ArrayList<String> caseOriginalPublishYear = new ArrayList<>();


        caseNum.add(String.valueOf(listLength));

        if(listLength==0) {
            result.add(caseNum);
        }else{
            for (int i=0; i<listLength; i++) {
                String authorChn = authorRepository.findAuthorNameByLv1Id(lv1IdList.get(i)).get(0).getNameChn();
                String authorKor = authorRepository.findAuthorNameByLv1Id(lv1IdList.get(i)).get(0).getNameKor();
                String zipsuStart = publishInfoRepository.findPublishInfoByLv1Id(lv1IdList.get(i)).get(0).getZipsuStart();
                String zipsuEnd = publishInfoRepository.findPublishInfoByLv1Id(lv1IdList.get(i)).get(0).getZipsuEnd();
                String originalPublishYear = publishInfoRepository.findPublishInfoByLv1Id(lv1IdList.get(i)).get(0).getOriginalPublishYear();
                //Entity 수정 필요할지도
                for (int j = 0; j < titleRepository.findLv1TitleByLv1Id(lv1IdList.get(i)).toArray().length; j++) {
                    caseLv1Title.add(titleRepository.findLv1TitleByLv1Id(lv1IdList.get(i)).get(j).getTitleText());
                }
                //항목별 배열화
                caseLv1Id.add(lv1IdList.get(i));
                caseAuthor.add(authorChn);
                caseAuthor.add(authorKor);
                casezipsuStart.add(zipsuStart);
                casezipsuEnd.add(zipsuEnd);
                caseOriginalPublishYear.add(originalPublishYear);
            }
            //항목3 저자명(한자/한글)
            result.add(caseNum);
            result.add(caseLv1Id);
            result.add(caseLv1Title);
            result.add(caseAuthor);
            result.add(casezipsuStart);
            result.add(casezipsuEnd);
            result.add(caseOriginalPublishYear);
        }
        return result;
    }

    public ArrayList<String> consonantRange(String consonant){
        final ArrayList<String> consonantList = new ArrayList<>();
        ArrayList<String> result= new ArrayList<>();
        consonantList.add("가");
        consonantList.add("나");
        consonantList.add("다");
        consonantList.add("라");
        consonantList.add("마");
        consonantList.add("바");
        consonantList.add("사");
        consonantList.add("아");
        consonantList.add("자");
        consonantList.add("차");
        consonantList.add("카");
        consonantList.add("타");
        consonantList.add("파");
        consonantList.add("하");
        consonantList.add("힣");

        String consonant1;
        String consonant2;

        if (consonantList.contains(consonant) && consonant != "힣") {
            consonant1 = consonant;
            int consonant1Index = consonantList.indexOf(consonant1);
            consonant2 = consonantList.get(consonant1Index + 1);

        }else{
            consonant1="a";
            consonant2="a";
        }

        result.add(consonant1);
        result.add(consonant2);

        return result;
    }

}
