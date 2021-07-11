package com.wangyousong.practice.saki.usecase;

import com.wangyousong.practice.saki.domain.VocabularyService;
import com.wangyousong.practice.saki.dto.VocabularyDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CreateAVocabularyUseCase {

    @Resource
    private VocabularyService vocabularyService;

    public VocabularyDto execute(VocabularyDto dto){
        return vocabularyService.save(dto);
    }
}
