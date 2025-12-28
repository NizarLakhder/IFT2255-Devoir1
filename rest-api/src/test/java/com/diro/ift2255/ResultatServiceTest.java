package com.diro.ift2255.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultatServiceTest {

    @Test
    void returnsEmptyWhenCourseNotFound() {
        ResultatService service = new ResultatService();

        assertTrue(service.getBySigle("COURSE_INEXISTANT").isEmpty());
    }
}