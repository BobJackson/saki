package com.wangyousong.practice.saki.config;

import com.wangyousong.practice.saki.domain.VocabularyRepository;
import com.wangyousong.practice.saki.domain.VocabularyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class VocabularyServiceBean {


    @Resource(name = "${vocabularyRepositoryImpl}")
    private VocabularyRepository vocabularyRepository;

    @Bean
    public VocabularyService vocabularyService() {
        return new VocabularyService(vocabularyRepository);
    }

}
