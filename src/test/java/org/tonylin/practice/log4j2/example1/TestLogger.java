package org.tonylin.practice.log4j2.example1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogger.class);
    
    public static void debug(String message) {
        LOGGER.debug(message);   
    }
    
    public static void error(String message) {
        LOGGER.error(message);   
    }
}
