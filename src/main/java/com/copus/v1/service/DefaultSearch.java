package com.copus.v1.service;

import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv1Repository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class DefaultSearch {

    public final Lv1Repository lv1Repository;
    public final TitleRepository titleRepository;
    public final AuthorRepository authorRepository;
    public final PublishInfoRepository publishInfoRepository ;





    public Lv1SearchDTO searchByKeyWord(List<String>lv1IdList) {

        Lv1SearchDTO lv1SearchDTO = new Lv1SearchDTO();

        int caseNum = lv1IdList.toArray().length;
        lv1SearchDTO.setSearchNum(caseNum);

        if (caseNum != 0) {

            List<String> lv1Id = new ArrayList<>();
            List<String> lv1TitleChn = new ArrayList<>();
            List<String> lv1TitleKor = new ArrayList<>();
            List<String> authorChn = new ArrayList<>();
            List<String> authorKor = new ArrayList<>();
            List<String> zipsuStart = new ArrayList<>();
            List<String> zipsuEnd = new ArrayList<>();
            List<String> originalPublishYear = new ArrayList<>();


            for (String id : lv1IdList) {
                lv1Id.add(id);
                lv1TitleChn.add(titleRepository.findLv1TitleByLv1Id(id).get(0).getTitleText());
                lv1TitleKor.add(titleRepository.findLv1TitleByLv1Id(id).get(1).getTitleText());
                authorChn.add(authorRepository.findAuthorNameByLv1Id(id).get(0).getNameChn());
                authorKor.add(authorRepository.findAuthorNameByLv1Id(id).get(0).getNameKor());
                zipsuStart.add(publishInfoRepository.findPublishInfoByLv1Id(id).get(0).getZipsuStart());
                zipsuEnd.add(publishInfoRepository.findPublishInfoByLv1Id(id).get(0).getZipsuEnd());
                originalPublishYear.add(publishInfoRepository.findPublishInfoByLv1Id(id).get(0).getOriginalPublishYear());

            }
            lv1SearchDTO.setLv1Id(lv1Id);
            lv1SearchDTO.setLv1TitleChn(lv1TitleChn);
            lv1SearchDTO.setLv1TitleKor(lv1TitleKor);
            lv1SearchDTO.setAuthorChn(authorChn);
            lv1SearchDTO.setAuthorKor(authorKor);
            lv1SearchDTO.setZipsuStart(zipsuStart);
            lv1SearchDTO.setZipsuEnd((zipsuEnd));
            lv1SearchDTO.setOriginalPublishYear(originalPublishYear);

        }
        return lv1SearchDTO;
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
