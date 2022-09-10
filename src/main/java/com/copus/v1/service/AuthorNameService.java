package com.copus.v1.service;

//저자 정보

import com.copus.v1.domain.info.meta.Author;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv1Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorNameService extends DefaultSearch {

    //부모 클래스 CategorySearch 생성자 상속
    public AuthorNameService(
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

    //Lv1 서지명 입력, Id 반환
    @Transactional
    public ArrayList<ArrayList<String>> searchAuthorNameByItemName(String consonant){
        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        ArrayList<String> searchNum = new ArrayList<>();
        ArrayList<String> nameKor = new ArrayList<>();
        ArrayList<String> nameChn = new ArrayList<>();

        String consonant1 = consonantRange(consonant).get(0);
        String consonant2 = consonantRange(consonant).get(1);

        List<Author> authorList=authorRepository.findAuthorNameByConsonant(consonant1, consonant2);

        int authorListLength = authorList.toArray().length;
        searchNum.add(String.valueOf(authorListLength));


        for(int i=0; i<authorList.toArray().length;i++){
            nameChn.add(authorList.get(i).getNameChn());
            nameKor.add(authorList.get(i).getNameKor());
        }

        resultList.add(searchNum);
        resultList.add(nameChn);
        resultList.add(nameKor);

        return resultList;
    }


}
