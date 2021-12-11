package com.example.randonnumbergame;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MainActivityInputUnitTest {
    @Test
    public void validateInput() {
        boolean result = MainActivity.validateInput("111");
        assertThat(result).isEqualTo(true);
    }
}