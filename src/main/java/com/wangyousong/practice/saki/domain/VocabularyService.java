package com.wangyousong.practice.saki.domain;

import com.wangyousong.practice.saki.dto.PageDto;
import com.wangyousong.practice.saki.dto.VocabularyDto;
import com.wangyousong.practice.saki.exception.RecordNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Objects;
import java.util.Optional;


public class VocabularyService {

    public final VocabularyRepository vocabularyRepository;

    public VocabularyService(VocabularyRepository VocabularyRepository) {
        this.vocabularyRepository = VocabularyRepository;
    }


    public VocabularyDto save(VocabularyDto dto) {
        generateKeyWhenCreated(dto);
        Vocabulary vocabulary = vocabularyRepository.save(new Vocabulary(dto), isCreated(dto.getKey()));
        return vocabulary.toDto();
    }

    private void generateKeyWhenCreated(VocabularyDto dto) {
        if (isCreated(dto.getKey())) {
            dto.setKey(Key.generate());
        }
    }

    private boolean isCreated(String key) {
        return StringUtils.isBlank(key);
    }

    public void delete(String key) {
        checkExistence(key);
        vocabularyRepository.delete(key);
    }

    private void checkExistence(String key) {
        if (!vocabularyRepository.exists(key)) {
            throw new RecordNotFoundException("Can't find related record with key = " + key);
        }
    }

    public VocabularyDto update(String key, VocabularyDto dto) {
        checkExistence(key);
        checkConsistence(key, dto);
        return save(dto);
    }

    private void checkConsistence(String key, VocabularyDto dto) {
        if (!Objects.equals(key, dto.getKey())) {
            throw new IllegalArgumentException("key in dto is not equal to url path key !");
        }
    }

    public VocabularyDto findByKey(String key) {
        checkExistence(key);
        Optional<Vocabulary> optional = vocabularyRepository.findByKey(key);
        return optional.map(Vocabulary::toDto).orElse(new VocabularyDto());
    }

    public PageDto<VocabularyDto> list(String keyword, PageRequest pageRequest) {
        PageRequest pageable = pageRequest.withSort(Sort.by(Sort.Direction.DESC, "createdTime"));
        Page<Vocabulary> vocabularies = vocabularyRepository.findByKeyword(keyword, pageable);
        if (vocabularies.isEmpty()) {
            return new PageDto<VocabularyDto>().emptyPage();
        }
        Page<VocabularyDto> dtoPage = vocabularies.map(Vocabulary::toDto);
        PageDto<VocabularyDto> result = new PageDto<>();
        return result.from(dtoPage);
    }
}
