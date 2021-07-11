package com.wangyousong.practice.saki.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class VocabularyQueryDto extends PageRequestDto{
    private String keyword;
}
