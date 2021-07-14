package com.wangyousong.practice.saki.persistent.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("mongoVocabularyRepository")
public interface VocabularyEntityRepository extends MongoRepository<VocabularyEntity, String> {
    Page<VocabularyEntity> findAllByKeyLikeOrChineseLikeOrEnglishLike(String key, String chinese, String english, Pageable pageable);
}
