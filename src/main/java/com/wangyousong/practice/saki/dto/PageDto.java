package com.wangyousong.practice.saki.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDto<T> {

    private List<T> data;
    private int currentPage;
    private int size;
    private int totalPages;
    private long totalElements;
    private boolean isLast;
    private boolean isFirst;
    private boolean hasNext;
    private boolean hasPrevious;
    private boolean isEmpty;

    public PageDto<T> from(Page<T> page) {
        this.data = page.getContent();
        this.currentPage = page.getNumber();
        this.size = page.getSize();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.isLast = page.isLast();
        this.isFirst = page.isFirst();
        this.hasNext = page.hasNext();
        this.hasPrevious = page.hasPrevious();
        this.isEmpty = page.isEmpty();
        return this;
    }

    public PageDto<T> emptyPage() {
        return new PageDto<>(Collections.emptyList(), 0, 0, 0, 0L, false, false, false, false, true);
    }

}
