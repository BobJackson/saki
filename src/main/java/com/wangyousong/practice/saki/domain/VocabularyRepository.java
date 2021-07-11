package com.wangyousong.practice.saki.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface VocabularyRepository {

    Vocabulary save(Vocabulary vocabulary, boolean isUpdate);

    void delete(String key);

    boolean exists(String key);

    Optional<Vocabulary> findByKey(String key);

    Page<Vocabulary> findByKeyword(String keyword, Pageable pageRequest);
}
