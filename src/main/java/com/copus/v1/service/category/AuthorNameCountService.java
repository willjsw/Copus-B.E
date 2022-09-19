package com.copus.v1.service.category;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.category.AuthorNameCountDto;
import com.copus.v1.service.dto.category.TotalCountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorNameCountService {

    private final Lv1Repository lv1Repository;

    public AuthorNameCountDto authorNameCount(String keyword) {

        AuthorNameCountDto authorNameCountDto = new AuthorNameCountDto();

        List<Lv1> lv1ListByAuthorName = lv1Repository.findLv1ByAuthorName(keyword);

        int lv1CountByAuthorName = lv1ListByAuthorName.size();

        authorNameCountDto.setAuthorNameCount(lv1CountByAuthorName);

        return authorNameCountDto;
    }

}
