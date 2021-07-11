package com.wangyousong.practice.saki.persistent.redis;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Supported keywords inside method names:
 * And,Or,Is, Equals,IsTrue,IsFalse,Top,First.
 * (Not like MySql, when we want complex query , we can use QueryByExampleExecutor, however it supports query quite less)
 */
@Repository(value = "redisVocabularyEntityRepository")
public interface VocabularyEntityRepository extends PagingAndSortingRepository<VocabularyEntity, String> {

}
