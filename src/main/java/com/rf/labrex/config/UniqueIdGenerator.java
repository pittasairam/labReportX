package com.rf.labrex.config;

import java.util.UUID;

public class UniqueIdGenerator {
    public static String generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "").substring(0, 7); //
        return id;
    }

}
