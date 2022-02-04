package org.tonylin.practice.log4j2;

import org.apache.logging.log4j.core.config.Configurator;
import org.junit.After;
import org.junit.Before;

import nl.altindag.console.ConsoleCaptor;

public abstract class AbstractLog4j2Test {
    protected ConsoleCaptor captor;

    @Before
    public void setup() {
        captor = new ConsoleCaptor();
        Configurator.reconfigure();
    }

    @After
    public void teardown() {
        captor.close();
    }
}
