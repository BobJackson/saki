package com.wangyousong.practice.saki.dto;

import lombok.Data;

@Data
public class PageRequestDto {
    protected int page = 0;
    protected int size = 10;
}
