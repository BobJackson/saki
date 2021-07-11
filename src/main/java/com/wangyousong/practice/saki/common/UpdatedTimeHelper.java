package com.wangyousong.practice.saki.common;

import java.time.Instant;

public class UpdatedTimeHelper {

    public static Instant populate(boolean isCreated) {
        return isCreated ? null : Instant.now();
    }
}
