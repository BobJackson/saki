package com.wangyousong.practice.saki.domain;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class Key {
    private static final int LEGAL_LENGTH = 6;
    private static final String LEGAL_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String value;

    public Key(String value) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("value can't be blank");
        }
        if (value.length() != LEGAL_LENGTH) {
            throw new IllegalArgumentException("value must be 6 characters !");
        }
        for (Character c : value.toCharArray()) {
            if (!LEGAL_CHARACTERS.contains(c + "")) {
                throw new IllegalArgumentException("value contains illegal character!");
            }
        }
        this.value = value;
    }

    public String to() {
        return this.value;
    }

    public static String generate(){
        return RandomStringUtils.random(LEGAL_LENGTH, LEGAL_CHARACTERS);
    }
}
