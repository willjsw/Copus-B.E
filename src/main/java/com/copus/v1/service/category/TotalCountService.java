package com.copus.v1.service.category;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.category.TotalCountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TotalCountService {

    private final Lv1Repository lv1Repository;
    private final Lv4Repository lv4Repository;


    public TotalCountDto totalCount(String keyword) {

        TotalCountDto totalCountDto = new TotalCountDto();

        List<Lv1> lv1List = lv1Repository.findLv1ByLv1Title(keyword);
        List<Lv1> lv1ListByAuthorName = lv1Repository.findLv1ByAuthorName(keyword);
        List<Lv4> lv4ListByContent = lv4Repository.findLv4ByContent(keyword);


        int lv1Count = lv1List.size();
        int lv1CountByAuthorName = lv1ListByAuthorName.size();
        int lv14ByContentCount = lv4ListByContent.size();
        int total = lv1Count+lv1CountByAuthorName+lv14ByContentCount;

        totalCountDto.setTotalCount(total);
        totalCountDto.setBookNameCount(lv1Count);
        totalCountDto.setAuthorNameCount(lv1CountByAuthorName);
        totalCountDto.setContentCount(lv14ByContentCount);

        return totalCountDto;
    }

}
