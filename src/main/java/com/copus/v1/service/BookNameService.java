package com.copus.v1.service;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv1Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//Lv1 서지명 입력, Id 반환
@Service
public class BookNameService extends DefaultSearch {

    //부모 클래스 CategorySearch 생성자 상속
    public BookNameService(
            Lv1Repository lv1Repository,
            TitleRepository titleRepository,
            AuthorRepository authorRepository,
            PublishInfoRepository publishInfoRepository) {
        super(
                lv1Repository,
                titleRepository,
                authorRepository,
                publishInfoRepository
        );
    }

    @Transactional
    public Lv1SearchDTO searchLv1ByConsonant(String consonant) {
        List<String> lv1IdList = new ArrayList<>();
        String consonant1 = consonantRange(consonant).get(0);
        String consonant2 = consonantRange(consonant).get(1);

        List<Lv1> lv1list = lv1Repository.findLv1ByConsonant(consonant1, consonant2);
        for (Lv1 lv1 : lv1list) {
            String lv1Id = lv1.getId();
            lv1IdList.add(lv1Id);
        }
        return searchByKeyWord(lv1IdList);
    }

    @Transactional
    public Lv1SearchDTO searchLv1ByAuthorName(String author){
        List<String>lv1IdList = new ArrayList<>();
        List<Lv1>lv1list=lv1Repository.findLv1ByAuthorName(author);
        for (Lv1 lv1 : lv1list) {
            String lv1Id = lv1.getId();
            lv1IdList.add(lv1Id);
        }
        return searchByKeyWord(lv1IdList);
    }
}
