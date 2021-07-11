package com.wangyousong.practice.saki.persistent.postgres;

import com.wangyousong.practice.saki.domain.Key;
import com.wangyousong.practice.saki.domain.Vocabulary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_vocabulary")
public class VocabularyEntity {
    @Id
    @Column(name = "_key")
    private String key;
    private String chinese;
    private String chineseRemarks;
    private String english;
    private String englishRemarks;
    private Instant createdTime = Instant.now();
    private Instant updatedTime;

    public Vocabulary toVocabulary() {
        return new Vocabulary(new Key(key), chinese, chineseRemarks, english, englishRemarks);
    }
}