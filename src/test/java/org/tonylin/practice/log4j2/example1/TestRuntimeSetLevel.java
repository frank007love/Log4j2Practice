package org.tonylin.practice.log4j2.example1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.junit.Test;
import org.tonylin.practice.log4j2.AbstractLog4j2Test;

public class TestRuntimeSetLevel extends AbstractLog4j2Test {
    
    @Test
    public void Should_SystemOutToConsole_When_LogDebugAfterChangingLogLevelWithConfigurator() {
        Configurator.setLevel(TestLogger.class.getName(), Level.DEBUG);
        
        TestLogger.debug("test debug");
        assertEquals(1, captor.getStandardOutput().size());
        assertTrue(captor.getStandardOutput().get(0).contains("test debug"));
    }

    @Test
    public void Should_SystemOutToConsole_When_LogDebugAfterChangingLogLevel() {
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        LoggerConfig loggerConfig = config.getLoggerConfig(TestLogger.class.getName());
        loggerConfig.setLevel(Level.DEBUG);
        ctx.updateLoggers();
        
        TestLogger.debug("test debug");
        assertEquals(1, captor.getStandardOutput().size());
        assertTrue(captor.getStandardOutput().get(0).contains("test debug"));
    }

    @Test
    public void Should_NotSystemOutToConsole_When_LogDebugWithDefaultConfiguration() {   
        TestLogger.debug("test debug");
        assertEquals(0, captor.getStandardOutput().size());
    }

    @Test
    public void Should_SystemOutToConsole_When_LogErrorWithDefaultConfiguration() {
        TestLogger.error("test error");
        assertEquals(1, captor.getStandardOutput().size());
        assertTrue(captor.getStandardOutput().get(0).contains("test error"));
    }
}
