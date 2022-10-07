package com.copus.v1.controller;

import com.copus.v1.controller.dto.*;
import com.copus.v1.service.article.search.SearchPreview;
import com.copus.v1.service.article.show.FinalService;
import com.copus.v1.service.article.show.GwonchaService;
import com.copus.v1.service.article.show.MuncheService;
import com.copus.v1.service.article.show.SeojiService;
import com.copus.v1.service.enums.SearchFilter;
import com.copus.v1.service.serviceDto.articleDto.searchDto.SearchPreviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final SearchPreview searchPreview;
    private final SeojiService seojiService;
    private final GwonchaService gwonchaService;
    private final MuncheService muncheService;
    private final FinalService finalService;

    @GetMapping("/preview")
    public PreviewResponse getPreview(@ModelAttribute PreviewRequest previewRequest) {
        SearchPreviewDto previewDto = searchPreview.getPreview(SearchFilter.valueOf(previewRequest.getFilter()), previewRequest.getKeyword());
        return new PreviewResponse(previewDto);
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