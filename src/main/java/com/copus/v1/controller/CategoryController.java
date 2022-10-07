package com.copus.v1.controller;

import com.copus.v1.controller.dto.ChildLevelResponse;
import com.copus.v1.controller.dto.TotalCountsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("/book/{depth}/{currentId}")
    public ChildLevelResponse getChildLevelsByBook(@PathVariable Long depth, @PathVariable String currentId) {
        ChildLevelResponse childLevelResponse = new ChildLevelResponse();

        /**
         * Level Tree : 가 - 서지 - 권차 - 문체 - 최종정보
         * if Depth == 0:
         *      currentId == 가, 나, 다, ...
         *      ex. Child is Seoji Start with '가'
         * if Depth > 0:
         *      currentId == Level_id(ex. ITMC_KO_... - Is it right? zz)
         *
         * *****Child Title Must Include Both Kor and Chn- Final Form is KorName(ChnName)******
         */

        return childLevelResponse;
    }

    @GetMapping("/author/{depth}/{currentId}")
    public ChildLevelResponse getChildLevelsByAuthor(@PathVariable Long depth, @PathVariable String currentId) {
        ChildLevelResponse childLevelResponse = new ChildLevelResponse();

        /**
         * Level Tree : 가 - 저자 - 서지 - 권차 - 문체 - 최종정보
         * if Depth == 0:
         *      currentId == 가, 나, 다, ...
         *      ex. Child is Author Start with '가'
         * if Depth > 0:
         *      currentId == Level_id(ex. ITMC_KO_... - Is it right? zz)
         *
         * *****Child Title Must Include Both Kor and Chn- Final Form is KorName(ChnName)******
         */

        return childLevelResponse;
    }

    @GetMapping("/total")
    public TotalCountsResponse getTotalDataWithFilter(@RequestParam String filter, @RequestParam String keyword) {
        TotalCountsResponse totalCountsResponse = new TotalCountsResponse();

        /**
         * @param filter: total || bookTitle || authorName || content - 필터 종류
         * @param keyword : 검색바로 넘어오는 검색어
         * @return{
         *      if filter == total : 모든 필터 종류별 개수 ex. 15, 12, 2, 1
         *      else : 해당 필터 개수만 ex. bookTitle - 3, 3, 0, 0
         *      }
         */

        return totalCountsResponse;
    }
}