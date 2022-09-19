package com.copus.v1.service;

//저자 정보

import com.copus.v1.domain.info.meta.Author;
import com.copus.v1.repository.info.meta.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchAuthorName implements ConsonantRangeSet {

    public final AuthorRepository authorRepository;

    //Lv1 서지명 입력, Id 반환

    public ArrayList<ArrayList<String>> searchAuthorNameByItemName(String consonant){
        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        ArrayList<String> searchNum = new ArrayList<>();
        ArrayList<String> nameKor = new ArrayList<>();
        ArrayList<String> nameChn = new ArrayList<>();

        String consonant1 = ConsonantRangeSet.consonantRange(consonant).get(0);
        String consonant2 = ConsonantRangeSet.consonantRange(consonant).get(1);

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
