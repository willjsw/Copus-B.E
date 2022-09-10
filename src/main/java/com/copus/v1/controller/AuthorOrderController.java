package com.copus.v1.controller;


import com.copus.v1.controller.request_object.*;
import com.copus.v1.controller.response_object.*;
import com.copus.v1.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/original-text")
//public class AuthorOrderController {
//
//    private final AuthorNameService authorNameService;
//    private final BookNameService bookNameSearchService;
//    private final FinalInfoService finalInfoSearchService;
//    private final GwonchaService gwonchaSerachService;
//    private final MuncheService muncheSearchService;
//
//
//    @GetMapping("/{literature}/byauthor/{consonant}")
//    public Map RequestAllAuthor(
//            @ModelAttribute RequestAllAuthorData requestAllAuthorData) {
//
////        log.info("literature={}, consonant={}", requestAllAuthorData.getLiterature(), requestAllAuthorData.getConsonant());
//
//        Map<String, Object> map = new LinkedHashMap<>();
//        ArrayList<ArrayList<String>> authors_info = authorNameService.searchAuthorNameByItemName(requestAllAuthorData.getLiterature(), requestAllAuthorData.getConsonant());
//        ArrayList<String> authors = new ArrayList<>();
//
//        int result_num = Integer.parseInt(authors_info.get(0).get(0));
//        for (int i = 0; i < result_num; i++) {
//            authors.add(authors_info.get(2).get(i));
//        }
//
//        System.out.println(authors);
//        String bookname, author, jipsuStart, jipsuEnd, publishYear;
//        for (int i = 0; i < result_num; i++) {
//            ArrayList<ArrayList<String>> lv1_infos = bookNameSearchService.searchLv1ByAuthorName(authors.get(i));
//            int r_num = Integer.parseInt(lv1_infos.get(0).get(0));
//
//            for (int j = 1; j <= (r_num * 5); j += 5) {
//                bookname = lv1_infos.get(j).get(1);
//                author = lv1_infos.get(j + 1).get(1);
//                jipsuStart = lv1_infos.get(j + 2).get(0);
//                jipsuEnd = lv1_infos.get(j + 3).get(0);
//                publishYear = lv1_infos.get(j + 4).get(0);
//
//                ResponseAllAuthorData responseAllAuthorData = new ResponseAllAuthorData(bookname, author, jipsuStart, jipsuEnd, publishYear);
//                map.put("결과", responseAllAuthorData);
//            }
//        }
//
//        return map;
//    }
//
//
//    @RequestMapping("/{literature}/byauthor/{consonant}/{authorname}/{bookname}")
//    public Map RequestAuthorByNameAndBookName(
//            @ModelAttribute RequestAllLv2AuthorData requestAllLv2AuthorData) {
//
////        log.info("literature={}, consonant={}, authorname={},bookname={}, level1Id={}",
////                requestAllLv2AuthorData.getLiterature(), requestAllLv2AuthorData.getConsonant(),
////                requestAllLv2AuthorData.getAuthorname(), requestAllLv2AuthorData.getBookName());
//
//        Map<String, Object> map = new LinkedHashMap<>();
//
//        ArrayList<ArrayList<String>> lev2_infos = gwonchaSerachService.searchLv2ByLv1Id(requestAllLv2AuthorData.getLiterature(), requestAllLv2AuthorData.getConsonant(),
//                requestAllLv2AuthorData.getAuthorname(), requestAllLv2AuthorData.getBookName());
//
//        int result_num = Integer.parseInt(lev2_infos.get(0).get(0));
//        String gwoncha;
//        for (int i = 0; i < result_num; i++) {
//            gwoncha = lev2_infos.get(1).get(i);
//            ResponseAllLv2AuthorData responseAllLev2AuthorData = new ResponseAllLv2AuthorData(gwoncha);
//            map.put("결과" + (i + 1), responseAllLev2AuthorData);
//        }
//
//        return map;
//    }
//
//    @RequestMapping("/{literature}/byauthor/{consonant}/{authorname}/{bookname}/{gwoncha}")
//    public Map RequestAuthorLv3(
//            @ModelAttribute RequestAllLv3AuthorData requestAllLv3AuthorData) {
//
//        log.info("literature={}, consonant={}, authorname={},bookname={}, gwoncha={}",
//                requestAllLv3AuthorData.getLiterature(), requestAllLv3AuthorData.getConsonant(),
//                requestAllLv3AuthorData.getAuthorname(), requestAllLv3AuthorData.getBookName(),
//                requestAllLv3AuthorData.getGwoncha());
//
//        Map<String, Object> map = new LinkedHashMap<>();
//
//        ArrayList<ArrayList<String>> lev3_infos = muncheSearchService.searchLv3ByLv2Id(requestAllLv3AuthorData.getLiterature(), requestAllLv3AuthorData.getConsonant(),
//                requestAllLv3AuthorData.getAuthorname(), requestAllLv3AuthorData.getBookName(),
//                requestAllLv3AuthorData.getGwoncha());
//
//        int result_num = Integer.parseInt(lev3_infos.get(0).get(0));
//        String munche;
//        for (int i = 0; i < result_num; i++) {
//            munche = lev3_infos.get(1).get(i);
//            ResponseAllLv3AuthorData responseAllLv3AuthorData = new ResponseAllLv3AuthorData(munche);
//            map.put("결과" + (i + 1), responseAllLv3AuthorData);
//        }
//
//        return map;
//    }
//
//    @RequestMapping("/{literature}/byauthor/{consonant}/{authorname}/{bookname}/{gwoncha}/{munche}")
//    public Map RequestAuthorLv4(
//            @ModelAttribute RequestAllLv4AuthorData requestAllLv4AuthorData) {
//
//        log.info("literature={}, consonant={}, authorname={},bookname={}, gwoncha={}, munche={}",
//                requestAllLv4AuthorData.getLiterature(), requestAllLv4AuthorData.getConsonant(),
//                requestAllLv4AuthorData.getAuthorname(), requestAllLv4AuthorData.getBookName(),
//                requestAllLv4AuthorData.getGwoncha(), requestAllLv4AuthorData.getMunche());
//
//        Map<String, Object> map = new LinkedHashMap<>();
//
//        ArrayList<ArrayList<String>> lev4_infos = finalInfoSearchService.searchLv4ByLv3Id(requestAllLv4AuthorData.getLiterature(), requestAllLv4AuthorData.getConsonant(),
//                requestAllLv4AuthorData.getAuthorname(), requestAllLv4AuthorData.getBookName(),
//                requestAllLv4AuthorData.getGwoncha(), requestAllLv4AuthorData.getMunche());
//
//        int result_num = Integer.parseInt(lev4_infos.get(0).get(0));
//        String title;
//        for (int i = 0; i < result_num; i++) {
//            title = lev4_infos.get(1).get(i);
//            ResponseAllLv4AuthorData responseAllLev4Data = new ResponseAllLv4AuthorData(title);
//            map.put("결과" + (i + 1), responseAllLev4Data);
//        }
//
//        return map;
//
//    }
//
//    @RequestMapping("/{literature}/byauthor/{consonant}/{authorname}/{bookname}/{gwoncha}/{munche}/{title}")
//    public ResponseAllLv5AuthorData RequestAuthorLv5(
//            @ModelAttribute RequestAllLv5AuthorData requestAllLv5AuthorData) {
//        return new ResponseAllLv5AuthorData(finalInfoSearchService.searchLv4ContentByLv4Id(requestAllLv5AuthorData.getLiterature(), requestAllLv5AuthorData.getConsonant(),
//                requestAllLv5AuthorData.getAuthorname(), requestAllLv5AuthorData.getBookName(),
//                requestAllLv5AuthorData.getGwoncha(), requestAllLv5AuthorData.getMunche(),
//                requestAllLv5AuthorData.getTitle()));
//    }
//
//}
