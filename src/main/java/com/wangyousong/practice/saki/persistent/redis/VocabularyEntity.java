package com.wangyousong.practice.saki.persistent.redis;

import com.wangyousong.practice.saki.domain.Key;
import com.wangyousong.practice.saki.domain.Vocabulary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("vocabularies")
public class VocabularyEntity {
    @Id
    private String key;
    @Indexed
    private String chinese;
    private String chineseRemarks;
    @Indexed
    private String english;
    private String englishRemarks;
    private Instant createdTime = Instant.now();
    private Instant updatedTime;

    public Vocabulary toVocabulary() {
        return new Vocabulary(new Key(key), chinese, chineseRemarks, english, englishRemarks);
    }
}
