package com.wangyousong.practice.saki.persistent.postgres;

import com.wangyousong.practice.saki.common.UpdatedTimeHelper;
import com.wangyousong.practice.saki.domain.Vocabulary;
import com.wangyousong.practice.saki.domain.VocabularyRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Optional;

@Slf4j
@Component("postgresVocabularyRepositoryImpl")
public class VocabularyRepositoryImpl implements VocabularyRepository {

    @Resource
    private VocabularyEntityRepository repository;

    @Override
    public Vocabulary save(Vocabulary vocabulary, boolean isCreated) {
        VocabularyEntity vocabularyEntity = new VocabularyEntity(vocabulary.getKey().to(),
                vocabulary.getChinese(), vocabulary.getChineseRemarks(), vocabulary.getEnglish(),
                vocabulary.getEnglishRemarks(), Instant.now(), UpdatedTimeHelper.populate(isCreated));
        VocabularyEntity entity = repository.save(vocabularyEntity);
        return entity.toVocabulary();
    }

    @Override
    public boolean exists(String key) {
        return repository.existsById(key);
    }

    @Override
    public void delete(String key) {
        repository.deleteById(key);
    }

    @Override
    public Optional<Vocabulary> findByKey(String key) {
        Optional<VocabularyEntity> optional = repository.findById(key);
        if (optional.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(optional.get().toVocabulary());
    }

    @Override
    public Page<Vocabulary> findByKeyword(String keyword, Pageable pageable) {
        if (StringUtils.isBlank(keyword)) {
            return repository.findAll(pageable).map(VocabularyEntity::toVocabulary);
        }
        return repository.findAllByKeyLikeOrChineseLikeOrEnglishLike(keyword, keyword, keyword, pageable)
                .map(VocabularyEntity::toVocabulary);
    }
}
