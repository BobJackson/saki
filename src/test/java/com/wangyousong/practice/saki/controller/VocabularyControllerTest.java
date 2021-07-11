package com.wangyousong.practice.saki.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VocabularyControllerTest {


    @Disabled
    @Test
    void should_response_200_when_post_a_vocabulary(@Autowired MockMvc mvc) throws Exception {
        Map<String, String> params = Map.of("key", "", "chinese", "角色", "english", "Role",
                "chineseRemarks", "全局使用", "englishRemarks", "Global usage");
        mvc.perform(post("/vocabularies", params)).andExpect(status().isCreated());

    }
}
