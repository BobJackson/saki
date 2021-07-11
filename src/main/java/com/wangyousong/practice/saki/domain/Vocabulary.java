package com.wangyousong.practice.saki.domain;


import com.wangyousong.practice.saki.dto.VocabularyDto;
import lombok.Getter;

@Getter
public class Vocabulary {
    private final Key key;
    private final String chinese;
    private final String chineseRemarks;
    private final String english;
    private final String englishRemarks;


    public Vocabulary(VocabularyDto dto) {
        this.key = new Key(dto.getKey());
        this.chinese = dto.getChinese();
        this.chineseRemarks = dto.getChineseRemarks();
        this.english = dto.getEnglish();
        this.englishRemarks = dto.getEnglishRemarks();
    }

    public Vocabulary(Key key, String chinese, String chineseRemarks, String english, String englishRemarks) {
        this.key = key;
        this.chinese = chinese;
        this.chineseRemarks = chineseRemarks;
        this.english = english;
        this.englishRemarks = englishRemarks;
    }

    public VocabularyDto toDto(){
        VocabularyDto dto = new VocabularyDto();
        dto.setKey(key.to());
        dto.setChinese(chinese);
        dto.setChineseRemarks(chineseRemarks);
        dto.setEnglish(english);
        dto.setEnglishRemarks(englishRemarks);
        return dto;
    }
}
