package com.copus.v1.service;


import com.copus.v1.domain.enums.CommentType;
import com.copus.v1.domain.info.meta.Author;
import com.copus.v1.domain.info.meta.PublishInfo;
import com.copus.v1.domain.info.meta.Title;
import com.copus.v1.repository.info.body.ContentRepository;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.ChapterInfoRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GetMetaInfo {

    private final TitleRepository titleRepository;
    private final AuthorRepository authorRepository;
    private final PublishInfoRepository publishInfoRepository;
    private final ContentRepository contentRepository;
    private final ChapterInfoRepository chapterInfoRepository;

    public String getPublishYear(Long metaInfoId) {
        PublishInfo publishInfo = publishInfoRepository.findPublishInfoByMetaInfoId(metaInfoId);
        String publishYear = publishInfo.getPublishYear();
        return publishYear;
    }

    public String getAuthorName(Long metaInfoId) {
        Author author = authorRepository.findAuthorByMetaInfoId(metaInfoId);
        String authorName = author.concatNameKorAndChn();
        return authorName;
    }

    public String getSeojiTitleByMetaInfoId(Long metaInfoId) {
        List<Title> titles = titleRepository.findTitleByMetaInfoId(metaInfoId);
        String titleKor = titles.get(1).getTitleText();
        String titleChn = titles.get(0).getTitleText();
        String seojiTitle = titleKor + "(" + titleChn + ")";
        return seojiTitle;
    }

    public String getSeojiTitleByLv1Id(String level_1_Id) {
        List<Title> titles = titleRepository.findLv1TitleByLv1Id(level_1_Id);
        String titleKor = titles.get(1).getTitleText();
        String titleChn = titles.get(0).getTitleText();
        String seojiTitle = titleKor + "(" + titleChn + ")";
        return seojiTitle;
    }

    public String getTitleByMetaInfoId(Long metaInfoId) {
        List<Title> titles = titleRepository.findTitleByMetaInfoId(metaInfoId);
        String gwonchaTitle = titles.get(0).getTitleText();
        return gwonchaTitle;
    }

    public String getZipsu(Long metaInfoId) {
        PublishInfo publishInfo = publishInfoRepository.findPublishInfoByMetaInfoId(metaInfoId);
        String zipsuStart = publishInfo.getZipsuStart();
        String zipsuEnd = publishInfo.getZipsuEnd();

        if(publishInfo.getZipsu().equals("1")){
            return (zipsuTransform(zipsuStart) + "집");
        }else {
            return (zipsuTransform(zipsuStart) + "-" + Integer.parseInt(zipsuEnd.substring(1, 4)) + "집");
        }

    }

    private String zipsuTransform(String zipsu){
        String zipsuCategory = zipsu.substring(0, 1);
        switch (zipsuCategory) {
            case "a" -> zipsu = String.valueOf(Integer.parseInt(zipsu.substring(1, 4)));
            case "b" -> zipsu = "속"+ Integer.parseInt(zipsu.substring(1, 4));
        }
        return zipsu;
    }
    public String getBeomrye(Long commentaryInfoId){
        return contentRepository.findCommentaryByCommentaryInfoId(commentaryInfoId, CommentType.범례).get(0).getContentText();
    }

    public String getHaejae(Long commentaryInfoId){
        return contentRepository.findCommentaryByCommentaryInfoId(commentaryInfoId, CommentType.간략해제).get(0).getContentText();
    }

    public String getChapterInfo(Long metaInfoId){
        return chapterInfoRepository.findChapterInfoByMetaInfoId(metaInfoId).get(0).getChapterInfoText();
    }



}
