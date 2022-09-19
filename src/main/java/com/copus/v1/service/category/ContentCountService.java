package com.copus.v1.service.category;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.category.ContentCountDto;
import com.copus.v1.service.dto.category.TotalCountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContentCountService {
    private final Lv4Repository lv4Repository;


    public ContentCountDto contentCount(String keyword) {

        ContentCountDto contentCountDto = new ContentCountDto();

        List<Lv4> lv4ListByContent = lv4Repository.findLv4ByContent(keyword);

        int lv14ByContentCount = lv4ListByContent.size();

        contentCountDto.setContentCount(lv14ByContentCount);

        return contentCountDto;
    }

}
