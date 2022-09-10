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


@Service
public class CategoryService extends DefaultSearch {

    //부모 클래스 CategorySearch 생성자 상속
    public CategoryService(
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
    public ArrayList<ArrayList<String>> searchByCategory(List<Lv1> lv1List){
        List<String>lv1IdList = new ArrayList<>();
        int listLength = lv1List.toArray().length;
        for (int i=0; i<listLength; i++) {
            String lv1Id = lv1List.get(i).getId();
            lv1IdList.add(lv1Id);
        }

        return searchByKeyWord(lv1IdList, listLength);
    }


    @Transactional
    public ArrayList<ArrayList<String>> searchByBookName(String bookName){
        List<Lv1> lv1List = lv1Repository.findLv1ByLv1Title(bookName);
        return searchByCategory(lv1List);
    }

    @Transactional
    public ArrayList<ArrayList<String>> searchByAuthorName(String authorName) {
        List<Lv1> lv1List = lv1Repository.findLv1ByAuthorName(authorName);
        return searchByCategory(lv1List);
    }

}
