package org.example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.*;

public class ConditionTest {

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.LINUX})
    public void testOnlyWin(){

    }

    @Test
    @DisabledOnOs({OS.LINUX})
    public void testOnlyLinux(){

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_15)
    public void testJre1_8(){

    }

    @RepeatedTest(
            value = 5,
            name = "{displayName} to {currentRepetition}"
    )
    void repeated(TestInfo info){
        System.out.println(info.getDisplayName());
        System.out.println(info.getTestClass());
    }
}
