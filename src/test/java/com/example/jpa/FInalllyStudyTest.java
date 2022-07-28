package com.example.jpa;

import org.junit.jupiter.api.Test;

public class FInalllyStudyTest {

    @Test
    void asdf() {
        try {
            fff();
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("finally");
        }
    }

    private void fff() {
        throw new RuntimeException("ERROR");
    }
}
