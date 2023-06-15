package com.inthava.learningjournal.utility;

import java.util.UUID;

public class Uuid {
    public static String getUuid() {
        return UUID.randomUUID().toString();
    }
}
