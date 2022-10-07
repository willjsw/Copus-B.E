package com.copus.v1.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ConsonantRangeSet {
    public ArrayList<String> consonantRangeSet(String consonant){
        final String finalConsonant[] ={"가","나","다","라","마","바","사","아","자","차","카","타","파","하"};
        List<String> consonantList = Arrays.asList(finalConsonant);
        ArrayList<String> result= new ArrayList<>();

        String consonant1;
        String consonant2;

        if (consonantList.contains(consonant) && consonant.equals("힣")){
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
