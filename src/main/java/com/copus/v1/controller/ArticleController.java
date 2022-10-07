package com.copus.v1.controller;

import com.copus.v1.controller.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/preview")
    public PreviewResponse getPreview(@ModelAttribute PreviewRequest previewRequest) {
        PreviewResponse previewResponse = new PreviewResponse();

        /**
         * Data For Search Result Article
         * @param Filter == 검색 필터 (total || bookTitle || authorName || gwonchaTitle || muncheTitle || content || dataId)
         * @param keyword == 검색어
         * @return {
         * 	"count":'',
         * 	"datas":[
         *                {
         * 			"seojiId":'',
         * 			"seojiTitle": '',
         * 			"authorName": '',
         * 			"publishYear":'',
         * 			"gwonchaId": '',  - if needContent is false, null
         * 			"gwonchaTitle": '권차명',  - if needContent is false, null
         * 			"muncheId": '',  - if needContent is false, null
         * 			"muncheTitle": '문체명',  - if needContent is false, null
         * 			"finalId":'', - if needContent is false, null
         * 			"finalTitle":'최종정보 제목', - if needContent is false, null
         * 			"contentPartition": '본문일부', //최대 200자  - if needContent is false, null
         *        },...
         * } if some field is null, make the block blanck
         */

        return previewResponse;
    }

    @GetMapping("/seoji")
    public SeojiResponse getSeoji(@ModelAttribute SeojiRequest seojiRequest) {
        SeojiResponse seojiResponse = new SeojiResponse();

        /**
         * Data For Seojies Article
         * @param keyword : 쿼리 검색용 키워드, value( all || 저자명 || 가나다 中 1 )
         * @param ordering : 쿼리 페이징 키워드, value( none || author ||| book )
         * @return{
         * 	"count":'',
         * 	"datas":[
         *       {
         * 		"seojiId":'',
         * 		"seojiTitle":'',
         * 		"authorName":'',
         * 		"zipsuStart":'',
         * 		"zipsuEnd":'',
         * 		"publishYear":'',
         * 		"buga":{
         * 		//부가 정보 있을 시 value == 서지 ID
         * 			"beomrye":'',
         * 			"chapter":'', //목차
         * 			"haejae":''
         *            }
         *      },...
         * }
         */

        return seojiResponse;
    }

    @GetMapping("/gwoncha/{id}")
    public GwonchaResponse getGwoncha(@PathVariable String id) {
        GwonchaResponse gwonchaResponse = new GwonchaResponse();

        /**
         * Gwoncha Data For  Article
         * @param Gwoncha id
         * @return
         * {
         * 	"seojiId":'',
         * 	"seojiTitle":'',
         * 	"datas":[
         *                {
         * 			"gwonchaId":'',
         * 			"gwonchaTitle":'',
         * 			"munches":[
         *                    {
         * 						"muncheId":'',
         * 						"muncheTitle":'',
         *                    },...
         * 				]
         *        },...
         * 	]
         * }
         */

        return gwonchaResponse;
    }

    @GetMapping("/munche/{id}")
    public MuncheResponse getMunche(@PathVariable String id) {
        MuncheResponse muncheResponse = new MuncheResponse();

        /**
         * Munche Data for Article
         * @return{
         * 	"seojiId":'',
         * 	"seojiTitle":'',
         * 	"gwonchaId":'',
         * 	"gwonchaTitle":'',
         * 	"muncheTitle":'',
         * 	"finals":[
         *                {
         * 			"finalId":'',
         * 			"finalTitle":'',
         *        },...
         * 	]
         * }
         */

        return muncheResponse;
    }

    @GetMapping("/final/{id}")
    public FinalResponse getFinal(@PathVariable String id) {
        FinalResponse finalResponse = new FinalResponse();

        /**
         * Final Data for Article
         * @return{
         * 	"seojiId":'',
         * 	"seojiTitle":'',
         * 	"gwonchaId":'',
         * 	"gwonchaTitle":'',
         * 	"muncheId":'',
         * 	"muncheTitle":'',
         * 	"final":{
         * 		"title":'',
         * 		"content":'',
         *        }
         * }
         */

        return finalResponse;
    }
}