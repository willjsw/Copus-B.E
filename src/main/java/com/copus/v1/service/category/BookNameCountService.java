package com.copus.v1.service.category;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.category.BookNameCountDto;
import com.copus.v1.service.dto.category.TotalCountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookNameCountService {

    private final Lv1Repository lv1Repository;

    public BookNameCountDto bookNameCount(String keyword) {

        BookNameCountDto bookNameCountDto = new BookNameCountDto();

        List<Lv1> lv1List = lv1Repository.findLv1ByLv1Title(keyword);

        int lv1Count = lv1List.size();

        bookNameCountDto.setBookNameCount(lv1Count);

        return bookNameCountDto;
    }

}
