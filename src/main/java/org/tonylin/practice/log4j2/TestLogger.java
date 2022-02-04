package org.tonylin.practice.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogger.class);
    
    public static void main(String[] args) {
        LOGGER.error("test: {}", "test");
    }

}
