package com.wangyousong.practice.saki.usecase;

import com.wangyousong.practice.saki.domain.VocabularyService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DeleteAVocabularyUseCase {

    @Resource
    private VocabularyService vocabularyService;

    public void execute(String key) {
        vocabularyService.delete(key);
    }
}
