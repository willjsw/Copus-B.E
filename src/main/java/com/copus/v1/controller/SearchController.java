package com.copus.v1.controller;

import com.copus.v1.controller.request_object.*;
import com.copus.v1.controller.response_object.*;
import com.copus.v1.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/search-result")
public class SearchController {

    @Autowired
    CategoryService categorySearchService;

    @RequestMapping("/{searchCategory}/{keyword}")
    public Map Search(
            @ModelAttribute RequestCategorySearch requestCategorySearch){

        Map<String, ResultData> map = new HashMap<>();

        map.put("resultData", new ResultData("월고집", "조성가", "1929"));

        return map;
    }
}
