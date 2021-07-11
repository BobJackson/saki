package com.wangyousong.practice.saki.controller;

import com.wangyousong.practice.saki.dto.PageDto;
import com.wangyousong.practice.saki.dto.VocabularyDto;
import com.wangyousong.practice.saki.usecase.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/vocabularies")
public class VocabularyController {

    @Resource
    private CreateAVocabularyUseCase createAVocabularyUseCase;
    @Resource
    private DeleteAVocabularyUseCase deleteAVocabularyUseCase;
    @Resource
    private UpdateAVocabularyUseCase updateAVocabularyUseCase;
    @Resource
    private FindAVocabularyUseCase findAVocabularyUseCase;
    @Resource
    private ListVocabulariesUseCase listVocabulariesUseCase;


    @PostMapping
    public ResponseEntity<VocabularyDto> create(@RequestBody VocabularyDto dto) {
        return new ResponseEntity<>(createAVocabularyUseCase.execute(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<Void> delete(@PathVariable String key) {
        deleteAVocabularyUseCase.execute(key);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{key}")
    public ResponseEntity<VocabularyDto> update(@RequestBody VocabularyDto dto, @PathVariable String key) {
        return new ResponseEntity<>(updateAVocabularyUseCase.execute(key, dto), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{key}")
    public ResponseEntity<VocabularyDto> details(@PathVariable String key) {
        return new ResponseEntity<>(findAVocabularyUseCase.execute(key), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PageDto<VocabularyDto>> list(@RequestParam(required = false) String keyword,
                                                       @RequestParam Integer page, @RequestParam Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return new ResponseEntity<>(listVocabulariesUseCase.execute(keyword, pageRequest), HttpStatus.OK);
    }
}
