package com.wangyousong.practice.saki.usecase;

import com.wangyousong.practice.saki.domain.VocabularyService;
import com.wangyousong.practice.saki.dto.VocabularyDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FindAVocabularyUseCase {

    @Resource
    private VocabularyService vocabularyService;

    public VocabularyDto execute(String key) {
        return vocabularyService.findByKey(key);
    }
}
