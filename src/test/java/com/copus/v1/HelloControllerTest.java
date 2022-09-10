package com.copus.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloControllerTest {
    @Test
    public void asd() throws Exception{
        throw new MyException("hello World!");
     }
}