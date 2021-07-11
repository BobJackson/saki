package com.wangyousong.practice.saki.usecase;

import com.wangyousong.practice.saki.domain.VocabularyService;
import com.wangyousong.practice.saki.dto.PageDto;
import com.wangyousong.practice.saki.dto.VocabularyDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ListVocabulariesUseCase {

    @Resource
    private VocabularyService vocabularyService;


    public PageDto<VocabularyDto> execute(String keyword, PageRequest pageRequest) {
        return vocabularyService.list(keyword, pageRequest);
    }
}
