package de.tinysite.pico.cloud.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PicoSiteTest {

    @Test
    public void testSiteTitleGetterAndSetter(){
        PicoSite picoSite =new PicoSite();
        picoSite.setSiteTitle("a+b");
        assertEquals("a b",picoSite.getSiteTitle(),"space in site title should be replaced with +");

    }
    @Test
    public void testuserFullNameGetterAndSetter(){
        PicoSite picoSite =new PicoSite();
        picoSite.setUserFullName("John+Doe");
        assertEquals("John Doe",picoSite.getUserFullName(), "space in site title should be replaced with +");

    }

}