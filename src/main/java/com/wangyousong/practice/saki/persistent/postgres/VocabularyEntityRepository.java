package com.wangyousong.practice.saki.persistent.postgres;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface VocabularyEntityRepository extends PagingAndSortingRepository<VocabularyEntity, String> {

    Page<VocabularyEntity> findAllByKeyLikeOrChineseLikeOrEnglishLike(String keyword1, String keyword2,
                                                                      String keyword3, Pageable pageable);
}
