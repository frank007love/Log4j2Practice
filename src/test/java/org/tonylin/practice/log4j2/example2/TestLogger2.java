package org.tonylin.practice.log4j2.example2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogger2.class);
    
    public static void debug(String message) {
        LOGGER.debug(message);   
    }
    
    public static void error(String message) {
        LOGGER.error(message);   
    }
}
