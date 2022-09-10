package com.copus.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitTestData {

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class TestData {
        private final EntityManager em;

        public void initLv1Data() {

        }
    }

}

