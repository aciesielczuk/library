package org.skniwas.library.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class IdGenerator {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static int getUniqueId() {
        return counter.incrementAndGet();
    }
}
