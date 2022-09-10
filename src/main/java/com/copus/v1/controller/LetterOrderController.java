//package com.copus.v1.controller;
//
//import com.copus.v1.controller.request_object.*;
//import com.copus.v1.controller.response_object.*;
//import com.copus.v1.service.BookNameService;
//import com.copus.v1.service.FinalInfoService;
//import com.copus.v1.service.GwonchaService;
//import com.copus.v1.service.MuncheService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/original-text")
//public class LetterOrderController {
//
//    private final BookNameService bookNameSearchService;
//    private final FinalInfoService finalInfoSearchService;
//    private final GwonchaService gwonchaSerachService;
//    private final MuncheService muncheSearchService;
//
//    @GetMapping( "/{literature}/bybook/{consonant}")
//    public Map RequestAllLev1(
//            @ModelAttribute RequestAllLev1Data requestAllLev1Data){
//        log.info("literature={}, consonant={}", requestAllLev1Data.getLiterature(), requestAllLev1Data.getConsonant());
//
//        Map<String, Object> map = new LinkedHashMap<>();
//
//        // 서비스에 일단 받은 데이터 다 넘겨주었어요,
//        ArrayList<ArrayList<String>> lev1_infos = bookNameSearchService.searchLv1ByItemName(requestAllLev1Data.getLiterature()), requestAllLev1Data.getConsonant());
//
//        int result_num = Integer.parseInt(lev1_infos.get(0).get(0));
//        String bookname, author, jipsuStart, jipsuEnd, publishYear;
//
//        for(int i = 1; i <= (result_num*5); i+=5){
//            bookname = lev1_infos.get(i).get(1);
//            author = lev1_infos.get(i+1).get(1);
//            jipsuStart = lev1_infos.get(i+2).get(0);
//            jipsuEnd = lev1_infos.get(i+3).get(0);
//            publishYear = lev1_infos.get(i+4).get(0);
//
//            ResponseAllLev1Data responseAllLev1Data = new ResponseAllLev1Data(bookname, author, jipsuStart, jipsuEnd, publishYear);
//            map.put("result", responseAllLev1Data);
//        }
//
//        return map;
//    }
//
//    @RequestMapping(value = "/{literature}/bybook/{consonant}/{bookname}")
//    public Map RequestAllLev2(
//            @ModelAttribute RequestAllLev2Data requestAllLev2Data
//            ){
//
//        log.info("literature={}, consonant={}, bookname={}", requestAllLev2Data.getLiterature(),
//                requestAllLev2Data.getConsonant(),requestAllLev2Data.getBookName());
//
//                Map<String, Object> map = new LinkedHashMap<>();
//
//        ArrayList<ArrayList<String>> lev2_infos = gwonchaSerachService.searchLv2ByLv1Id(requestAllLev2Data.getLiterature(),
//                requestAllLev2Data.getConsonant(), requestAllLev2Data.getBookName());
//
//        int result_num = Integer.parseInt(lev2_infos.get(0).get(0));
//        String gwoncha;
//        for(int i = 0; i < result_num; i++){
//            gwoncha = lev2_infos.get(1).get(i);
//            ResponseAllLev2Data responseAllLev2Data = new ResponseAllLev2Data(gwoncha);
//            map.put("result", responseAllLev2Data);
//        }
//
//        return map;
//
//    }
//
//    @RequestMapping(value = "/{literature}/bybook/{consonant}/{bookname}/{gwoncha}", method = RequestMethod.GET)
//    public Map RequestAllLev3(
//            @ModelAttribute RequestAllLev3Data requestAllLev3Data){
//
//        log.info("literature={}, consonant={}, bookname={}, 권차={}", requestAllLev3Data.getLiterature(),
//                requestAllLev3Data.getConsonant(),
//                requestAllLev3Data.getBookName(), requestAllLev3Data.getGwoncha());
//
//        Map<String, ResponseAllLev3Data> map = new LinkedHashMap<>();
//
//        ArrayList<ArrayList<String>> lev3_infos = muncheSearchService.searchLv3ByLv2Id(requestAllLev3Data.getLiterature(),
//                requestAllLev3Data.getConsonant(), requestAllLev3Data.getBookName(), requestAllLev3Data.getGwoncha());
//
//        int result_num = Integer.parseInt(lev3_infos.get(0).get(0));
//        String munche;
//        for(int i = 0; i < result_num; i++){
//            munche = lev3_infos.get(1).get(i);
//            ResponseAllLev3Data responseAllLev3Data = new ResponseAllLev3Data(munche);
//            map.put("결과"+(i+1), responseAllLev3Data);
//        }
//
//
//        return map;
//
//    }
//
//    @RequestMapping(value = "/{literature}/bybook/{consonant}/{bookname}/{gwoncha}/{munche}", method = RequestMethod.GET)
//    public Map RequestAllLev4(
//            @ModelAttribute RequestAllLev4Data requestAllLev4Data){
//
//        log.info("literature={}, consonant={}, bookname={}, gwoncha={}, munche={}",
//                requestAllLev4Data.getLiterature(), requestAllLev4Data.getConsonant(),
//                requestAllLev4Data.getBookName(), requestAllLev4Data.getGwoncha(),
//                requestAllLev4Data.getMunche());
//
//
//        Map<String, Object> map = new LinkedHashMap<>();
//
//        ArrayList<ArrayList<String>> lev4_infos = finalInfoSearchService.searchLv4ByLv3Id(requestAllLev4Data.getLiterature(), requestAllLev4Data.getConsonant(),
//                requestAllLev4Data.getBookName(), requestAllLev4Data.getGwoncha(),
//                requestAllLev4Data.getMunche());
//
//        int result_num = Integer.parseInt(lev4_infos.get(0).get(0));
//        String title;
//        for(int i = 0; i < result_num; i++){
//            title = lev4_infos.get(1).get(i);
//            ResponseAllLev4Data responseAllLev4Data = new ResponseAllLev4Data(title);
//            map.put("결과"+(i+1), responseAllLev4Data);
//        }
//
//        return map;
//
//    }
//
//    @RequestMapping(value = "/{literature}/bybook/{consonant}/{bookname}/{gwoncha}/{munche}/{title}", method = RequestMethod.GET)
//    public ResponseAllLev5Data AllLev5(
//            @ModelAttribute RequestAllLev5Data requestAllLev5Data){
//
//        return new ResponseAllLev5Data(finalInfoSearchService.searchLv4ContentByLv4Id(equestAllLev5Data.getLiterature(), requestAllLev5Data.getConsonant(),
//                requestAllLev5Data.getBookName(), requestAllLev5Data.getGwoncha(),
//                requestAllLev5Data.getMunche(), requestAllLev5Data.getTitle()));
//    }
//}
