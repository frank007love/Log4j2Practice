package org.tonylin.practice.log4j2.example2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.junit.Test;
import org.tonylin.practice.log4j2.AbstractLog4j2Test;
import org.tonylin.practice.log4j2.example1.TestLogger;

public class TestReloadConfiguration extends AbstractLog4j2Test {
    private final static String TEST_LOG_FILE = "testdata/example2/log4j2.properties";
    
    @Test
    public void Should_NotSystemOutToConsole_When_LogDebugWithDefaultConfiguration() {   
        TestLogger.debug("test debug");
        assertEquals(0, captor.getStandardOutput().size());
        
        TestLogger2.debug("test debug");
        assertEquals(0, captor.getStandardOutput().size());
    }
    
    @Test
    public void Should_SystemOutToConsole_When_LoadNewConfigFileForTestLogger() {
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        File file = new File(TEST_LOG_FILE);
        context.setConfigLocation(file.toURI());
        
        TestLogger.debug("test debug");
        assertEquals(1, captor.getStandardOutput().size());
        assertTrue(captor.getStandardOutput().get(0).contains("test debug"));
    }
    
    @Test
    public void Should_SystemOutToConsole_When_LoadNewConfigFileForTestLogger2() {
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        File file = new File(TEST_LOG_FILE);
        context.setConfigLocation(file.toURI());
        
        TestLogger2.debug("test debug");
        assertEquals(1, captor.getStandardOutput().size());
        assertTrue(captor.getStandardOutput().get(0).contains("test debug"));
    }
}
