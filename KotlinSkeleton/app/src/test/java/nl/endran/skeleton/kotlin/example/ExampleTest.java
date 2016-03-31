package nl.endran.skeleton.kotlin.example;

import org.junit.Test;

import mockit.Mocked;

public class ExampleTest {
    @Test
    public void ShouldX_WhenY(@Mocked Thread thread) throws Exception {
        Example example = new Example();
        example.doMagic();
    }
}