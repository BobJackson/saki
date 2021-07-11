package com.wangyousong.practice.saki.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KeyTest {


    @Test
    void should_raise_an_exception_when_contains_illegal_character() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Key("!2344F"));
        assertThat(exception).isNotNull().hasMessage("value contains illegal character!");
    }

    @Test
    void should_generate_a_random_string() {
        String key = Key.generate();
        assertThat(key).hasSize(6);
    }
}