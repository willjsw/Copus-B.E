package com.copus.v1.controller;

import com.copus.v1.controller.dto.ChildLevelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
         * Level Tree : 가 - 저자 - 서지 - 권차 - 문체 - 최종정보보
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
}

