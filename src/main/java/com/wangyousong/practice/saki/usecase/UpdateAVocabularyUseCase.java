package com.wangyousong.practice.saki.usecase;

import com.wangyousong.practice.saki.domain.VocabularyService;
import com.wangyousong.practice.saki.dto.VocabularyDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UpdateAVocabularyUseCase {

    @Resource
    private VocabularyService vocabularyService;

    public VocabularyDto execute(String key, VocabularyDto dto) {
        return vocabularyService.update(key, dto);
    }
}
