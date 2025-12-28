package com.diro.ift2255.service;

import com.diro.ift2255.model.*;
import com.diro.ift2255.util.HttpClientApi;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    private final HttpClientApi httpClient = Mockito.mock(HttpClientApi.class);
    private final CourseService service = new CourseService(httpClient);

    @Test
    void eligibilityFailsWhenPrerequisiteMissing() {
        Course course = new Course();
        course.setPrerequisite_courses(List.of("IFT1015"));

        EligibilityRequest req = new EligibilityRequest();
        req.setCompletedCourses(List.of("IFT1025"));
        req.setCycle("bac");

        EligibilityResult result = service.checkEligibility(course, req);

        assertFalse(result.isEligible());
        assertEquals(List.of("IFT1015"), result.getMissingPrerequisites());
    }

    @Test
    void eligibilityFailsWhenCycleIsNotBac() {
        Course course = new Course();
        course.setPrerequisite_courses(List.of());

        EligibilityRequest req = new EligibilityRequest();
        req.setCompletedCourses(List.of());
        req.setCycle("maitrise");

        EligibilityResult result = service.checkEligibility(course, req);

        assertFalse(result.isEligible());
        assertEquals("Cours réservé au baccalauréat", result.getMessage());
    }

    @Test
    void eligibilitySucceedsWhenAllConditionsMet() {
        Course course = new Course();
        course.setPrerequisite_courses(List.of("IFT1015"));

        EligibilityRequest req = new EligibilityRequest();
        req.setCompletedCourses(List.of("IFT1015"));
        req.setCycle("bac");

        EligibilityResult result = service.checkEligibility(course, req);

        assertTrue(result.isEligible());
        assertEquals("Étudiant éligible à ce cours", result.getMessage());
    }
}