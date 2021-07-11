package com.wangyousong.practice.saki.config;

import com.wangyousong.practice.saki.domain.VocabularyService;
import com.wangyousong.practice.saki.persistent.postgres.VocabularyRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class VocabularyServiceBean {

    /**
     * TODO: 灵活地切换redis的实现和postgres sql
     */
    @Resource
    private VocabularyRepositoryImpl vocabularyRepositoryImpl;

    @Bean
    public VocabularyService vocabularyService() {
        return new VocabularyService(vocabularyRepositoryImpl);
    }

}
